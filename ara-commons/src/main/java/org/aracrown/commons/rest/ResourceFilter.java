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

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import org.aracrown.commons.util.OrderType;

/**
 * Simple query filter definition.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class ResourceFilter {

	/** Default page size. */
	private static final long DEFAULT_PAGE_SIZE = 10L;

	/** Page number to query. */
	@QueryParam("f")
	@DefaultValue("0")
	private Long first = 0L;

	/** Page size to query. */
	@QueryParam("p")
	@DefaultValue("10")
	private Long pageSize = DEFAULT_PAGE_SIZE;

	/** Query order type. */
	@QueryParam("o")
	private OrderType orderType = OrderType.ASC;

	/**
	 * @return the first
	 */
	public Long getFirst() {
		return first;
	}

	/**
	 * @param first
	 *            the first to set
	 */
	public void setFirst(Long first) {
		this.first = first;
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
	 * @return the orderType
	 */
	public OrderType getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}
}
