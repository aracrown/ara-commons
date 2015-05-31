package org.aracrown.commons.rest;

import org.aracrown.commons.util.OrderType;
import org.junit.Assert;
import org.junit.Test;

public class ResourceFilterTest {
	@Test
	public void testDefault() {
		ResourceFilter filter = new ResourceFilter();
		filter.setFirst(1L);
		filter.setPageSize(10L);
		filter.setOrderType(OrderType.DESC);
		
		Assert.assertEquals(1, filter.getFirst().intValue());
		Assert.assertEquals(10, filter.getPageSize().intValue());
		Assert.assertEquals(OrderType.DESC, filter.getOrderType());
	}
}
