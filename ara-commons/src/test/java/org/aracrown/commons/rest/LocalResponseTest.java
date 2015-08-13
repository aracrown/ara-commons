package org.aracrown.commons.rest;

import javax.ws.rs.core.Response.Status;

import org.aracrown.commons.rest.exception.ResourceNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class LocalResponseTest {
	@Test
	public void testDefault() {
		Assert.assertEquals(Status.BAD_GATEWAY.getStatusCode(), new LocalResponse(Status.BAD_GATEWAY, new ResourceNotFoundException("not_found")).build().getStatus());
	}
	
	@Test
	public void testExceptionResource() {
		ExceptionResource r = (ExceptionResource)new LocalResponse(Status.BAD_GATEWAY, new ResourceNotFoundException("not_found")).build().getEntity();
		Assert.assertEquals(ResourceNotFoundException.class.getName(), r.getExceptionClassName());
		Assert.assertEquals("not_found", r.getExceptionMessage());
	}
	
	@Test
	public void testExceptionResourceNoMessage() {
		ExceptionResource r = (ExceptionResource)new LocalResponse(Status.BAD_GATEWAY, new IllegalStateException()).build().getEntity();
		Assert.assertEquals(IllegalStateException.class.getName(), r.getExceptionClassName());
		Assert.assertEquals("Unknown error.", r.getExceptionMessage());
	}
	@Test
	public void testExceptionResourceNoConstructor() {
		ExceptionResource r = new ExceptionResource();
		r.setExceptionClassName(IllegalStateException.class.getName());
		r.setExceptionMessage("Known error.");
		Assert.assertEquals(IllegalStateException.class.getName(), r.getExceptionClassName());
		Assert.assertEquals("Known error.", r.getExceptionMessage());
	}
}
