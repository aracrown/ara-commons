package org.aracrown.commons.rest.exception;

public class ResourceAuthorizationException extends PlainResourceException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAuthorizationException(String messageKey, String description) {
		super(messageKey, description);
	}

}
