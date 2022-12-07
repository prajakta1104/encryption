package com.encryption.encrypt.controller;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encryption.encrypt.services.EncryptService;
import com.encryption.encrypt.services.EncryptServiceImpl;
import com.encryption.encrypt.util.cryptoutil;

import Pojo.UserDto;

@RestController
public class EncryptController 
{
	

	String encryptedPassword;
	
	@Autowired
	EncryptService encryptservice;

	@PostMapping(value="encryption")
	public String encryptPassword(@RequestBody  UserDto userdto) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, IllegalArgumentException, IOException 
	{
		
		return encryptservice.encryptPass(userdto.getEncrypt(),userdto.getPassword());
		
	 }
	

	
	@GetMapping(value="generateKey")
	public  String getSecretKey() throws NoSuchAlgorithmException 
	{	
		return encryptservice.getSecretKey();
	}

}
