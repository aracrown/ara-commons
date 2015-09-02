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

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.Locale;

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
	/** The logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(IsoDateUtil.class);

	/**
	 * Support for date and time with 'HHmm', for example,
	 * '2010-01-01T10:00:00+0200'
	 */
	public static final String ISO_OFFSET_DATE_TIME_XX = "yyyy-MM-dd'T'HH:mm:ssXX";

	/**
	 * Support for date, for example, '2010-01-01'
	 */
	public static final String ISO_DATE = "yyyy-MM-dd";

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
	 * @return formatted date in ISO format (yyyy-MM-dd'T'HH:mm:ss.SSS zzz) and
	 *         provided time zone
	 */
	public String format(ZonedDateTime date, ZoneId timeZone) {
		Preconditions.checkNotNull(date, "Date parameter is missing.");

		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().append(DateTimeFormatter.ISO_OFFSET_DATE_TIME);

		return builder.toFormatter().format(date.withZoneSameInstant(timeZone));
	}

	/**
	 * Formats provided date using provided {@link Locale} and {@link ZoneId}.
	 * 
	 * @param date
	 *            provided date to format
	 * @param locale
	 *            locale to be used while formatting the date
	 * @param zoneId
	 *            provided time zone id
	 * @return formatted date with provided locale
	 */
	public String format(ZonedDateTime date, Locale locale, ZoneId zoneId) {
		if (date == null) {
			return null;
		}

		DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().appendLocalized(FormatStyle.MEDIUM, FormatStyle.MEDIUM);

		return builder.toFormatter(locale).format(date.withZoneSameInstant(zoneId));
	}

	/**
	 * Formats provided date into ISO date time format with UTC time zone.
	 * 
	 * @param date
	 *            provided date to format
	 * @return formatted date in ISO format (yyyy-MM-dd'T'HH:mm:ss.SSS zzz) and
	 *         UTC time zone
	 */
	public String format(ZonedDateTime date) {
		return format(date, ZoneOffset.UTC);
	}

	/**
	 * Takes existing date in ISO format and converts it into different time
	 * zone.
	 * 
	 * @param gameDate
	 *            ISO date as a String which should be parsed.
	 * @param timeZone
	 *            the given new time zone.
	 * @return the formatted time string in new time zone format.
	 */
	public String format(String gameDate, ZoneId timeZone) {
		return format(parse(gameDate), timeZone);
	}

	/**
	 * 
	 * @param date
	 *            ISO date as a String which should be parsed.
	 * @return A Date parsed from the string.
	 */
	public ZonedDateTime parse(String date) {
		try {
			return parseDefault(date);
		} catch (DateTimeParseException e) {
			LOGGER.debug("Default date parsing failed.", e);
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

	public String formatDate(ZonedDateTime date) {
		if (date == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		return formatter.format(date);
	}
	
	public String formatTime(ZonedDateTime date) {
		if (date == null) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ISO_TIME;

		return formatter.format(date);
	}

	public ZonedDateTime parseNoTime(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;

		LocalDate localDate = LocalDate.parse(value, formatter);

		return ZonedDateTime.of(localDate, LocalTime.now(), ZoneOffset.UTC);
	}

	public ZonedDateTime midnight(ZonedDateTime dateTime) {
		return dateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);
	}

	public ZonedDateTime midnight() {
		return midnight(ZonedDateTime.now());
	}
}
