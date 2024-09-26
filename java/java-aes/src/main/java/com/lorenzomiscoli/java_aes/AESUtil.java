package com.lorenzomiscoli.java_aes;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

	private static final String ALGORITHM = "AES";

	private static final String TRANSFORMATION = "AES/CBC/PKCS5PADDING";

	private static final String KEY = "aesEncryptionKey";

	private static final int IV_LENGTH = 16;

	public SecretKeySpec hashKey() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update(KEY.getBytes("UTF-8"));
		byte[] keyBytes = new byte[IV_LENGTH];
		System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
		return new SecretKeySpec(keyBytes, ALGORITHM);
	}

	public String encrypt(String plainValue)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] valueBytes = plainValue.getBytes();

		// Generate IV.
		byte[] iv = new byte[IV_LENGTH];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		// Hash key.
		SecretKeySpec secretKeySpec = hashKey();

		// Encrypt.
		Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] encrypted = cipher.doFinal(valueBytes);

		// Combine IV and encrypted part.
		byte[] encryptedIVAndText = new byte[IV_LENGTH + encrypted.length];
		System.arraycopy(iv, 0, encryptedIVAndText, 0, IV_LENGTH);
		System.arraycopy(encrypted, 0, encryptedIVAndText, IV_LENGTH, encrypted.length);
		return Base64.getEncoder().encodeToString(encryptedIVAndText);
	}

	public String decrypt(String encrypted)
			throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		byte[] encryptedIvTextBytes = Base64.getDecoder().decode(encrypted);

		// Extract IV.
		byte[] iv = new byte[IV_LENGTH];
		System.arraycopy(encryptedIvTextBytes, 0, iv, 0, iv.length);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		// Extract encrypted part.
		int encryptedSize = encryptedIvTextBytes.length - IV_LENGTH;
		byte[] encryptedBytes = new byte[encryptedSize];
		System.arraycopy(encryptedIvTextBytes, IV_LENGTH, encryptedBytes, 0, encryptedSize);

		// Hash key.
		SecretKeySpec secretKeySpec = hashKey();

		// Decrypt.
		Cipher cipherDecrypt = Cipher.getInstance(TRANSFORMATION);
		cipherDecrypt.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		byte[] decrypted = cipherDecrypt.doFinal(encryptedBytes);

		return new String(decrypted);
	}

}
