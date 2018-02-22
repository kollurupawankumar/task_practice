package com.java.learning.annotation.custom;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation to hold all the documents
 * @author pawank
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DocumentType {
	
	String docName();
	String description();

}
