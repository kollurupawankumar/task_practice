package com.java.learning.multithreading.wiki;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import org.apache.log4j.Logger;

/**
 * Factory bean to get the type of the parser
 * @author pawank
 *
 */
public class ParseFactoy {
	
	  private static final Logger log = Logger.getLogger(ParseFactoy.class);
	
	  final static Map<String, Supplier<IParser>> map = new HashMap<>();

	  static {
	    map.put("csv", CSVParser::new);
	    map.put("text", TextParser::new);
	  }   

	  /**
	   * Factory method to get the type of parser based on the input
	   * @param parseType
	   * @return
	   */
	  public IParser getParser(String parseType){

		 log.info("Parse factory , Input type = "+parseType);
	     Supplier<IParser> parser = map.get(parseType.toLowerCase());
	     if(parser != null) {
	       return parser.get();
	     }
	     throw new IllegalArgumentException("No such Parser " + parseType.toLowerCase());

	  }

}
