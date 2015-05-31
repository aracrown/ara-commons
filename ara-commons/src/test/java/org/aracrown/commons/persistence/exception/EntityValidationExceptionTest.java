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

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.aracrown.commons.persistence.FakeEntity;
import org.junit.Test;

public class EntityValidationExceptionTest {

	@Test
	public void testEntityValidationException() {
		Set<? extends ConstraintViolation<?>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(new FakeEntity());
		EntityValidationException ex = new EntityValidationException(constraintViolations);
		org.junit.Assert.assertEquals("Name is missing", ex.toString());
	}
	
	@Test
	public void testEntityValidationExceptionMessageOnly() {
		EntityValidationException ex = new EntityValidationException("Name is missing", null);
		org.junit.Assert.assertEquals("Name is missing", ex.toString());
		
		ex = new EntityValidationException("Name is missing", new HashSet<>());
		org.junit.Assert.assertEquals("Name is missing", ex.toString());
	}
}
