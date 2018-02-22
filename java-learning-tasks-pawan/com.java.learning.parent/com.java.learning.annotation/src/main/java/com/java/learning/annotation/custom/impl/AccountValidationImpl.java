package com.java.learning.annotation.custom.impl;


import com.java.learning.annotation.custom.AccountValidation;

/**
 * Implemenations of validation for the pan card, bank and aadhar numbers 
 * @author pawank
 *
 */
public class AccountValidationImpl implements Validation<AccountValidation, String>{
	
	private String noType;

	@Override
	public void intilize(AccountValidation A) {
		this.noType = A.value();
		
	}

	@Override
	public boolean isValid(String value) {
		if (noType.equalsIgnoreCase("aadhar")){
			String regex = "\\d+";
			if (value != null && value.matches(regex) && value.length() == 16){
				return true;
			}
		}else if (noType.equalsIgnoreCase("pan")) {
			String regex = "^[A-Za-z]{5}\\d{4}[A-Za-z]";
			if (value != null && value.matches(regex) && value.length() == 10){
				return true;
			}
		}else if (noType.equalsIgnoreCase("bank")){
			String regex = "\\d{9}";
			if (value != null && value.matches(regex) && value.length() == 9){
				return true;
			}
		}
		return false;
	}

	
	
}
