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
package org.aracrown.commons.persistence.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.aracrown.commons.util.ConstraintViolationBuilder;

/**
 * Custom entity constraint violation exception for better readability purposes.
 * <p>
 * It formats all constraints into single ordered string in case we need to
 * display it somewhere, for example testing the output in junit tests
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class EntityValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The set of constraint violations. */
	private final Set<? extends ConstraintViolation<?>> constraintViolations;
	
	/**
	 * Default constructor takes constraint violation collection.
	 * 
	 * @param constraintViolations
	 *            set of unsorted violations
	 */
	public EntityValidationException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		this.constraintViolations = constraintViolations;
	}
	
	/**
	 * Default constructor takes constraint violation collection.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 * @param constraintViolations
	 *            set of unsorted violations
	 */
	public EntityValidationException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(message);
		this.constraintViolations = constraintViolations;
	}

	/**
	 * Converts set of constraints into String.
	 * 
	 * @return list of violations as a single string
	 */
	@Override
	public String toString() {
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			return ConstraintViolationBuilder.get().parseViolations(constraintViolations).toString();
		}
		return getMessage();
	}
}
