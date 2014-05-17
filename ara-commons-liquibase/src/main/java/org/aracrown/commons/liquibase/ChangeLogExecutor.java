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

import org.hibernate.Session;

/**
 * Executes liquibase changelogs when required.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class ChangeLogExecutor {
	/** Unwrapped hibernate session. */
	private final Session session;

	/** Changelog to be executed. */
	private final String changeLogFile;

	/**
	 * Default constructor.
	 * 
	 * @param session
	 *            unwrapped hibernate session
	 * @param changeLogFile
	 *            changelog to be executed
	 */
	public ChangeLogExecutor(Session session, String changeLogFile) {
		this.session = session;
		this.changeLogFile = changeLogFile;
	}

	/**
	 * Performs startup liquibase scripts.
	 */
	public void startup() {
		liquibaseStartup();
	}

	private void liquibaseStartup() {
		session.doWork(new StartupWork(changeLogFile));
	}
}
