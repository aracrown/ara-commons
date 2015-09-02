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

import org.aracrown.commons.persistence.exception.EntityConstraintViolationException;
import org.aracrown.commons.persistence.exception.EntityDeleteException;
import org.aracrown.commons.persistence.exception.EntityNotFoundException;
import org.aracrown.commons.persistence.exception.EntitySaveException;
import org.aracrown.commons.persistence.exception.EntityValidationException;
import org.junit.Assert;
import org.junit.Test;

public class FakeEntityDaoTest extends AbstractDaoTest {

	@Test(expected = EntitySaveException.class)
	public void testCountryDao_save() throws EntitySaveException {
		FakeEntity e = new FakeEntity();
		e.setId(999L);
		
		FakeEntityDao1 dao = new FakeEntityDao1(e);
		dao.save(e);
	}

	@Test
	public void testSaveDelete() throws EntitySaveException, EntityNotFoundException, EntityDeleteException {
		FakeEntityDao dao = newFakeEntityDao();
		FakeEntity e = new FakeEntity();
		e.setName("test name");
		e = dao.save(e);
		
		e = dao.byId(e.getId());
		
		dao.delete(e);
		Assert.assertEquals(FakeEntity.class.getName(), dao.getEntityClass().getName());
		
	}
	
	@Test
	public void testSave() throws EntitySaveException {
		FakeEntityDao dao = newFakeEntityDao();
		FakeEntity e = new FakeEntity();
		e.setName("t3");
		try {
			e = dao.save(e);
			Assert.fail();
		} catch (EntityValidationException ex) {
			Assert.assertEquals("size must be between 3 and 255", ex.toString());
		}
	}
	
	@Test(expected=EntityNotFoundException.class)
	public void testByIdNotFound() throws EntityConstraintViolationException, EntityNotFoundException {
		FakeEntityDao dao = newFakeEntityDao();
		dao.byId(3L);		
	}
	
	@Test
	public void testDeleteById() throws EntitySaveException, EntityDeleteException {
		FakeEntityDao dao = newFakeEntityDao();
		FakeEntity e = new FakeEntity();
		e.setName("test name");
		e = dao.save(e);
		dao.deleteById(e.getId());
	}
	
	@Test(expected=EntityDeleteException.class)
	public void testDeleteByIdNotFound() throws EntityDeleteException {
		FakeEntityDao dao = newFakeEntityDao();
		dao.deleteById(32L);
	}
	
	@Test(expected = EntityDeleteException.class)
	public void testDeleteByIdPersistenceException() throws EntitySaveException, EntityDeleteException {
		FakeEntityDao dao = newFakeEntityDao();
		FakeEntity e = new FakeEntity();
		e.setName("test name");
		e = dao.save(e);
		new FakeEntityDao1(e).deleteById(e.getId());
	}
	
	@Test
	public void testMerge() throws EntitySaveException, EntityDeleteException {
		FakeEntityDao dao = newFakeEntityDao();
		FakeEntity e = new FakeEntity();
		e.setName("test name");
		e = dao.merge(e);
		Assert.assertNotNull(e);
	}
}
