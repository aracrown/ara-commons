/*
 * Copyright 2013 ARA Crown
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.aracrown.commons.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.aracrown.commons.persistence.joins.InnerJoin;
import org.aracrown.commons.persistence.joins.Join;
import org.aracrown.commons.persistence.joins.LeftJoin;

import com.querydsl.core.QueryModifiers;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.CollectionPath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.SetPath;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * Abstract query implementation using QueryDSL project.
 * <p>
 *
 * @param <T>
 *            entity path class
 * @param <K>
 *            entity class
 * @author vicento.ramos
 * @since 1.0.0
 */
public abstract class AbstractQuery<T extends EntityPathBase<K>, K> implements Query<K> {
	private static final String ORG_HIBERNATE_CACHEABLE = "org.hibernate.cacheable";

	/**
	 * The JPA query instance.
	 */
	private final JPAQuery<K> jpaQuery;

	/**
	 * The entity path.
	 */
	private final T path;

	/**
	 * Available joins for this query.
	 */
	private final List<Path<?>> joins = new ArrayList<>();

	/**
	 * By default caching is enabled.
	 */
	private boolean cacheable = true;

	/**
	 * Default constructor accepting entity manager and entity path class.
	 *
	 * @param entityManager
	 *            JPA entity manager instance used to perform actual query
	 * @param path
	 *            JPA entity queryDSL path
	 */
	public AbstractQuery(EntityManager entityManager, T path) {
		this.path = path;
		jpaQuery = new JPAQuery<>(entityManager);
		jpaQuery.from(path);
	}

	protected <P, Z extends EntityPath<P>> Z validateFrom(Z alias) {
		if (!joins.contains(alias)) {
			getQuery().from(alias);
			joins.add(alias);
		}
		return alias;
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 *
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends Path<P>> Z validateJoin(EntityPath<P> target, Z alias) {
		return validateInternalJoin(new InnerJoin<>(target, alias));
	}

	private <P, Z extends Path<P>> Z validateInternalJoin(Join<P, Z> join) {
		if (!joins.contains(join.getAlias())) {
			join.addJoin(jpaQuery);
			joins.add(join.getAlias());
		}
		return join.getAlias();
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 *
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends Path<P>> Z validateLeftJoin(EntityPath<P> target, Z alias) {
		return validateInternalJoin(new LeftJoin<>(target, alias));
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 * 
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends EntityPathBase<P>> Z validateLeftJoin(ListPath<P, Z> target, Z alias) {
		if (!joins.contains(alias)) {
			getQuery().leftJoin(target, alias);
			joins.add(alias);
		}
		return alias;
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 *
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends EntityPathBase<P>> Z validateJoin(ListPath<P, Z> target, Z alias) {
		if (!joins.contains(alias)) {
			getQuery().join(target, alias);
			joins.add(alias);
		}
		return alias;
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 *
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends EntityPathBase<P>> Z validateJoin(CollectionPath<P, Z> target, Z alias) {
		if (!joins.contains(alias)) {
			getQuery().join(target, alias);
			joins.add(alias);
		}
		return alias;
	}

	/**
	 * Checks if there is already existing join. Useful if there is no need for
	 * duplicate joins.
	 *
	 * @param <P>
	 *            entity type parameter
	 * @param <Z>
	 *            path type parameter
	 * @param target
	 *            entity field as a target
	 * @param alias
	 *            alias name for join created
	 * @return alias used in join
	 */
	protected <P, Z extends EntityPathBase<P>> Z validateJoin(SetPath<P, Z> target, Z alias) {
		if (!joins.contains(alias)) {
			getQuery().join(target, alias);
			joins.add(alias);
		}
		return alias;
	}

	private JPAQuery<K> prepareQuery() {
		onBeforeExecute();
		return jpaQuery;
	}

	protected void onBeforeExecute() {
		// default implementation does not do anything
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public K singleResult() {
		return prepareQuery().setHint(ORG_HIBERNATE_CACHEABLE, cacheable).fetchFirst();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<K> list() {
		return prepareQuery().fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() {
		return prepareQuery().fetchCount();
	}

	/**
	 * Returns jpa query instance.
	 *
	 * @return the jpaQuery
	 */
	public JPAQuery<K> getQuery() {
		return jpaQuery;
	}

	/**
	 * Returns entity root path.
	 *
	 * @return the path
	 */
	public T getEntityPath() {
		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <Q extends Query<K>> Q page(Long first, Long pageSize) {
		jpaQuery.restrict(new QueryModifiers(pageSize, first)).setHint(ORG_HIBERNATE_CACHEABLE, cacheable);
		return (Q) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <Q extends Query<K>> Q disableCaching() {
		this.cacheable = false;
		return (Q) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <Q extends Query<K>> Q createdBy(String username) {
		return (Q) this;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <Q extends Query<K>> Q distinct() {
		getQuery().distinct();
		return (Q) this;
	}
}
