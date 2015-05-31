package org.aracrown.commons.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.junit.Assert;
import org.junit.Test;

public class LocalResponseTest {
	@Test
	public void testDefault() {
		LocalResponse fixture = new LocalResponse(Status.BAD_REQUEST, new IllegalStateException("message"));
		Response r = fixture.build();
		Assert.assertEquals(Status.BAD_REQUEST.getStatusCode(), r.getStatus());
		
		Assert.assertEquals("true", r.getHeaderString(ExceptionResource.X_MAPPED_EXCEPTION_HEADER));
		Assert.assertEquals("java.lang.IllegalStateException", ((ExceptionResource)r.getEntity()).getExceptionClassName());
		Assert.assertEquals("message", ((ExceptionResource)r.getEntity()).getExceptionMessage());
	}
}
