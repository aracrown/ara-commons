package org.aracrown.commons.util;

import org.aracrown.commons.security.Hasher;

public class PasswordEncoder {
	// Default password pattern: 1 digit, 1 lower, 1 upper, 1 symbol "@#$%!", from 8 to 20
	public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@\\-#$%!\\?]).{8,})";

	public String encodePassword(String password, String passwordSalt, int hashIterations) {
		return new Hasher(password, passwordSalt, hashIterations).hashSha512();
	}
}
