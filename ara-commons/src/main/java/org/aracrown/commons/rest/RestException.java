package org.aracrown.commons.rest;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.Strings;

/**
 * The exception entity, used to map in client side.
 * 
 * @author vicento.ramos
 * 
 * @since 1.0.0
 */
@XmlRootElement
public class RestException implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Custom header to identify that the exception type is expected. */
	public static final String X_MAPPED_EXCEPTION_HEADER = "X-Mapped-Exception";

	/** Unknown error message. */
	private static final String UNKNOWN_ERROR = "Unknown error.";

	/** The exception class type. */
	private String exceptionClassName;

	/** The exception message. */
	private String exceptionMessage;

	/**
	 * Default constructor.
	 */
	public RestException() {
	}

	/**
	 * Constructor with exception.
	 * 
	 * @param throwable
	 *            exception as input to be able to construct the entity
	 */
	public RestException(Throwable throwable) {
		this.exceptionClassName = throwable.getClass().getName();
		this.exceptionMessage = throwable.getMessage();
		if (Strings.isNullOrEmpty(this.exceptionMessage)) {
			this.exceptionMessage = UNKNOWN_ERROR;
		}
	}

	/**
	 * @return the exceptionMessage
	 */
	public String getExceptionMessage() {
		return exceptionMessage;
	}

	/**
	 * @param exceptionMessage
	 *            the exceptionMessage to set
	 */
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	/**
	 * @return the exceptionClassName
	 */
	public String getExceptionClassName() {
		return exceptionClassName;
	}

	/**
	 * @param exceptionClassName
	 *            the exceptionClassName to set
	 */
	public void setExceptionClassName(String exceptionClassName) {
		this.exceptionClassName = exceptionClassName;
	}
}
