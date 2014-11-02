package org.aracrown.commons.util;

import javax.enterprise.inject.Vetoed;

@Vetoed
public class ProxiedParam<T> {
	private T param;

	public ProxiedParam() {
	}

	public ProxiedParam(T param) {
		this.param = param;
	}

	/**
	 * @return the param
	 */
	public T getParam() {
		return param;
	}

	/**
	 * @param param
	 *            the param to set
	 */
	public void setParam(T param) {
		this.param = param;
	}

}
