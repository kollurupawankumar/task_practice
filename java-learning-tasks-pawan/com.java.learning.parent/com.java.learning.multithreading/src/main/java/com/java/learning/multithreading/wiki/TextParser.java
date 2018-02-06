package com.java.learning.multithreading.wiki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;


/**
 * Class contains the logic for parsing the text files
 * @author pawank
 *
 */
public class TextParser implements IParser {

	private static final Logger log = Logger.getLogger(TextParser.class);
	/**
	 * Contains the logic for parsing the text files 
	 */
	@Override
	public List<String> parseWords(String fileName) {
		log.info("Text parse , filename : "+fileName);
		List<String> result = new ArrayList<String>();
		try {
			 Set<String> textList = Files.lines(Paths.get(fileName))
			 .filter(word -> !word.contains("{") || !word.contains("}"))
			 .filter(word -> word.length() != 0)
			 .filter(word -> word.length() != 1  && !word.equals("C"))
			 .collect(Collectors.toSet());
			 result.addAll(textList);
		} catch (IOException e) {
			log.error("Error while reading the file : "+fileName+ "\n Exception : "+e.getMessage());
		}
		return result;
	}

}
