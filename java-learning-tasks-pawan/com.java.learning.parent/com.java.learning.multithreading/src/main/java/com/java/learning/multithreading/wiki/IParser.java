package com.java.learning.multithreading.wiki;

import java.util.List;

/**
 * Interface to implement parser
 * @author pawank
 *
 */
public interface IParser {
	
	List<String> parseWords(String fileName);

}
