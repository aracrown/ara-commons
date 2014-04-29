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
package org.aracrown.commons.persistence;

/**
 * Entity related re-factored constants.
 * <p>
 * Here we keep max string length to avoid magic numbers.
 * <p>
 * For the same reason we may keep here other entity related constants, such as default sequence values.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 */
public final class Constants {
	/**
	 * Minimum length of string value.
	 */
	public static final int DEFAULT_MIN_STRING_LENGTH = 2;

	/**
	 * Maximum length of string value.
	 */
	public static final int DEFAULT_MAX_STRING_LENGTH = 255;

	/**
	 * The code string length value.
	 */
	public static final int DEFAULT_CODE_STRING_LENGTH = 3; 

	/**
	 * Minimum query length.
	 */
	public static final int DEFAULT_MIN_QUERY_STRING_LENGTH = 2;

	/**
	 * Maximum query length.
	 */
	public static final int DEFAULT_MAX_QUERY_STRING_LENGTH = 50;

	/**
	 * Minimum league year starts from.
	 */
	public static final int DEFAULT_MIN_YEAR_START = 1900;

	private Constants() {
	}
}
