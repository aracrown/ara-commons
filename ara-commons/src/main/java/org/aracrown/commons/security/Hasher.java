package org.aracrown.commons.security;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.binary.Hex;

public class Hasher {
	enum Algorythim {
		PBKDF2WithHmacSHA256, PBKDF2WithHmacSHA512
	}

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

	private String hash(Algorythim type, int length) {
		PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), passwordSalt.getBytes(), hashIterations, 512);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance(type.name());
			byte[] testHash = skf.generateSecret(spec).getEncoded();
			return Hex.encodeHexString(testHash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new RuntimeException(e);
		}
	}

	public String hashSha512() {
		return hash(Algorythim.PBKDF2WithHmacSHA512, 512);
	}

	public String hashSha256() {
		return hash(Algorythim.PBKDF2WithHmacSHA256, 256);
	}
}
