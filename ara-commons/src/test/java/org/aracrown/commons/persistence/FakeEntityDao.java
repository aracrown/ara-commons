package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

import org.aracrown.commons.persistence.exception.EntitySaveException;
import org.mockito.Mockito;

public class FakeEntityDao extends AbstractDao<FakeEntity, FakeEntityQuery> {
	private final EntityManager entityManager;
	
	public FakeEntityDao(EntityManager entityManager) {
		super(FakeEntity.class);
		this.entityManager = entityManager;
	}

	@Override
	public FakeEntityQuery query() {
		FakeEntityQuery q = Mockito.mock(FakeEntityQuery.class);
		Mockito.when(q.page(Mockito.anyLong(), Mockito.anyLong())).thenReturn(q);
		return q;
	}
	
	public FakeEntity newFakeEntity(String name) throws EntitySaveException {
		FakeEntity e = newEntity(name);
		save(e);
		return e;
	}

	private FakeEntity newEntity(String name) {
		FakeEntity e = new FakeEntity();
		e.setId(999L);
		e.setName(name);
		return e;
	}

	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

}
