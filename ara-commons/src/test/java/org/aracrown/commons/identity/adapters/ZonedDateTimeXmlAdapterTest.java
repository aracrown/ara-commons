package org.aracrown.commons.identity.adapters;

import org.aracrown.commons.date.IsoDateUtil;
import org.junit.Assert;
import org.junit.Test;

public class ZonedDateTimeXmlAdapterTest {
	@Test
	public void testDefault() throws Exception {
		ZonedDateTimeXmlAdapter a = new ZonedDateTimeXmlAdapter();
		Assert.assertEquals("1990-01-01T10:00:00Z", a.marshal(IsoDateUtil.get().parse("1990-01-01T12:00:00+02:00")));
		
		Assert.assertEquals(IsoDateUtil.get().parse("1990-01-01T12:00:00+02:00"), a.unmarshal("1990-01-01T12:00:00+02:00"));
	}
}
