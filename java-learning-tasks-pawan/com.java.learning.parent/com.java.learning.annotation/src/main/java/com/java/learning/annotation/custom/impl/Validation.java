package com.java.learning.annotation.custom.impl;

import java.lang.annotation.Annotation;

public interface Validation< A extends Annotation, T> {
	
	public void intilize(A A);
	
	public boolean isValid(T value);

}
