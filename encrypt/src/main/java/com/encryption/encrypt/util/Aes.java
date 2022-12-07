package com.encryption.encrypt.util;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class Aes 
{
	private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";
	private static final int TAG_LENGTH_BIT = 128;
	private static final int IV_LENGTH_BYTE = 12;
	private static final int AES_KEY_BIT = 256;

	private static final Charset UTF_8 = StandardCharsets.UTF_8;
	private static final int SALT_LENGTH_BYTE = 16;
	
	public static String encrypt(SecretKey encryptkey,String Password) throws NoSuchAlgorithmException,
	NoSuchPaddingException,InvalidKeyException, InvalidAlgorithmParameterException,
	IllegalBlockSizeException, BadPaddingException {
		byte[] pText= Password.getBytes(UTF_8);
		// 16 bytes salt
		byte[] salt = cryptoutil.getRandomNonce(SALT_LENGTH_BYTE);

		// GCM recommended 12 bytes iv?
		byte[] iv = cryptoutil.getRandomNonce(IV_LENGTH_BYTE);

		Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

		cipher.init(Cipher.ENCRYPT_MODE, encryptkey, new GCMParameterSpec(TAG_LENGTH_BIT, iv));
		byte[] cipherText = cipher.doFinal(pText);

		// prefix IV and Salt to cipher text
		byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length 
				+ cipherText.length).put(iv).put(salt)
				.put(cipherText).array();

		// string representation, base64, send this string to other for decryption.
		return Base64.getEncoder().encodeToString(cipherTextWithIvSalt);

	}

}
