package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.mockito.Mockito;

public class FakeEntityDao1 extends AbstractDao<FakeEntity, FakeEntityQuery> {
	final FakeEntity e;
	
	public FakeEntityDao1(FakeEntity e) {
		super(FakeEntity.class);
		this.e = e;
	}

	@Override
	public FakeEntityQuery query() {
		return null;
	}

	@Override
	protected EntityManager getEntityManager() {
		EntityManager em1 = Mockito.mock(EntityManager.class);
		Mockito.doThrow(new PersistenceException()).when(em1).find(e.getClass(), e.getId());
		Mockito.doThrow(new PersistenceException()).when(em1).flush();
		return em1;
	}

}
