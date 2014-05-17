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

import java.sql.SQLException;

import liquibase.exception.LiquibaseException;

import org.aracrown.commons.liquibase.ChangeLogExecutor;
import org.aracrown.commons.liquibase.JtaJdbcConnection;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ChangeLogExecutorTest {
	Session session = Mockito.mock(Session.class);
	
	@Test
	public void testStartup_1() throws LiquibaseException, SQLException {
		new ChangeLogExecutor(session, "").startup();
	}
	
	@Test
	public void testConnection_1() throws LiquibaseException, SQLException {
		JtaJdbcConnection c = new JtaJdbcConnection(null);
		Assert.assertFalse(c.getAutoCommit());
		c.rollback();
		c.commit();
		c.setAutoCommit(false);
	}
}
