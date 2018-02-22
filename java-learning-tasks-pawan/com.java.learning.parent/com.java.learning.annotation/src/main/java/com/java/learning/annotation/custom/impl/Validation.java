package com.java.learning.annotation.custom.impl;

import java.lang.annotation.Annotation;

/**
 * Main Interface to implement validations
 * @author pawank
 *
 * @param <A>
 * @param <T>
 */
public interface Validation< A extends Annotation, T> {
	
	public void intilize(A A);
	
	public boolean isValid(T value);

}
