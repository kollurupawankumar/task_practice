package com.java.learning.multithreading.wiki;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

/**
 * Code contains CSV parser
 * 
 * @author pawank
 *
 */
public class CSVParser implements IParser {

	private static final Logger log = Logger.getLogger(CSVParser.class);

	/**
	 * Parse the csv file and convert to List of words
	 * Assumption 1. No spaces are allowed 2. No words more that 20 are allowed
	 */
	@Override
	public List<String> parseWords(String fileName) {
		log.info("CSV Parse process for the file : " + fileName);
		List<String> result = new ArrayList<String>();
		try {
			Set<String> csvList = Files.lines(Paths.get(fileName)).map(x -> x.split(",")).flatMap(Arrays::stream)
					.filter(word -> !"".equals(word.trim()) && word.length() <= 20).collect(Collectors.toSet());
			result.addAll(csvList);
		} catch (IOException e) {
			log.error("Exception while performing operation on file : " + e.getMessage());
		}

		return result;
	}

}
