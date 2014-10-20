package org.aracrown.commons.identity;

public enum IdentityProviderType {
	FACEBOOK("light-blue"),
	TWITTER("aqua"),
	GOOGLE("red"),
	GITHUB("grey"),
	LINKEDIN("aqua"),
	INTERNAL("green"),
	OTHER("yellow");
	
	private final String color;
	
	private IdentityProviderType (String color) {
		this.color = color;
	}

	public String color() {
		return color;
	}
	
	public String value() {
		return name().toLowerCase();
	}
}
