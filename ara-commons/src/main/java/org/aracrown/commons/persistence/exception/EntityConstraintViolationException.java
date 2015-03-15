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

/**
 * The class <i>EntityConstraintViolationException</i> is a checked exception. It is used to notify the caller when entity constraint violation
 * occurs.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class EntityConstraintViolationException extends EntityValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 */
	public EntityConstraintViolationException(String message) {
		super(message, null);
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
	public EntityConstraintViolationException(String message, Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(message, constraintViolations);
	}
}
