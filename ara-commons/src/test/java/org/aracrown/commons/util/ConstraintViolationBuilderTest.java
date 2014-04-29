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

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.junit.Test;

public class ConstraintViolationBuilderTest {
	@Test
	public void test_1() {
		Set<? extends ConstraintViolation<?>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(new TestItem());
		org.junit.Assert.assertEquals("Name is missing!~!Value is missing", ConstraintViolationBuilder.get().parseViolations(constraintViolations)
				.toString());
	}

	@Test
	public void test_2() {
		TestItem ti = new TestItem();
		ti.setValue1("1");
		Set<? extends ConstraintViolation<?>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(ti);
		org.junit.Assert.assertEquals("Name is missing!~!Value is missing!~!Value size must be between 3 and 5", ConstraintViolationBuilder.get()
				.parseViolations(constraintViolations).toString());
	}
}
