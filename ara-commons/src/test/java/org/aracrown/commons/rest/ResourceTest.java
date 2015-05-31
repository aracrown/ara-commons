package org.aracrown.commons.rest;

import java.util.ArrayList;
import java.util.List;

import org.aracrown.commons.persistence.FakeEntity;
import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {
	@Test
	public void testDefault() {
		List<FakeEntity> entities = new ArrayList<>();
		FakeEntity e = createEntity();
		entities.add(e);
		entities.add(null);
		ResourceCollectionResponse<SimpleResource> r = new SimpleResourceCollectionTransformation().page(0L, 10L).total(1). transform(entities);
		Assert.assertEquals(1, r.getCount().intValue());
		Assert.assertEquals(1, r.getTotal().intValue());
		
		Assert.assertEquals(e.getId(), r.getItems().get(0).getId());
		
	}
	
	private FakeEntity createEntity() {
		FakeEntity r = new FakeEntity();
		r.setId(22L);
		r.setName("test");
		return r;
	}

	@Test
	public void testResourceCollectionResponseEmpty() {
		ResourceCollectionResponse<SimpleResource> r = new ResourceCollectionResponse<>();
		Assert.assertEquals(0, r.getCount().intValue());
		Assert.assertEquals(0, r.getTotal().intValue());
		Assert.assertNull(r.getCurrentPage());
		Assert.assertNull( r.getPageSize());
	}
	
	@Test
	public void testResourceCollectionResponsePage() {
		ResourceCollectionResponse<SimpleResource> r = new ResourceCollectionResponse<>(1L,10L);
		Assert.assertEquals(0, r.getCount().intValue());
		Assert.assertEquals(0, r.getTotal().intValue());
		Assert.assertEquals(1, r.getCurrentPage().intValue());
		Assert.assertEquals(10, r.getPageSize().intValue());
		
	}
	
	@Test
	public void testResourceCollectionResponseItems() {
		List<SimpleResource> entities = new ArrayList<>();
		entities.add(new SimpleResource());
		
		ResourceCollectionResponse<SimpleResource> r = new ResourceCollectionResponse<>();
		r.setCurrentPage(1L);
		r.setPageSize(10L);
		r.totalCount(11L);
		r.setItems(entities);
		
		r.addItems(entities);
		
		Assert.assertEquals(2, r.getCount().intValue());
		Assert.assertEquals(11, r.getTotal().intValue());
		Assert.assertEquals(1, r.getCurrentPage().intValue());
		Assert.assertEquals(10, r.getPageSize().intValue());
		
	}
}

class SimpleResourceCollectionTransformation extends ResourceCollectionTransformation<FakeEntity, SimpleResource> {

	public SimpleResourceCollectionTransformation() {
		super(new ResourceCollectionResponse<>());
	}

	@Override
	public SimpleResource tranformSingle(FakeEntity item) {
		if (item == null) {
			return null;
		}
		SimpleResource result = new SimpleResource();
		result.setName(item.getName());
		result.setId(item.getId());
		return result;
	}
	
}

class SimpleResource extends Resource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
