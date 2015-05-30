package org.aracrown.commons.identity.adapters;

import java.time.ZoneId;

import org.junit.Assert;
import org.junit.Test;

public class ZoneIdXmlAdapterTest {
	@Test
	public void testDefault() throws Exception {
		ZoneIdXmlAdapter a = new ZoneIdXmlAdapter();
		Assert.assertEquals("Europe/Helsinki", a.marshal(ZoneId.of("Europe/Helsinki")));
		
		Assert.assertEquals(ZoneId.of("Europe/Helsinki"), a.unmarshal("Europe/Helsinki"));
	}
}
