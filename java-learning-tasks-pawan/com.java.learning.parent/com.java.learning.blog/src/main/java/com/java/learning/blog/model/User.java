package com.java.learning.blog.model;

import java.util.Observable;
import java.util.Observer;


/**
 * 
 * @author pawank
 *
 */
public class User implements Observer {
	

	private String uName;
	
	
	public String getuName() {
		return uName;
	}


	public void setuName(String uName) {
		this.uName = uName;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("User Name :"+uName + ", Updated date :"+ arg1.toString());		
	}


	

}
