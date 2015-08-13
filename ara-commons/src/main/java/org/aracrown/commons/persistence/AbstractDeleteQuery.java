package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPADeleteClause;

/**
 * Abstract DELETE query implementation using QueryDSL project.
 * <p>
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 * @param <T>
 *            entity path class
 * @param <K>
 *            entity class
 */
public class AbstractDeleteQuery<T extends EntityPathBase<K>, K> implements DeleteQuery {
	/** The JPA delete instance. */
	private final JPADeleteClause deleteClause;

	/** The entity path. */
	private final T path;

	/**
	 * Default constructor accepting entity manager and entity path class.
	 * 
	 * @param entityManager
	 *            JPA entity manager instance used to perform actual query
	 * @param path
	 *            JPA entity queryDSL path
	 */
	public AbstractDeleteQuery(EntityManager entityManager, T path) {
		this.path = path;
		deleteClause = new JPADeleteClause(entityManager, path);
	}

	/**
	 * @return the deleteClause
	 */
	public JPADeleteClause getDeleteClause() {
		return deleteClause;
	}

	/**
	 * @return the path
	 */
	public T getPath() {
		return path;
	}

	/**
	 * {@inheritDoc}
	 */
	public long execute() {
		return getDeleteClause().execute();
	}
}
