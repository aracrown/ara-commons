package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

import com.querydsl.core.types.PathMetadataFactory;
import com.querydsl.core.types.dsl.Expressions;

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

	public void testListJoin() {
		QFakeEntity q = new QFakeEntity("test3");

		q = validateJoin(Expressions.listPath(FakeEntity.class, QFakeEntity.class, PathMetadataFactory.forVariable("fakeEntity")), q);
	}

	public void testLeftJoin() {
		QFakeEntity q = new QFakeEntity("test31");
		q = validateLeftJoin(QFakeEntity.fakeEntity, q);
	}

	public void testCollectionJoin() {
		QFakeEntity q = new QFakeEntity("test4");
		q = validateJoin(Expressions.collectionPath(FakeEntity.class, QFakeEntity.class, PathMetadataFactory.forVariable("fakeEntity")), q);
	}

	FakeEntityQuery name(String name) {
		getQuery().where(getEntityPath().name.eq(name));
		return this;
	}

}
