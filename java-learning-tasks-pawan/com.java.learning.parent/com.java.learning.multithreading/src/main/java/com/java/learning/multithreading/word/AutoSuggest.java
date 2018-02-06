package com.java.learning.multithreading.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.utils.Constants;

/**
 * This class uses streams for the auto suggestions
 * @author pawank
 *
 */
public class AutoSuggest {
	
	private static final Logger log = Logger.getLogger(AutoSuggest.class);
	
	/**
	 * This class used to get the list of uto suggestions
	 * @param query
	 * @return
	 */
	public List<String> autoSuggest(String query){
		log.info("Entered to check the suggestions for the string :"+query);
		List<String> suggestions = new ArrayList<String>();
		try {
		
			Files.lines(Paths.get(Constants.WORD_CNT_FILE))
			.filter(x -> x.split(":")[0].indexOf(query) != -1)
			.forEach(x -> suggestions.add((x.split(":")[0])));
			
		} catch (IOException e) {
			log.error("Error while reading the file :"+Constants.WORD_CNT_FILE
					+"\n Error :" +e.getMessage() );
		}
		return suggestions;
	}

}
