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

import org.aracrown.commons.persistence.exception.EntityConstraintViolationException;
import org.junit.Assert;
import org.junit.Test;

public class EntityConstraintViolationExceptionTest {
	@Test
	public void testException_1() {
		try {
			Set<ConstraintViolation<String>> items = new HashSet<>();
			throw new EntityConstraintViolationException("message", items);
		} catch (EntityConstraintViolationException e) {
			Assert.assertEquals("message", e.getMessage());
		}
	}

	@Test
	public void testException_2() {
		try {
			throw new EntityConstraintViolationException("message");
		} catch (EntityConstraintViolationException e) {
			Assert.assertEquals("message", e.getMessage());
		}
	}
}
