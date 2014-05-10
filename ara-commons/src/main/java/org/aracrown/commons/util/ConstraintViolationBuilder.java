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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Simple wrapper of bean validation constraints.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public final class ConstraintViolationBuilder {
	/** Violation list item separator. */
	public static final String VIOLATION_SEPARATOR = "!~!";

	/** Violation key and message separator. */
	public static final String KEY_SEPARATOR = "!:!";

	/** The singleton instance. */
	private static ConstraintViolationBuilder instance;

	private ConstraintViolationBuilder() {
	}

	/**
	 * The getter for a singleton instance of violation builder.
	 * 
	 * @return static instance
	 */
	public static ConstraintViolationBuilder get() {
		if (instance == null) {
			instance = new ConstraintViolationBuilder();
		}
		return instance;
	}

	/**
	 * Formats constraint violations into string builder.
	 * <p>
	 * If value was violated then we have such structure:
	 * 
	 * <pre>
	 * &lt;invalid value&gt; : &lt;constraint violation message&gt;
	 * </pre>
	 * <p>
	 * Otherwise the structure is such:
	 * 
	 * <pre>
	 * class &lt;violated class name&gt;.&lt;property name&gt; : &lt;constraint violation message&gt;
	 * </pre>
	 * 
	 * @param constraintViolations
	 *            constraint violations to work on
	 * @return formatter violations into string builder
	 */
	public StringBuilder parseViolations(Set<? extends ConstraintViolation<?>> constraintViolations) {
		/** Sorting just for unit testing purposes */
		List<ConstraintViolation<?>> constraintViolations1 = new ArrayList<>(constraintViolations);

		Collections.sort(constraintViolations1, (ConstraintViolation<?> o1, ConstraintViolation<?> o2) -> o1.toString().compareTo(o2.toString()));

		StringBuilder constraintViolationBuilder = new StringBuilder();

		constraintViolations1.forEach(constraintViolation -> {
			if (constraintViolationBuilder.length() > 0) {
				constraintViolationBuilder.append(VIOLATION_SEPARATOR);
			}
			String message = constraintViolation.getMessage();
			constraintViolationBuilder.append(message);
		});

		return constraintViolationBuilder;
	}
}
