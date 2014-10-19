package org.aracrown.commons.util;

import org.junit.Assert;
import org.junit.Test;

public class RandomStringGeneratorTest {
	@Test
	public void testDefault() {
		String rnd = new RandomStringGenerator().generateHex();
		Assert.assertNotNull(rnd);
		Assert.assertEquals(128, rnd.length());
		Assert.assertTrue(rnd, rnd.matches("^[a-zA-Z0-9]+$"));
	}

	@Test
	public void testPassword() {
		for (int i = 0; i < 100; i++) {
			String rnd = new RandomStringGenerator().generate(15);
			Assert.assertNotNull(rnd);
			Assert.assertEquals(15, rnd.length());
			Assert.assertTrue(rnd, rnd.matches("^[a-zA-Z0-9+@\\-_#$!:;|&%()*]+$"));
		}
	}
}
