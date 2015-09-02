package org.aracrown.commons.rest;

import org.aracrown.commons.rest.exception.PlainResourceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Custom utility class to properly transform exception for client needs.
 *
 * @author vicento.ramos
 * @since 1.0.0
 */
public final class LocalResponse {
	/**
	 * The logger instance.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LocalResponse.class);

	private final Status errorStatus;
	private final Throwable throwable;
	private final String description;

	/**
	 * Constructor to {@link javax.ws.rs.core.Response} object.
	 *
	 * @param errorStatus
	 *            error status code
	 * @param throwable
	 *            exception thrown
	 */
	public LocalResponse(Status errorStatus, Throwable throwable) {
		this.errorStatus = errorStatus;
		this.throwable = throwable;
		if (throwable instanceof PlainResourceException) {
			this.description = ((PlainResourceException)throwable).getDescription();
		} else {
			this.description = null;
		}
	}

	/**
	 * Builds response with status code and exception information.
	 *
	 * @return built response instance
	 */
	public Response build() {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(String.format("Mapping the exception of status: %s, Error message: %s", errorStatus, throwable.getMessage()), throwable);
		}
		return Response.status(errorStatus).entity(new ExceptionResource(throwable, description)).header(ExceptionResource.X_MAPPED_EXCEPTION_HEADER, Boolean.TRUE)
				.build();
	}
}
