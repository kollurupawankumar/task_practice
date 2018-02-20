package com.java.learning.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.java.learning.annotation.custom.AccountValidation;
import com.java.learning.annotation.model.Aadhar;
import com.java.learning.annotation.model.Bank;
import com.java.learning.annotation.model.Document;
import com.java.learning.annotation.model.PanDetails;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalArgumentException, IllegalAccessException
    {
    	List<Document> res =  new ArrayList<Document>();
        Document bank = new Bank();
        Document pan = new PanDetails();
        Document aad = new Aadhar();
        
        res.add(bank);
        res.add(aad);
        res.add(pan);
        
        Field[] fields = bank.getClass().getDeclaredFields();
        for (Field f : fields){
        	f.setAccessible(true);
        	System.out.println(f.get(bank));
        	Annotation[] ann = f.getAnnotations();
        	for (Annotation a : ann){
        		if (a instanceof AccountValidation ){
        			
        		}
        	}
        }
    }
}
