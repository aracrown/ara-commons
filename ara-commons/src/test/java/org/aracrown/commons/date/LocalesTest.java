package org.aracrown.commons.date;

import org.junit.Assert;
import org.junit.Test;

public class LocalesTest {
	@Test
	public void testDefault() {
		Assert.assertEquals(114, Locales.get().getAvailableLocales().size());
		Assert.assertEquals(114, Locales.get().getAvailableLocales().size());
	}
}
