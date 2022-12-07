package com.encryption.encrypt.services;

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
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.encryption.encrypt.util.Aes;
import com.encryption.encrypt.util.CommonUtil;
import com.encryption.encrypt.util.cryptoutil;

@Service
public class EncryptServiceImpl implements EncryptService
{
	private static final int AES_KEY_BIT = 256;
	
	@Autowired
	cryptoutil cryptout;
	public String encryptPass(String encryptkey,String password) throws 
	NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, 
	IllegalBlockSizeException, BadPaddingException, IOException,IllegalArgumentException,
	InvalidKeyException   
	{
		SecretKey secKey= CommonUtil.convertStringToSecretKeyto(encryptkey);
		return Aes.encrypt(secKey,password);
	}


	
	public String getSecretKey() throws NoSuchAlgorithmException 
	{
		SecretKey key=cryptout.getAESKey(AES_KEY_BIT);
		
		return cryptout.convertSecretKeyToString(key);
	}

	
}

