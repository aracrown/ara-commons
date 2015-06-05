package org.aracrown.commons.security;

import org.junit.Assert;
import org.junit.Test;

public class SecurityTest {
	@Test
	public void testDefault() {
		Assert.assertEquals("EMAIL", SamlLoginModuleAttributes.EMAIL.name());
		Assert.assertEquals(SamlLoginModuleAttributes.EMAIL, SamlLoginModuleAttributes.valueOf(SamlLoginModuleAttributes.EMAIL.toString()));
	}
}
