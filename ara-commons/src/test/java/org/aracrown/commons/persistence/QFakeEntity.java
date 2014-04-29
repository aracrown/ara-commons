package org.aracrown.commons.persistence;

import static com.mysema.query.types.PathMetadataFactory.forVariable;

import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

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
