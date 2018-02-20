package com.java.learning.annotation.model;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.DocumentType;

@DocumentType(docName="bank", description="This is bank details")
public class Bank  implements Document{

	@AccountValidation(value="bank")
	private String accountNumber;

	private String customerName;

	private String address;

	private String mobileNumber;

	private String email;
	
	public Bank() {
		this.accountNumber="301038920";
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
