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

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class AbstractDaoTest {
	protected static EntityManager em;
	protected static EntityManagerFactory emf;

	@Before
	public void startTransaction() throws Exception {
		em.getTransaction().begin();
		em.clear();
	}

	@After
	public void rollbackTransaction() {
		em.getTransaction().rollback();
	}

	@BeforeClass
	public static void setup() throws Exception {
		emf = Persistence.createEntityManagerFactory("sports");
		em = emf.createEntityManager();
	}

	@AfterClass
	public static void close() {
		em.close();
		emf.close();
	}

	protected FakeEntityDao newFakeEntityDao() {
		return new FakeEntityDao(em);
	}
}
