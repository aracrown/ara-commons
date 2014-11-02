package org.aracrown.commons.util;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.aracrown.commons.security.Hasher;

public class RandomStringGenerator {
	private static final SecureRandom RANDOM = new SecureRandom();

	private static final String LETTERS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ23456789+@-_#$!:;&%()*";

	public String generateHex() {
		return new Hasher(new BigInteger(130, RANDOM).toString(32)).hashSha256();
	}

	public String generate(int stringLength) {
		StringBuilder randomString = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int index = RANDOM.nextInt(LETTERS.length());
			randomString.append(LETTERS.charAt(index));
		}
		return randomString.toString();
	}
}
