package org.aracrown.commons.util;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestItem {
	@NotNull(message = "Value is missing")
	private String value;

	@Size(min = 3, max = 5, message = "Value size must be between " + 3 + " and " + 5)
	private String value1;

	@NotNull(message = "Name is missing")
	@Size(max = 255)
	private String name;

	/**
	 * @return the value1
	 */
	public String getValue1() {
		return value1;
	}

	/**
	 * @param value1
	 *            the value1 to set
	 */
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
