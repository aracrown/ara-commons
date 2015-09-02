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
public class ExceptionResource implements Serializable {
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

	/** The exception description if available. */
	private String description;

	/**
	 * Default constructor.
	 */
	public ExceptionResource() {
	}

	/**
	 * Constructor with exception.
	 * 
	 * @param throwable
	 *            exception as input to be able to construct the entity
	 * @param description
	 *            error description if available
	 */
	public ExceptionResource(Throwable throwable, String description) {
		this.exceptionClassName = throwable.getClass().getName();
		this.exceptionMessage = throwable.getMessage();
		this.description = description;
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

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
