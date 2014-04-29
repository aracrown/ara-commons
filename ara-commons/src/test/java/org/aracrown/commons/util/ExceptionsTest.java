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

import org.junit.Test;

public class ExceptionsTest {
	@Test(expected = RuntimeException.class)
	public void test_1() {
		try {
			throw new NullPointerException();
		} catch (NullPointerException e) {
			Exceptions.get().throwNewIfContains(e, NullPointerException.class, new RuntimeException("message"));

		}
	}

	@Test(expected = RuntimeException.class)
	public void test_2() {
		try {
			throw new NullPointerException("test");
		} catch (NullPointerException e) {
			Exceptions.get().throwNewIfContains(e, NullPointerException.class, new RuntimeException("message"));

		}
	}
	
	@Test
	public void test_3() {
		try {
			throw new NullPointerException("test");
		} catch (NullPointerException e) {
			Exceptions.get().throwNewIfContains(e, IllegalStateException.class, new RuntimeException("message"));
			org.junit.Assert.assertTrue(true);
		}
	}
}
