package org.aracrown.commons.rest;

import org.junit.Assert;
import org.junit.Test;

public class ExceptionResourceTest {
	@Test
	public void testDefault() {
		ExceptionResource fixture = new ExceptionResource(new IllegalStateException("message"));
		Assert.assertEquals("java.lang.IllegalStateException", fixture.getExceptionClassName());
		Assert.assertEquals("message", fixture.getExceptionMessage());
	}
	
	@Test
	public void testManual() {
		ExceptionResource fixture = new ExceptionResource();
		fixture.setExceptionClassName("java.lang.IllegalStateException");
		fixture.setExceptionMessage("message");
		Assert.assertEquals("java.lang.IllegalStateException", fixture.getExceptionClassName());
		Assert.assertEquals("message", fixture.getExceptionMessage());
	}
	
	@Test
	public void testNoMessage() {
		ExceptionResource fixture = new ExceptionResource(new IllegalStateException());
		Assert.assertEquals("java.lang.IllegalStateException", fixture.getExceptionClassName());
		Assert.assertEquals("Unknown error.", fixture.getExceptionMessage());
	}
}
