package org.aracrown.commons.rest.exception;

/**
 * Resource exception, containing key and default message.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class PlainResourceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The error message key for localization usages. */
	private final String description;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            Throwable.getMessage() method).
	 */
	public PlainResourceException(String message) {
		super(message);
		description = null;
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            message the detail message (which is saved for later retrieval
	 *            by the {@link #getMessage()} method).
	 * @param description
	 *            message the detail message (which is saved for later retrieval
	 *            by the {@link #getDescription()} method).
	 */
	public PlainResourceException(String messageKey, String description) {
		super(messageKey);
		this.description = description;
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            message the detail message (which is saved for later retrieval
	 *            by the {@link #getMessage()} method).
	 * @param description
	 *            message the detail message (which is saved for later retrieval
	 *            by the {@link #getDescription()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is
	 *            permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public PlainResourceException(String message, String description, Throwable cause) {
		super(message, cause);
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
