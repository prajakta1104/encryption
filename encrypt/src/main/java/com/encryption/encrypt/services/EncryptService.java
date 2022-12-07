package com.encryption.encrypt.services;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
@Service
public interface EncryptService 
{
	public String encryptPass(String plainText,String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IOException, IllegalArgumentException;
	public String getSecretKey() throws NoSuchAlgorithmException;
	
}
