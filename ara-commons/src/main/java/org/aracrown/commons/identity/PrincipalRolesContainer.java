package org.aracrown.commons.identity;

import java.util.ArrayList;
import java.util.List;

public class PrincipalRolesContainer {
	private List<String> roles = new ArrayList<>();

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
