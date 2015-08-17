package org.aracrown.commons.identity;

import java.io.Serializable;

/**
 * Usually contains issuer name for further actions to be taken.
 * 
 * @author turisto
 *
 */
public class IssuerContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
