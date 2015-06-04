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
package org.aracrown.commons.rest.exception;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ResourceDeleteExceptionTest {
	@Test
	public void test_1() {
		Assert.assertEquals("test", new ResourceDeleteException("test", null).getMessage());
		Assert.assertEquals("test", new ResourceDeleteException("test").getMessage());
		Assert.assertEquals("test", new ResourceDeleteException("test").getFirstError().getKey());
		Assert.assertEquals("test", new ResourceDeleteException("test").getFirstError().getMessage());
	}
	
	@Test
	public void test_2() {
		Assert.assertNull(new ResourceDeleteException(null).getFirstError());
	}
	
	@Test
	public void testParseErrorObject() {
		ErrorMessage m = new ResourceDeleteException("key!:!value", null).getErrors().get(0);
		Assert.assertEquals("value", m.getMessage());
		Assert.assertEquals("key", m.getKey());
	}
	
	@Test
	public void testParseTwoErrorObjects() {
		List<ErrorMessage> items = new ResourceDeleteException("key!:!value!~!key1!:!value1", null).getErrors();
		ErrorMessage m = items.get(0);
		Assert.assertEquals("value", m.getMessage());
		Assert.assertEquals("key", m.getKey());
		
		m = items.get(1);
		Assert.assertEquals("value1", m.getMessage());
		Assert.assertEquals("key1", m.getKey());
	}
}
