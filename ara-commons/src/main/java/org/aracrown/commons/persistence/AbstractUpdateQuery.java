package org.aracrown.commons.persistence;

import javax.persistence.EntityManager;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAUpdateClause;

/**
 * Abstract UPDATE query implementation using QueryDSL project.
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
public class AbstractUpdateQuery<T extends EntityPathBase<K>, K> implements UpdateQuery {
	/** The JPA update instance. */
	private final JPAUpdateClause updateClause;

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
	public AbstractUpdateQuery(EntityManager entityManager, T path) {
		this.path = path;
		updateClause = new JPAUpdateClause(entityManager, path);
	}

	/**
	 * @return the updateClause
	 */
	public JPAUpdateClause getUpdateClause() {
		return updateClause;
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
		return getUpdateClause().execute();
	}
}
