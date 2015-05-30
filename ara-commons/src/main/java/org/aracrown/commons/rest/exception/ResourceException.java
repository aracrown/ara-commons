package org.aracrown.commons.rest.exception;

import java.util.ArrayList;
import java.util.List;

import org.aracrown.commons.util.ConstraintViolationBuilder;

import com.google.common.base.Strings;

/**
 * Resource exception, containing key and default message.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 * 
 */
public class ResourceException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The list of errors. */
	private final List<ErrorMessage> errors = new ArrayList<>();

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the Throwable.getMessage() method).
	 */
	public ResourceException(String message) {
		super(message);
		parseErrorKeys(message);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 * 
	 * @param message
	 *            message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates
	 *            that the cause is nonexistent or unknown.)
	 */
	public ResourceException(String message, Throwable cause) {
		super(message, cause);
		parseErrorKeys(message);
	}

	/**
	 * @return the errors
	 */
	public List<ErrorMessage> getErrors() {
		return errors;
	}

	private void parseErrorKeys(String message) {
		if (!Strings.isNullOrEmpty(message)) {
			if (message.contains(ConstraintViolationBuilder.VIOLATION_SEPARATOR)) {
				for (String error : message.split(ConstraintViolationBuilder.VIOLATION_SEPARATOR)) {
					errors.add(parseErrorMessage(error));
				}
			} else {
				errors.add(parseErrorMessage(message));
			}
		}
	}

	private ErrorMessage parseErrorMessage(String errorMessage) {
		String key;
		String message;
		if (errorMessage.contains(ConstraintViolationBuilder.KEY_SEPARATOR)) {
			String[] errorPair = errorMessage.split(ConstraintViolationBuilder.KEY_SEPARATOR);
			key = errorPair[0];
			message = errorPair[1];
		} else {
			key = errorMessage;
			message = errorMessage;
		}
		return new ErrorMessage(key, message);
	}

	/**
	 * Returns first error message object.
	 * 
	 * @return error message as object
	 */
	public ErrorMessage getFirstError() {
		if (!errors.isEmpty()) {
			return errors.get(0);
		}
		return null;
	}
}
