package org.aracrown.commons.security;

public enum DefaultApplicationRoles {
	GUEST("Guest"),
	AUTHENTICATED_USER("Authenticated user"), 
	GUARDIAN_WS_CALLER("Guardian WS caller")
	;
	
	private final String roleName;
	
	private DefaultApplicationRoles(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the roleName
	 */
	public String roleName() {
		return roleName;
	}
}
