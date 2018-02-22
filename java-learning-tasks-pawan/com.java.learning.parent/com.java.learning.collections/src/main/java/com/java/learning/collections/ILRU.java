package com.java.learning.collections;

/**
 * Interface for LRU implementation
 * @author pawank
 *
 */
public interface ILRU {
	public void add(String url);
	
	public void delete(int index);
	
	public void printLRU();
}
