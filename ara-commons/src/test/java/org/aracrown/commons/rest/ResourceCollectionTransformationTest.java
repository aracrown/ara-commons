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
package org.aracrown.commons.rest;

import java.util.ArrayList;
import java.util.List;

import org.aracrown.commons.persistence.FakeEntity;
import org.junit.Test;

public class ResourceCollectionTransformationTest {
	@Test
	public void test_1() {
		List<FakeEntity> items = new ArrayList<>();
		FakeEntity c = new FakeEntity();
		c.setId(9998L);
		items.add(c);
		items.add(null);
		
		ResourceCollectionResponse<TestResource> t = new TestTransformation().page(0L, 10L).total(10L).total(5).transform(items);
		org.junit.Assert.assertEquals(new Long(1), t.getCount());
		org.junit.Assert.assertEquals(new Long(5), t.getTotal());
		org.junit.Assert.assertEquals(new Long(9998), t.getItems().get(0).getId());
		
		org.junit.Assert.assertEquals(new Long(0), new ResourceCollectionResponse<>(0L, 10L).getCurrentPage());
		org.junit.Assert.assertEquals(new Long(10), new ResourceCollectionResponse<>(0L, 10L).getPageSize());
		
	}
}
