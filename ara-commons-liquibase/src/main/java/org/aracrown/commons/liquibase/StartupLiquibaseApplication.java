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

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.aracrown.commons.liquibase.annotations.LiquibasePersistenceContext;
import org.aracrown.commons.liquibase.annotations.LiquibaseStartupEnabled;
import org.hibernate.Session;
import org.slf4j.Logger;

/**
 * Application startup scripts, like initialize database with some data, other required scripts.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
@Singleton
@Startup
@TransactionManagement(TransactionManagementType.BEAN)
public class StartupLiquibaseApplication {
	/** The logger scripts. */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(StartupLiquibaseApplication.class);

	/** The liquibase changelog file. */
	private static final String CHANGE_LOG_FILE = "changelogs/changelog-master.xml";

	/** Injected persistence context. */
	@Inject
	@LiquibasePersistenceContext
	private EntityManager entityManager;
	
	/** Is liquibase enabled on startup. */
	@Inject
	@LiquibaseStartupEnabled
	private boolean liquibaseStartupEnabled;

	/**
	 * Default constructor.
	 */
	public StartupLiquibaseApplication() {
	}

	StartupLiquibaseApplication(EntityManager entityManager, boolean liquibaseStartupEnabled) {
		this.entityManager = entityManager;
		this.liquibaseStartupEnabled = liquibaseStartupEnabled;
	}

	/**
	 * Scripts, performed on the application startup.
	 */
	@PostConstruct
	public void applicationStartup() {
		if (!liquibaseStartupEnabled) {
			LOGGER.info("Liquibase disabled. Skipping startup scripts...");
			return;
		}
		LOGGER.info("Executing liquibase startup scripts...");
		try {
			Session session = entityManager.unwrap(Session.class);
			new ChangeLogExecutor(session, CHANGE_LOG_FILE).startup();
		} catch (Exception e) {
			LOGGER.error("Error occured when trying to setup the database.", e);
		}
		LOGGER.info("Executing liquibase startup scripts...Done.");
	}
}
