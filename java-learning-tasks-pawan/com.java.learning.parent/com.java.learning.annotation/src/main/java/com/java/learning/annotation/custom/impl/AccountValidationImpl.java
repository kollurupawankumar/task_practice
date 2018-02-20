package com.java.learning.annotation.custom.impl;


import com.java.learning.annotation.custom.AccountValidation;


public class AccountValidationImpl implements Validation<AccountValidation, String>{
	
	private String noType;

	@Override
	public void intilize(AccountValidation A) {
		this.noType = A.value();
		
	}

	@Override
	public boolean isValid(String value) {
		// TODO Auto-generated method stub
		if (noType.equalsIgnoreCase("aadhar")){
			//all digits
			//16 digits 
			//
		}
		return false;
	}

	
	
}
