package org.aracrown.commons.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Hasher {
	private static final String PBKDF2_WITH_HMAC_SHA256 = "PBKDF2WithHmacSHA256";
	private static final String PBKDF2_WITH_HMAC_SHA512 = "PBKDF2WithHmacSHA512";
	
	private final String password;
	private final String passwordSalt;
	private final int hashIterations;

	public Hasher(String password) {
		this.password = password;
		this.passwordSalt = "DEFAULT";
		this.hashIterations = 1;
	}
	
	public Hasher(String password, String passwordSalt, int hashIterations) {
		this.password = password;
		this.passwordSalt = passwordSalt;
		this.hashIterations = hashIterations;
	}

	private String hash(String algorithm, int length) {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), passwordSalt.getBytes(), hashIterations, 512);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance(algorithm);
			byte[] testHash = skf.generateSecret(spec).getEncoded();
			return Hex.encodeHexString(testHash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new HasherException(String.format("Could not generate the requested hash: %s (Length: %d)", algorithm, length), e);
		}
	}

	public String hashSha512() {
		return hash(PBKDF2_WITH_HMAC_SHA512, 512);
	}

	public String hashSha256() {
		return hash(PBKDF2_WITH_HMAC_SHA256, 256);
	}
}
