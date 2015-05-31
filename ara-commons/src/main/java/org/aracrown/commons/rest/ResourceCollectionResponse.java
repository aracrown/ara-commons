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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple response wrapper of result collection.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 * @param <E>
 *            wrapped single result item type
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceCollectionResponse<E> {
	/** Total count of query results. */
	private Long total = 0L;

	/** How may items are returned by this query result. */
	private Long count = 0L;

	/** Page size for this response. */
	private Long pageSize;

	/** The current page. */
	private Long currentPage;

	/** Collection of items to be returned. */
	@XmlElement
	private List<E> items = new ArrayList<>();

	public ResourceCollectionResponse() {
	}

	public ResourceCollectionResponse(Long currentPage, Long pageSize) {
		page(currentPage, pageSize);
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(List<E> items) {
		this.items = items;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

	/**
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Long count) {
		this.count = count;
	}

	/**
	 * @return the items
	 */
	public List<E> getItems() {
		return items;
	}

	/**
	 * @return the pageSize
	 */
	public Long getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the currentPage
	 */
	public Long getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage
	 *            the currentPage to set
	 */
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}

	public void addItems(Collection<E> itemsToAdd) {
		items.addAll(itemsToAdd);
		setCount((long) items.size());
	}

	public ResourceCollectionResponse<E> totalCount(Long totalCount) {
		this.total = totalCount;
		return this;
	}

	public ResourceCollectionResponse<E> page(Long currentPage, Long pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		return this;
	}
}
