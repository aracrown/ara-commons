/*
 * Copyright 2013 ARA Crown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aracrown.commons.date;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class IsoDateUtilTest {
	@Test
	public void testDate1() throws ParseException {
		String dateString = "1990-01-01T10:00:00+0000";
		ZonedDateTime date = IsoDateUtil.get().parse(dateString);
		Assert.assertEquals("1990-01-01T10:00:00Z", date.toInstant().toString());

		Assert.assertEquals("1990-01-01T10:00:00Z", IsoDateUtil.get().format(date));

		Assert.assertEquals("1990-01-01T12:00:00+02:00", IsoDateUtil.get().format(date, ZoneId.of("GMT+2")));

		Assert.assertEquals("1990-01-01T21:00:00+11:00", IsoDateUtil.get().format(dateString, ZoneId.of("Australia/Sydney")));

		Assert.assertEquals("2013-12-06T20:45:00+01:00", IsoDateUtil.get().format("2013-12-06T20:45:00+01:00", ZoneId.of("GMT+1")));

		Assert.assertEquals("1990-01-01T21:00:00+11:00", IsoDateUtil.get().format(date, ZoneId.of("Australia/Sydney")));

		Assert.assertEquals("Jan 1, 1990 9:00:00 PM", IsoDateUtil.get().format(date, Locale.ENGLISH, ZoneId.of("Australia/Sydney")));

		Assert.assertEquals("1990-01-01Z", IsoDateUtil.get().formatNoTime(date));

		Assert.assertEquals("2012-02-15Z", IsoDateUtil.get().formatNoTime(IsoDateUtil.get().parseNoTime("2012-02-15")));

		Assert.assertNull(IsoDateUtil.get().format(null, Locale.ENGLISH, ZoneId.of("Australia/Sydney")));
		Assert.assertNull(IsoDateUtil.get().formatNoTime(null));
		Assert.assertNull(IsoDateUtil.get().parseNoTime(null));

		// Check midnight format for specific date
		ZonedDateTime d1 = IsoDateUtil.get().parse("2013-12-06T20:45:00+01:00");
		String formattedDate = IsoDateUtil.get().format(d1, ZoneId.of("GMT+1")).replaceAll("20:45:00", "00:00:00");

		Assert.assertEquals(formattedDate, IsoDateUtil.get().format(IsoDateUtil.get().midnight(d1), ZoneId.of("GMT+1")));

		// Check midnight format for now
		ZoneId localZoneId = ZoneId.systemDefault();
		ZonedDateTime d2 = IsoDateUtil.get().midnight();
		String formattedDate2 = IsoDateUtil.get().format(d2, localZoneId);

		String actualDate2 = IsoDateUtil.get().format(d2, localZoneId);
		Assert.assertEquals(formattedDate2, actualDate2);
	}
}
