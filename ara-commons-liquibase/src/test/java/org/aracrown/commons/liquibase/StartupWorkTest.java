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

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import liquibase.Liquibase;
import liquibase.exception.LiquibaseException;

import org.aracrown.commons.liquibase.StartupWork;
import org.hibernate.Session;
import org.junit.Test;
import org.mockito.Mockito;

public class StartupWorkTest {
	@Test
	public void test_1() throws SQLException {
		Connection connection = Mockito.mock(Connection.class);
		final Liquibase lb = Mockito.mock(Liquibase.class);
		
		new StartupWork("") {
			protected liquibase.Liquibase getLiquibase(Connection connection) throws liquibase.exception.LiquibaseException {
				return lb;
			};
		}.execute(connection);
		
	}
	
	@Test(expected=SQLException.class)
	public void test_2() throws SQLException, LiquibaseException {
		Connection connection = Mockito.mock(Connection.class);
		final Liquibase lb = Mockito.mock(Liquibase.class);
		Mockito.doThrow(new RuntimeException()).when(lb).update(Mockito.anyString());
		new StartupWork("") {
			protected liquibase.Liquibase getLiquibase(Connection connection) throws liquibase.exception.LiquibaseException {
				return lb;
			};
		}.execute(connection);
		
	}
	
	@Test
	public void test_3() throws SQLException, LiquibaseException {
		EntityManager entityManager = Persistence.createEntityManagerFactory("liquibase").createEntityManager();
		
		Session session = entityManager.unwrap(Session.class);
		new ChangeLogExecutor(session, "changelogs/changelog-master.xml").startup();

	}
}
