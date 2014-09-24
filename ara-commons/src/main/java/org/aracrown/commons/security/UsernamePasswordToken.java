package org.aracrown.commons.security;

import org.apache.shiro.authc.AuthenticationToken;

public class UsernamePasswordToken implements AuthenticationToken{
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

	@Override public Object getPrincipal() {
		return username;
	}

	@Override public Object getCredentials() {
		return password;
	}
}
