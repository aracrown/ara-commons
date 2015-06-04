package org.aracrown.commons.persistence.joins;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;

public class InnerJoin<T, Z extends Path<T>> extends Join<T, Z>{
	public InnerJoin(EntityPath<T> target, Z alias) {
		super(target, alias);
	}

	@Override
	public void addJoin(JPAQuery<?> jpaQuery) {
		jpaQuery.innerJoin(getTarget(), getAlias());
	}
}
