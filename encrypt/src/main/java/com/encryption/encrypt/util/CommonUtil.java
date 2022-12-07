package com.encryption.encrypt.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.encryption.encrypt.util.Aes;


public class CommonUtil 
{
	public static SecretKey convertStringToSecretKeyto(String encodedKey)
	{
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        return  new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }
	
	


public static String convertToString(InputStream inputStream, Charset charset) throws IOException {
	 
	try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, charset))) {
		return br.lines().collect(Collectors.joining(System.lineSeparator()));
	}
}
}
