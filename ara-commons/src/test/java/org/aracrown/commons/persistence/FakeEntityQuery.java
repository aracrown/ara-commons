package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

import com.mysema.query.types.path.CollectionPath;
import com.mysema.query.types.path.ListPath;

public class FakeEntityQuery extends AbstractQuery<QFakeEntity, FakeEntity> {

	public FakeEntityQuery(EntityManager entityManager) {
		super(entityManager, QFakeEntity.fakeEntity);
	}

	public void testFrom() {
		QFakeEntity q = new QFakeEntity("test");
		q = validateFrom(q);
	}

	public void testJoin() {
		QFakeEntity q = new QFakeEntity("test2");
		q = validateJoin(QFakeEntity.fakeEntity, q);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testListJoin() {
		QFakeEntity q = new QFakeEntity("test3");
		q = validateJoin(new ListPath(FakeEntity.class, QFakeEntity.class, "fakeEntity"), q);
	}
	
	public void testLeftJoin() {
		QFakeEntity q = new QFakeEntity("test31");
		q = validateLeftJoin(QFakeEntity.fakeEntity, q);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testCollectionJoin() {
		QFakeEntity q = new QFakeEntity("test4");
		q = validateJoin(new CollectionPath(FakeEntity.class, QFakeEntity.class, "fakeEntity"), q);
	}

	FakeEntityQuery name(String name) {
		getQuery().where(getEntityPath().name.eq(name));
		return this;
	}

}
