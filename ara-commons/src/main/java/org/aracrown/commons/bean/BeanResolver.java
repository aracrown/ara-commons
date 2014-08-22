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
package org.aracrown.commons.bean;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 
 * @author vicento.ramos
 * @since 1.0.0
 * 
 * @param <T>
 *            bean type to resolve
 */
public class BeanResolver<T> implements AutoCloseable {
	/** The instance of resolved bean. */
	private T instance;

	/** The bean type to resolve. */
	private final Class<T> clz;

	/** The bean context for destroying later. */
	private CreationalContext<T> creationalContext;

	/**
	 * Default constructor.
	 * 
	 * @param clz
	 *            the required bean type
	 */
	public BeanResolver(Class<T> clz) {
		this.clz = clz;
	}

	/**
	 * Resolves the bean and returns it's instance.
	 * 
	 * @return resolved bean instance
	 * @throws BeanResolveException
	 *             exception is thrown if something bad happens when trying to resolve the bean
	 */
	public T getBean() throws BeanResolveException {
		if (instance == null) {
			instance = resolveBean();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	private T resolveBean() throws BeanResolveException {
		try {
			BeanManager beanManager = (BeanManager) new InitialContext().lookup("java:comp/BeanManager");
			Bean<T> bean = (Bean<T>) beanManager.resolve(beanManager.getBeans(clz));
			creationalContext = beanManager.createCreationalContext(null);
			return bean.create(creationalContext);
		} catch (NamingException e) {
			throw new BeanResolveException("Error, while getting getting java:comp/BeanManager", e);
		} catch (Exception e) {
			throw new BeanResolveException("Unexpected error while trying to resolve bean", e);
		}
	}

	@Override
	public void close() {
		if (creationalContext != null) {
			creationalContext.release();
		}
	}
}
