package org.aracrown.commons.security;

import java.io.Serializable;

public class UsernamePasswordToken implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The username
	 */
	private final String username;

	/**
	 * The password, in char[] format
	 */
	private final char[] password;

	private final String remoteAddress;

	public UsernamePasswordToken(final String username, final String password, String remoteAddress) {
		this.username = username;
		this.password = password != null ? password.toCharArray() : null;
		this.remoteAddress = remoteAddress;
	}

	public String getRemoteAddress() {
		return remoteAddress;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public char[] getPassword() {
		return password;
	}
}
