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

import java.util.List;

/**
 * 
 * Query interface defining methods available to perform the required query.
 * 
 * @author vicento.ramos
 * 
 * @param <T>
 *            entity type for a generic solution
 * 
 * @since 1.0.0
 */
public interface Query<T> {
	/**
	 * Execute query and return single result.
	 * 
	 * @return entity instance. null if no entity found
	 */
	T singleResult();

	/**
	 * Set the page size to retrieve.
	 * 
	 * @param first
	 *            the position of the first result to retrieve
	 * @param pageSize
	 *            the maximum number of results to retrieve
	 * @param <Q>
	 *            query instance type
	 * @return this query instance
	 */
	<Q extends Query<T>> Q page(Long first, Long pageSize);

	/**
	 * Disable caching for concrete query.
	 * 
	 * @param <Q>
	 *            returning a Query type based result. Usually it means
	 * 
	 *            <pre>
	 * return this;
	 * </pre>
	 * @return this query instance
	 */
	<Q extends Query<T>> Q disableCaching();

	/**
	 * Execute a SELECT query and return the query results.
	 * 
	 * @return a list of the results
	 */
	List<T> list();

	/**
	 * Perform count query and return number of results found.
	 * 
	 * @return how many records found
	 */
	Long count();

	/**
	 * Filters entities by provided user, who created entity.
	 * 
	 * @param username
	 *            user name to filter query by
	 * @param <Q>
	 *            query instance type
	 * @return this instance
	 */
	<Q extends Query<T>> Q createdBy(String username);

	/**
	 * Executes distinct query.
	 * 
	 * @param <Q>
	 *            returning a Query type based result. Usually it means
	 * 
	 *            <pre>
	 * return this;
	 * </pre>
	 * @return this query instance
	 */
	<Q extends Query<T>> Q distinct();
}
