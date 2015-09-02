/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aracrown.commons.util;

import com.google.common.base.Strings;

/**
 * Simple url utility class, which helps to construct URL representation in browser
 * 
 * @author turisto
 */
public class UrlUtil {
	private static final String REGEX_DELIM_UNDER = "-";

	/**
	 * Checks if context and value have duplication of DELIMITER
	 * 
	 * @param context
	 *            string which will be added to the beginning of value
	 * @param value
	 *            string which will be added after context
	 * @return concatenated string, for example if we have context="context" and value="/value" then result would be "context/value"
	 */
	public static String mergeIntoUrl(String context, String value) {
		if (Strings.isNullOrEmpty(context)) {
			return value;
		}
		if (Strings.isNullOrEmpty(value)) {
			return context;
		}
		if (context.endsWith(DelimiterEnum.SLASH.value()) && value.startsWith(DelimiterEnum.SLASH.value())) {
			return context + value.substring(1);
		} else if (!context.endsWith(DelimiterEnum.SLASH.value()) && !value.startsWith(DelimiterEnum.SLASH.value())) {
			return context + DelimiterEnum.SLASH.value() + value;
		} else {
			return context + value;
		}
	}

	/**
	 * Transliterates provided string and removes non-characters
	 * 
	 * @param value
	 *            string value to transliterate and remove non-characters
	 * @return string representation of encoded value
	 */
	public static String encode(String value) {
		if (Strings.isNullOrEmpty(value)) {
			return null;
		}
		value = value.trim();
		value = TransliterateUtils.transliterate(value);
		value = value.replaceAll("[^a-zA-Z0-9\\s-]", DelimiterEnum.EMPTY.value());
		value = value.replaceAll(DelimiterEnum.SPACE.value(), REGEX_DELIM_UNDER);
		return value.replaceAll("---", "-");
	}
}
