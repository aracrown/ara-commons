package org.aracrown.commons.date;

import org.junit.Assert;
import org.junit.Test;

public class TimeZoneEnumTest {
	@Test
	public void testDefault() {
		TimeZoneEnum tz = TimeZoneEnum.GMTM0100_AMERICA_SCORESBYSUND;
		Assert.assertEquals("GMTM0100_AMERICA_SCORESBYSUND", tz.name());
		Assert.assertEquals("GMT-01:00", tz.getGmt());
		Assert.assertEquals("America/Scoresbysund", tz.getTimeZoneId());
		Assert.assertEquals("(GMT-01:00/DST) America/Scoresbysund", tz.getName());
		Assert.assertTrue(tz.isDaylightSavings());

		Assert.assertNotNull(GMT.GMTM0100);
	}
}
