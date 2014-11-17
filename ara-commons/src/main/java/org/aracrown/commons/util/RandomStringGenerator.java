package org.aracrown.commons.util;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.aracrown.commons.security.Hasher;

public class RandomStringGenerator {
	private static final SecureRandom RANDOM = new SecureRandom();

	private static final String LETTERS = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ";
	
	private static final String NUMBERS = "23456789";
	
	private static final String LETTERS_NUMBERS = LETTERS + NUMBERS;
	
	private static final String NUMERICS = LETTERS_NUMBERS + "+@-_#$!:;&%()*";

	public String generateHex() {
		return new Hasher(new BigInteger(130, RANDOM).toString(32)).hashSha256();
	}

	public String generate(int stringLength) {
		return generateValue(NUMERICS, stringLength);
	}
	
	public String generateLettersNumbers(int stringLength) {
		return generateValue(LETTERS_NUMBERS, stringLength);
	}

	private String generateValue(String symbolTable, int stringLength) {
		StringBuilder randomString = new StringBuilder();
		for (int i = 0; i < stringLength; i++) {
			int index = RANDOM.nextInt(symbolTable.length());
			randomString.append(symbolTable.charAt(index));
		}
		return randomString.toString();
	}
}
