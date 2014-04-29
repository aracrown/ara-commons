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
package org.aracrown.commons.util;

import java.text.ParseException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

import com.google.common.base.Preconditions;

/**
 * Small utility class to format date time into ISO format.
 * <p>
 * Format: <b>"yyyy-MM-dd'T'HH:mm:ss.SSS zzz"</b>
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public final class IsoDateUtil {
	
	/** Support for date and time with 'HHmm', for example, '2010-01-01T10:00:00+0200'*/
	private static final String ISO_OFFSET_DATE_TIME_XX = "yyyy-MM-dd'T'HH:mm:ssXX";
	
	/** The singleton instance. */
	private static IsoDateUtil instance;

	private IsoDateUtil() {
	}

	/**
	 * The getter for a singleton instance of iso date utility class.
	 * 
	 * @return static instance
	 */
	public static IsoDateUtil get() {
		if (instance == null) {
			instance = new IsoDateUtil();
		}
		return instance;
	}

	/**
	 * Formats provided date into ISO date time format with provided time zone.
	 * 
	 * @param date
	 *            provided date to format
	 * @param timeZone
	 *            provided time zone to use
	 * @return formatted date in ISO format (yyyy-MM-dd'T'HH:mm:ss.SSS zzz) and provided time zone
	 */
	public String format(ZonedDateTime date, ZoneId timeZone) {
		Preconditions.checkNotNull(date, "Date parameter is missing.");
		
		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		
		return builder.toFormatter().format(date.withZoneSameInstant(timeZone));
	}

	/**
	 * Formats provided date into ISO date time format with UTC time zone.
	 * 
	 * @param date
	 *            provided date to format
	 * @return formatted date in ISO format (yyyy-MM-dd'T'HH:mm:ss.SSS zzz) and UTC time zone
	 */
	public String format(ZonedDateTime date) {
		return format(date, ZoneOffset.UTC);
	}

	/**
	 * Takes existing date in ISO format and converts it into different time zone.
	 * 
	 * @param gameDate
	 *            ISO date as a String which should be parsed.
	 * @param timeZone
	 *            the given new time zone.
	 * @return the formatted time string in new time zone format.
	 * @throws ParseException
	 *             if specified string cannot be parsed.
	 */
	public String format(String gameDate, ZoneId timeZone) throws ParseException {
		return format(parse(gameDate), timeZone);
	}
	
	/**
	 * 
	 * @param date
	 *            ISO date as a String which should be parsed.
	 * @return A Date parsed from the string.
	 * @throws DateTimeParseException
	 *             if specified string cannot be parsed.
	 */
	public ZonedDateTime parse(String date) throws DateTimeParseException {
		try {
			return parseDefault(date);
		} catch (DateTimeParseException e) {
			return parseCustom(date);
		}
	}
	
	private ZonedDateTime parseCustom(String dateString) {
		DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern(ISO_OFFSET_DATE_TIME_XX).toFormatter();				
		return ZonedDateTime.parse(dateString, df);
	}

	private ZonedDateTime parseDefault(String dateString) {
		DateTimeFormatter df = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_OFFSET_DATE_TIME).toFormatter();		
		return ZonedDateTime.parse(dateString, df);
	}
}
