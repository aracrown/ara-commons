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
package org.aracrown.commons.rest;

import java.util.List;

/**
 * Abstract transformation of collections into REST response.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 * @param <S>
 *            source object
 * @param <T>
 *            target object
 */
public abstract class ResourceCollectionTransformation<S, T> {

	/** The target REST resource to be created. */
	private final ResourceCollectionResponse<T> target;

	/**
	 * Default constructor with REST resource created.
	 * 
	 * @param target
	 *            REST resource
	 */
	public ResourceCollectionTransformation(ResourceCollectionResponse<T> target) {
		this.target = target;
	}

	/**
	 * Sets the total count of items for this query result.
	 * 
	 * @param totalCount
	 *            total count to set
	 * @param <I>
	 *            the type of this instance
	 * @return this instance
	 */
	@SuppressWarnings("unchecked")
	public <I extends ResourceCollectionTransformation<S, T>> I total(Long totalCount) {
		target.setTotal(totalCount);
		return (I) this;
	}

	/**
	 * Sets the total count of items for this query result.
	 * 
	 * @param totalCount
	 *            total count to set
	 * @param <I>
	 *            the type of this instance
	 * @return this instance
	 */
	public <I extends ResourceCollectionTransformation<S, T>> I total(int totalCount) {
		return total(new Long(totalCount));
	}

	/**
	 * Sets the page information for this query result.
	 * 
	 * @param first
	 *            the current page
	 * @param pageSize
	 *            the current page size
	 * @param <I>
	 *            the type of this instance
	 * @return this instance
	 */
	@SuppressWarnings("unchecked")
	public <I extends ResourceCollectionTransformation<S, T>> I page(Long first, Long pageSize) {
		target.page(first, pageSize);
		return (I) this;
	}

	/**
	 * Transforms collection of persistable entities into RESTful resource
	 * collection.
	 * 
	 * @param queryResults
	 *            source collection to transform
	 * @return RESTful resource with transformed item collection
	 */
	public ResourceCollectionResponse<T> transform(List<S> queryResults) {
		tranform(queryResults);
		target.setCount(Long.valueOf(target.getItems().size()));
		return target;
	}

	private void tranform(List<S> source) {
		for (S item : source) {
			T transformed = tranformSingle(item);
			if (transformed != null) {
				target.getItems().add(transformed);
			}
		}
	}

	/**
	 * Transforms single entity into RESTful resource item.
	 * 
	 * @param item
	 *            entity to transform
	 * @return newly RESTful resource
	 */
	public abstract T tranformSingle(S item);
}
