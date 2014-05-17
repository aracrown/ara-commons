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

import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;

/**
 * Transaction management is provided to JTA. Liquibase should not commit or rollback any transaction.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class JtaJdbcConnection extends JdbcConnection {
	/**
	 * Default constructor.
	 * 
	 * @param connection
	 *            jdbc connection
	 */
	public JtaJdbcConnection(Connection connection) {
		super(connection);
	}

	@Override
	public boolean getAutoCommit() throws DatabaseException {
		return false;
	}

	@Override
	public void rollback() throws DatabaseException {
		// Rollback is maintained by JTA
	}

	@Override
	public void commit() throws DatabaseException {
		// Commit is maintained by JTA
	}

	@Override
	public void setAutoCommit(boolean autoCommit) throws DatabaseException {
		// No autocommit is used here.
	}
}
