package com.java.learning.annotation.model;

import java.util.Date;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.custom.ConsistencyValidation;
import com.java.learning.annotation.custom.ContactPropertiesValidation;
import com.java.learning.annotation.custom.DocumentType;


/**
 * This contains pan information
 * @author pawank
 *
 */
@DocumentType(docName="pan", description="This is pan details")
public class PanDetails  implements Document{

	@ContactPropertiesValidation(value="name")
	@ConsistencyValidation
	private String fullname;

	private String fatherName;

	@AccountValidation(value="pan")
	private String panNumber;

	private String issuedBy;

	@ContactPropertiesValidation(value="dob")
	private String dob;
	
	
	public PanDetails(String fullName, String fatherName, String panNumber, String issuedBy,
						String dob){
		this.fullname=fullName;
		this.fatherName=fatherName;
		this.panNumber=panNumber;
		this.issuedBy=issuedBy;
		this.dob=dob;
	}
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	
}
