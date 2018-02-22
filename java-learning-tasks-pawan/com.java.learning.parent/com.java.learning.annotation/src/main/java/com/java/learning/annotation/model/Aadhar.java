package com.java.learning.annotation.model;

import java.util.Date;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.ConsistencyValidation;
import com.java.learning.annotation.custom.DocumentType;
import com.java.learning.annotation.custom.ContactPropertiesValidation;

/**
 * Aadhar information
 * @author pawank
 *
 */
@DocumentType(docName="aadhar", description="this is aadhar details")
public class Aadhar implements Document{

	@AccountValidation(value="aadhar")
	private String aadharNo;

	@ContactPropertiesValidation(value="name")
	@ConsistencyValidation
	private String fullname;

	@ContactPropertiesValidation(value="gender")
	private String gender;

	private String address;

	@ContactPropertiesValidation(value="dob")
	private String dob;
	
	public Aadhar(String aadharNo, String fullName, String gender,
					String address, String dob){
		this.aadharNo=aadharNo;
		this.fullname=fullName;
		this.gender=gender;
		this.address=address;
		this.dob=dob;
	}
	
	
	public Aadhar() {
		this.aadharNo="8206223333445566";
	}

	public String getAadharNo() {
		return aadharNo;
	}

	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	

}
