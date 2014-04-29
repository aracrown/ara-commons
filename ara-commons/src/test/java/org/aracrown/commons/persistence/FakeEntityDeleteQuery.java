package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

public class FakeEntityDeleteQuery extends AbstractDeleteQuery<QFakeEntity, FakeEntity>{

	public FakeEntityDeleteQuery(EntityManager entityManager) {
		super(entityManager, QFakeEntity.fakeEntity);
	}
	
	public FakeEntityDeleteQuery name(String name) {
		getDeleteClause().where(getPath().name.equalsIgnoreCase(name));
		return this;
	}
}
