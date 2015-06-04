package org.aracrown.commons.persistence.joins;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;

public class LeftJoin<T, Z extends Path<T>> extends Join<T, Z>{
	public LeftJoin(EntityPath<T> target, Z alias) {
		super(target, alias);
	}

	@Override
	public void addJoin(JPAQuery<?> jpaQuery) {
		jpaQuery.leftJoin(getTarget(), getAlias());
	}
}
