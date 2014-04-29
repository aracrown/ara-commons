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

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.aracrown.commons.persistence.exception.EntityValidationException;

/**
 * Simple entity builder. It is more a combination of fluent interface, because we do not build entity at once. 
 * 
 * @author vicento.ramos
 * 
 * @param <T>
 *            entity type to be built
 * 
 * @since 1.0.0
 */
public abstract class AbstractBuilder<T> {
	/** Managed entity. */
	private final T entity;

	/**
	 * Store created entity until all properties are populated.
	 * 
	 * @param entity
	 *            entity to build
	 */
	public AbstractBuilder(T entity) {
		this.entity = entity;
	}

	/**
	 * Build here means just return entity with already populated properties.
	 * 
	 * @return entity with populated properties
	 */
	public T build() {
		validate();
		return entity;
	}
	
	/**
	 * Build here means just return entity with already populated properties, no bean validation performed.
	 * 
	 * @return entity with populated properties
	 */
	public T buildWithoutValidation() {
		return entity;
	}

	/**
	 * Returns entity for modifications.
	 * 
	 * @return the entity
	 */
	protected T getEntity() {
		return entity;
	}

	/**
	 * Validates if all required properties are populated.
	 */
	protected void validate() {
		Set<ConstraintViolation<T>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(entity);
		if (!constraintViolations.isEmpty()) {
			throw new EntityValidationException(constraintViolations);
		}
	}
}
