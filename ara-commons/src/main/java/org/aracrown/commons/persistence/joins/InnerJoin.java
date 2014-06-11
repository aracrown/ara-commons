package org.aracrown.commons.persistence.joins;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.EntityPath;
import com.mysema.query.types.Path;

public class InnerJoin<T, Z extends Path<T>> extends Join<T, Z>{
	public InnerJoin(EntityPath<T> target, Z alias) {
		super(target, alias);
	}

	@Override
	public void addJoin(JPAQuery jpaQuery) {
		jpaQuery.innerJoin(getTarget(), getAlias());
	}
}
