package org.aracrown.commons.util;

import org.aracrown.commons.security.Hasher;

public class PasswordEncoder {
	public String encodePassword(String password, String passwordSalt, int hashIterations) {
		return new Hasher(password, passwordSalt, hashIterations).hashSha512();
	}
}
