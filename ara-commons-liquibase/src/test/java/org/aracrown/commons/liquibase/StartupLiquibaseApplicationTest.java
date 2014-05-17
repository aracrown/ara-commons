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
package org.aracrown.commons.liquibase;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class StartupLiquibaseApplicationTest {
	EntityManager em = Mockito.mock(EntityManager.class);
	Session session = Mockito.mock(Session.class);

	@Test
	public void testOther() {
		Assert.assertNotNull(new StartupLiquibaseApplication());
	}

	@Test
	public void testStartup_1() {
		Mockito.when(em.unwrap(Session.class)).thenReturn(session);
		StartupLiquibaseApplication app = new StartupLiquibaseApplication(em, true);
		app.applicationStartup();
	}

	@Test
	public void testStartup_2() {
		Mockito.doThrow(new RuntimeException()).when(em).unwrap(Session.class);

		StartupLiquibaseApplication app = new StartupLiquibaseApplication(em, false);
		app.applicationStartup();
	}
	
	@Test
	public void testStartup_3() {
		Mockito.doThrow(new RuntimeException()).when(em).unwrap(Session.class);

		StartupLiquibaseApplication app = new StartupLiquibaseApplication(em, true);
		app.applicationStartup();
	}
}
