package org.aracrown.commons.util;

import com.google.common.base.Strings;

public class AccountFullNameBuilder {
	private final String firstName;

	private final String lastName;

	public AccountFullNameBuilder(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String build(String defaultValue) {
		String fullName = build();
		if (Strings.isNullOrEmpty(fullName)) {
			fullName = defaultValue;
		}
		return fullName;
	}

	public String build() {
		StringBuilder fullName = new StringBuilder();

		if (!Strings.isNullOrEmpty(firstName)) {
			fullName.append(firstName);
		}
		if (!Strings.isNullOrEmpty(lastName)) {
			fullName.append(' ');
			fullName.append(lastName.toUpperCase());
		}
		return fullName.toString().trim();
	}
}
