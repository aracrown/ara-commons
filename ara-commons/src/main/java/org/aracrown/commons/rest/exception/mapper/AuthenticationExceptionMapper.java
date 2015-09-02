package org.aracrown.commons.rest.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.aracrown.commons.rest.LocalResponse;
import org.aracrown.commons.security.AuthenticationException;

@Provider
public class AuthenticationExceptionMapper implements ExceptionMapper<AuthenticationException> {

	@Override
	public Response toResponse(AuthenticationException exception) {
		return new LocalResponse(Status.UNAUTHORIZED, exception).build();
	}

}
