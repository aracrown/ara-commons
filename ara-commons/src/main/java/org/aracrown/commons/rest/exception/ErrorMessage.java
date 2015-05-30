package org.aracrown.commons.rest.exception;

/**
 * Error message containing key for client localization and default message if any.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 */
public class ErrorMessage {
	/** The error key for further message localization. */
	private final String key;

	/** The default error message. */
	private final String message;

	/**
	 * Default constructor.
	 * 
	 * @param key
	 *            error key
	 * @param message
	 *            default error message
	 */
	public ErrorMessage(String key, String message) {
		this.key = key.trim();
		this.message = message.trim();
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
