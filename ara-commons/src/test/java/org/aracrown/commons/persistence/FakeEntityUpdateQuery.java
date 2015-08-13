package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

public class FakeEntityUpdateQuery extends AbstractUpdateQuery<QFakeEntity, FakeEntity>{

	public FakeEntityUpdateQuery(EntityManager entityManager) {
		super(entityManager, QFakeEntity.fakeEntity);
	}
	
	public FakeEntityUpdateQuery name(String name, String newValue) {
		getUpdateClause().where(getPath().name.equalsIgnoreCase(name)).set(getPath().name, newValue);
		return this;
	}
}
