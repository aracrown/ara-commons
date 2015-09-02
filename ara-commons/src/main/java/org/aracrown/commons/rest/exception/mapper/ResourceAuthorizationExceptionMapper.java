package org.aracrown.commons.rest.exception.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.aracrown.commons.rest.LocalResponse;
import org.aracrown.commons.rest.exception.ResourceAuthorizationException;

@Provider
public class ResourceAuthorizationExceptionMapper implements ExceptionMapper<ResourceAuthorizationException> {

	@Override
	public Response toResponse(ResourceAuthorizationException exception) {
		return new LocalResponse(Status.NOT_FOUND, exception).build();
	}

}
