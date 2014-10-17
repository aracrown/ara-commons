package org.aracrown.commons.security;

import java.security.GeneralSecurityException;

public class HasherException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HasherException(String message, GeneralSecurityException e) {
		super(message, e);
	}
}
