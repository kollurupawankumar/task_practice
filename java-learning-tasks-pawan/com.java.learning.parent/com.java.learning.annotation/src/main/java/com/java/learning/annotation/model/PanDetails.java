package com.java.learning.annotation.model;

import java.util.Date;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.DocumentType;


@DocumentType(docName="pan", description="This is pan details")
public class PanDetails  implements Document{

	private String fullname;

	private String fatherName;

	@AccountValidation(value="pan")
	private String panNumber;

	private String issuedBy;

	private Date dob;
	
	public PanDetails() {
		this.panNumber="BLDPK3848M";
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getIssuedBy() {
		return issuedBy;
	}

	public void setIssuedBy(String issuedBy) {
		this.issuedBy = issuedBy;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
