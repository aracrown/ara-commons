package org.aracrown.commons.security;

import org.aracrown.commons.rest.exception.PlainResourceException;

/**
* Exception is thrown when the Subject was not able to authenticate properly.
* 
* @author vicento.ramos
* 
* @since 1.0.0
* 
*/
public class AuthenticationException extends PlainResourceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param messageKey
	 *            the key to be used when localizing the authentication message
	 */
	public AuthenticationException(String messageKey) {
		super(messageKey);
	}
	
	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param messageKey
	 *            the key to be used when localizing the authentication message
	 * @param defaultMessage
	 *            message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
	 */
	public AuthenticationException(String messageKey, String defaultMessage) {
		super(messageKey, defaultMessage);
	}	

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param messageKey
	 *            the key to be used when localizing the authentication message
	 * @param defaultMessage
	 *            message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates
	 *            that the cause is nonexistent or unknown.)
	 */
	public AuthenticationException(String messageKey, String defaultMessage, Throwable cause) {
		super(messageKey, defaultMessage, cause);
	}
}

