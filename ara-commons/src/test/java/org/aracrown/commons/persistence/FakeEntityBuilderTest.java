package org.aracrown.commons.persistence;

import org.aracrown.commons.persistence.exception.EntityValidationException;
import org.junit.Assert;
import org.junit.Test;


public class FakeEntityBuilderTest {

	@Test(expected=EntityValidationException.class)
	public void testDefault() {
		Assert.assertNotNull(new FakeEntityBuilder().build());
	}
	
	@Test
	public void testNoError() {
		Assert.assertNotNull(new FakeEntityBuilder().name("name").build());
	}
	
	@Test
	public void testNoValidation() {
		Assert.assertNotNull(new FakeEntityBuilder().name("name").buildNoValidation());
	}
}
