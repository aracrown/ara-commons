package org.aracrown.commons.rest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import org.apache.commons.codec.CharEncoding;
import org.aracrown.commons.rest.exception.PlainResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;

/**
 * Client tries to recover exception into runtime exception. Throws runtime
 * exception with message if the original exception cannot be re-constructed.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 */
public class ExceptionResolverInterceptor implements ClientResponseFilter {
	/** The logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionResolverInterceptor.class);

	private Throwable parseException(ClientResponseContext context) {
		Throwable throwable = null;
		try {
			throwable = constructThrowable(context);
		} catch (Exception e) {
			LOGGER.error("Error while constructing client exception instance", e);
			throwable = e;
		}
		return throwable;
	}

	private Throwable constructThrowable(ClientResponseContext context) throws ClassNotFoundException, NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException, UnsupportedEncodingException {
		Preconditions.checkNotNull(context.getEntityStream(), "Content as input stream is missing.");
		ExceptionResource entity = new Gson().fromJson(new InputStreamReader(context.getEntityStream(), CharEncoding.UTF_8), ExceptionResource.class);
		return newInstance(entity);
	}

	private Throwable newInstance(ExceptionResource entity)
			throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		Class<?> exceptionClass = Class.forName(entity.getExceptionClassName());
		if (PlainResourceException.class.isAssignableFrom(exceptionClass)) {
			Constructor<?> exceptionConstructor = exceptionClass.getDeclaredConstructor(new Class[] { String.class, String.class });
			return (Throwable) exceptionConstructor.newInstance(entity.getExceptionMessage(), entity.getDescription());
		}
		Constructor<?> exceptionConstructor = exceptionClass.getDeclaredConstructor(new Class[] { String.class });
		
		return (Throwable) exceptionConstructor.newInstance(entity.getExceptionMessage());
	}

	@Override
	public void filter(ClientRequestContext requestContext, ClientResponseContext responseContext) throws IOException {
		if (!responseContext.getHeaders().containsKey(ExceptionResource.X_MAPPED_EXCEPTION_HEADER)) {
			return;
		}
		Throwable throwable = parseException(responseContext);
		if (throwable instanceof RuntimeException) {
			throw (RuntimeException) throwable;
		}
		throw new RuntimeException(throwable);
	}

}
