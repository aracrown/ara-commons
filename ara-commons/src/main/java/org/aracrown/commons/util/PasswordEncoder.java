package org.aracrown.commons.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordEncoder {
	private static final String ALGORITHM_NAME = "SHA-512";

	public String encodePassword(String password, String passwordSalt, int hashIterations) {
		return new SimpleHash(ALGORITHM_NAME, password, passwordSalt, hashIterations).toHex();
	}
}
