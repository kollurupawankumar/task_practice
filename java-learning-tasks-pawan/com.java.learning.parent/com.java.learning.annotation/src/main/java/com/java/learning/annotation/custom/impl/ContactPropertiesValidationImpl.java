package com.java.learning.annotation.custom.impl;

import com.java.learning.annotation.custom.ContactPropertiesValidation;
import com.java.learning.annotation.model.Constants;


/**
 * Implementation for the contct details validation
 * @author pawank
 *
 */
public class ContactPropertiesValidationImpl implements Validation<ContactPropertiesValidation, String>{

	private String type;
	
	
	@Override
	public void intilize(ContactPropertiesValidation a) {
		this.type=a.value();
	}

	@Override
	public boolean isValid(String value) {
		String regex=null;
		if (Constants.NAME.equalsIgnoreCase(type)){
			regex="[a-zA-Z]+";
		}else if (Constants.DATE.equalsIgnoreCase(type)) {
			regex="\\d{2}-\\d{2}-\\d{4}";
		}else if (Constants.PHONE.equalsIgnoreCase(type)) {
			regex="\\d{10}";
		}else if (Constants.EMAIL.equalsIgnoreCase(type)) {
			regex="[a-zA-Z]+@[a-z].com";
		}
		if (value != null && regex!=null && value.matches(regex)){
			return true;
		}
		return false;
	}

}
