package org.aracrown.commons.rest;

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

	/**
	 * Constructor to {@link javax.ws.rs.core.Response} object.
	 *
	 * @param errorStatus error status code
	 * @param throwable   exception thrown
	 */
	public LocalResponse(Status errorStatus, Throwable throwable) {
		this.errorStatus = errorStatus;
		this.throwable = throwable;
	}

	/**
	 * Builds response with status code and exception information.
	 *
	 * @return built response instance
	 */
	public Response build() {
		if (LOGGER.isWarnEnabled()) {
			LOGGER.warn(String.format("Mapping the exception of status: %s, Error message: %s", errorStatus, throwable.getMessage()), throwable);
		}
		return Response.status(errorStatus).entity(new RestException(throwable)).header(RestException.X_MAPPED_EXCEPTION_HEADER, Boolean.TRUE)
				.build();
	}
}
