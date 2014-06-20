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
import javax.persistence.PersistenceException;

import org.aracrown.commons.persistence.exception.EntityDeleteException;
import org.aracrown.commons.persistence.exception.EntityNotFoundException;
import org.aracrown.commons.persistence.exception.EntitySaveException;
import org.aracrown.commons.persistence.exception.EntityValidationException;
import org.aracrown.commons.util.Exceptions;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author vicento.ramos
 * 
 * @param <T>
 *            entity type, which will be managed by this instance
 * @param <Q>
 *            Query type, used by this data access object
 * @since 1.0.0
 * 
 */
public abstract class AbstractDao<T, Q extends Query<T>> {

	/** The logger instance. */
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);

	/** entity class, served by this dao. */
	private final Class<T> entityClass;

	/**
	 * Constructor accepts generic entity class for further action.
	 * 
	 * @param entityClass
	 *            entity class, served by this dao
	 */
	public AbstractDao(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	/**
	 * Returns the entity manager.
	 * 
	 * @return entity manager instance to return
	 */
	protected abstract EntityManager getEntityManager();

	/**
	 * Returns entity class.
	 * 
	 * @return entity class to return
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * Returns entity by it's primary key.
	 * 
	 * @param primaryKey
	 *            primary key
	 * @return the found entity instance or null if the entity does not exist
	 * @throws EntityNotFoundException
	 *             thrown if entity was not found by it's primary key
	 */
	public <P> T byId(P primaryKey) throws EntityNotFoundException {
		T entity = getEntityManager().find(getEntityClass(), primaryKey);
		if (entity == null) {
			throw new EntityNotFoundException(String.format("Entity of type [%s] with primary key [%s] was not found.", getEntityClass()
					.getSimpleName().toLowerCase(), primaryKey));
		}
		return entity;
	}

	/**
	 * Saves the entity.
	 * 
	 * @param entity
	 *            object to save
	 * @return the managed instance that the state was merged to
	 * @throws EntitySaveException
	 *             exception is thrown if persistence engine was not able to
	 *             persist the entity.
	 * @throws EntityValidationException
	 *             constraint validation is thrown if was detected by exception
	 *             handler. Otherwise original exception is re-thrown.
	 */
	public <E> E save(E entity) throws EntitySaveException, EntityValidationException {
		E mergedEntity;
		try {
			mergedEntity = getEntityManager().merge(entity);
			getEntityManager().flush();
			return mergedEntity;
		} catch (javax.validation.ConstraintViolationException e) {
			String message = String.format("Persistence exception occurred when trying to validate the entity [%s].", entity);
			LOGGER.debug(message, e);
			throw new EntityValidationException(message, e.getConstraintViolations());
		} catch (PersistenceException e) {
			String message = String.format("Persistence exception occurred when trying to save the entity [%s].", entity);
			LOGGER.debug(message, e);
			EntitySaveException newException = new EntitySaveException(message, e);
			Exceptions.get().throwNewIfContains(e, ConstraintViolationException.class, newException);
			throw newException;
		}
	}

	/**
	 * Remove the entity instance.
	 * 
	 * @param entity
	 *            entity instance to remove
	 */
	public <E> void delete(E entity) {
		E entityToDelete = getEntityManager().merge(entity);
		getEntityManager().remove(entityToDelete);
	}

	/**
	 * Remove the entity instance by provided primary key.
	 * 
	 * @param primaryKey
	 *            the primary key of existing entity instance to be removed
	 * @throws EntityDeleteException
	 *             thrown if it was not possible to delete the selected entity
	 *             due to some reasons
	 */
	public void deleteById(Object primaryKey) throws EntityDeleteException {
		try {
			T entityReference = getEntityManager().find(getEntityClass(), primaryKey);
			if (entityReference == null) {
				throw new EntityDeleteException(String.format("Entity with primary key [%s] was not found.", primaryKey));
			}
			delete(entityReference);
			getEntityManager().flush();
		} catch (PersistenceException e) {
			String message = String.format("Persistence exception occurred when trying to delete the entity [%s].", primaryKey);
			LOGGER.debug(message, e);
			EntityDeleteException newException = new EntityDeleteException(message, e);
			Exceptions.get().throwNewIfContains(e, ConstraintViolationException.class, newException);
			throw newException;
		}
	}
	
	public <E> E merge(E entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Returns the implementation of query.
	 * 
	 * @return query implementation instance
	 */
	public abstract Q query();
}
