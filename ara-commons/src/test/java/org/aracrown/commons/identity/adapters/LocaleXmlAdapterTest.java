package org.aracrown.commons.identity.adapters;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class LocaleXmlAdapterTest {
	@Test
	public void testDefault() throws Exception {
		LocaleXmlAdapter a = new LocaleXmlAdapter();
		Assert.assertEquals("en", a.marshal(Locale.ENGLISH));
		
		Assert.assertEquals(Locale.ENGLISH, a.unmarshal("en"));
	}
}
