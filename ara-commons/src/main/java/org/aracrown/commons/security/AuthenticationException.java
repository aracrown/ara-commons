package org.aracrown.commons.security;

/**
* Exception is thrown when the Subject was not able to authenticate properly.
* 
* @author vicento.ramos
* 
* @since 1.0.0
* 
*/
public class AuthenticationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The message key, used when trying to localize the error message. */
	private final String messageKey;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param messageKey
	 *            the key to be used when localizing the authentication message
	 */
	public AuthenticationException(String messageKey) {
		super(messageKey);
		this.messageKey = messageKey;
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param messageKey
	 *            the key to be used when localizing the authentication message
	 * @param cause
	 *            the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates
	 *            that the cause is nonexistent or unknown.)
	 */
	public AuthenticationException(String messageKey, Throwable cause) {
		super(messageKey, cause);
		this.messageKey = messageKey;
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
		super(defaultMessage);
		this.messageKey = messageKey;
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
		super(defaultMessage, cause);
		this.messageKey = messageKey;
	}

	/**
	 * @return the messageKey
	 */
	public String getMessageKey() {
		return messageKey;
	}

}

