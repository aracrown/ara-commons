package org.aracrown.commons.identity;

public enum IdentityProviderType {
	FACEBOOK,
	TWITTER,
	GOOGLE,
	GITHUB,
	LINKEDIN,
	INTERNAL,
	OTHER;
	
	
	public String value() {
		return name().toLowerCase();
	}
}
