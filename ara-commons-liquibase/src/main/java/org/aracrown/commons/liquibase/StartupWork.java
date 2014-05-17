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

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import org.hibernate.jdbc.Work;

/**
 * Hibernate work on system startup.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class StartupWork implements Work {
	/** Changelog file to execute. */
	private final String changeLogFile;

	/**
	 * Default constructor.
	 * 
	 * @param changeLogFile
	 *            changelog file to execute
	 */
	public StartupWork(String changeLogFile) {
		this.changeLogFile = changeLogFile;
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		try {
			Liquibase liquibase = getLiquibase(connection);
			liquibase.update("");
		} catch (Exception e) {
			throw new SQLException("Setup failed", e);
		}
	}

	protected Liquibase getLiquibase(Connection connection) throws LiquibaseException {
		Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JtaJdbcConnection(connection));
		return new Liquibase(changeLogFile, new ClassLoaderResourceAccessor(), database);
	}
}
