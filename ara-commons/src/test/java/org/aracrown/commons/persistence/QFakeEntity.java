package org.aracrown.commons.persistence;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

public class QFakeEntity extends EntityPathBase<FakeEntity> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final QFakeEntity fakeEntity = new QFakeEntity("fakeEntity");

	public final NumberPath<Long> id = createNumber("id", Long.class);
	
	public final StringPath name = createString("name");

	public QFakeEntity(String variable) {
		super(FakeEntity.class, forVariable(variable));
	}

}
