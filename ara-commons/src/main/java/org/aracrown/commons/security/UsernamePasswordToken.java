package org.aracrown.commons.security;

public class UsernamePasswordToken {
	/**
     * The username
     */
    private String username;

    /**
     * The password, in char[] format
     */
    private char[] password;
    
    public UsernamePasswordToken(final String username, final String password) {
    	this.username = username;
    	this.password = password != null ? password.toCharArray() : null;
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
