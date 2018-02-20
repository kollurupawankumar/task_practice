package com.java.learning.annotation.model;

import java.util.Date;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.DocumentType;


@DocumentType(docName="aadhar", description="this is aadhar details")
public class Aadhar implements Document{

	@AccountValidation(value="aadhar")
	private String aadharNo;

	private String fullname;

	private String gender;

	private String address;

	private Date dob;
	
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
