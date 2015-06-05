package org.aracrown.commons.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.core.types.dsl.StringPath;

public class QFakeEntity extends EntityPathBase<FakeEntity> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final QFakeEntity fakeEntity = new QFakeEntity("fakeEntity");

	public final NumberPath<Long> id = createNumber("id", Long.class);

	public final StringPath name = createString("name");

	public final ListPath<String, StringPath> data = this.<String, StringPath> createList("data", String.class, StringPath.class, PathInits.DIRECT2);

	public final SetPath<String, StringPath> data1 = this.<String, StringPath> createSet("data1", String.class, StringPath.class, PathInits.DIRECT2);

	public QFakeEntity(String variable) {
		super(FakeEntity.class, forVariable(variable));
	}

}
