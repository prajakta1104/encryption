package com.ksb.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EncryptController 
{

	@GetMapping(value="encrypt/{encryptkey}/{password}")
	public void encryptPassword(@PathVariable  String encryptkey, @PathVariable String password)
	{
		
	}

}
