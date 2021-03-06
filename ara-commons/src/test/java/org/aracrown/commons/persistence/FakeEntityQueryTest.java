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

import org.junit.Assert;
import org.junit.Test;

public class FakeEntityQueryTest extends AbstractDaoTest {
	@Test
	public void testJoins() {
		FakeEntityQuery query = new FakeEntityQuery(em);
		query.testFrom();
		query.testFrom();
		query.testJoin();
		query.testJoin();
		
		query.testSetJoin();
		query.testSetJoin();
		
		query.testListJoin();
		query.testListJoin();
		query.testLeftJoin();
		query.testLeftJoin();
		
		query.testLeftJoin2();
		query.testLeftJoin2();
		
		query.testCollectionJoin();
		query.testCollectionJoin();
	}

	@Test
	public void testCount() {
		Assert.assertEquals(new Long(0), new FakeEntityQuery(em).count());
	}

	@Test
	public void testSingleResult() {
		Assert.assertNull(new FakeEntityQuery(em).disableCaching().singleResult());
	}

	@Test
	public void testList() {
		Assert.assertEquals(0, new FakeEntityQuery(em).name("test").createdBy("test").distinct().list().size());
	}

	@Test
	public void testListPage() {
		Assert.assertEquals(0, new FakeEntityQuery(em).name("test").page(0L, 10L).list().size());
	}
}
