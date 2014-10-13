package org.aracrown.commons.identity;

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
		return buildInternal(" ");
	}

	private String buildInternal(String separator) {
		StringBuilder fullName = new StringBuilder();

		if (!Strings.isNullOrEmpty(firstName)) {
			fullName.append(firstName.trim());
		}
		if (!Strings.isNullOrEmpty(lastName)) {
			fullName.append(separator);
			fullName.append(lastName.toUpperCase().trim());
		}
		return fullName.toString().trim();
	}
	
	public String buildForUsername() {
		return buildInternal(".").toLowerCase();
	}
}
