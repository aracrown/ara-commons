package org.aracrown.commons.persistence.joins;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.jpa.impl.JPAQuery;

public abstract class Join<T, Z extends Path<T>> {
	private final EntityPath<T> target;

	private final Z alias;

	public Join(EntityPath<T> target, Z alias) {
		this.target = target;
		this.alias = alias;
	}

	/**
	 * @return the alias
	 */
	public Z getAlias() {
		return alias;
	}

	public abstract void addJoin(JPAQuery<?> jpaQuery);

	/**
	 * @return the target
	 */
	public EntityPath<T> getTarget() {
		return target;
	}
	
	
}
