package com.java.learning.multithreading.wiki;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.utils.Constants;

/**
 * Class readds the file and creates words, uses the executor service to perform
 * a write operation
 * 
 * @author pawank
 *
 */
public class WikiOperation {

	private static final Logger log = Logger.getLogger(WikiOperation.class);

	public void performOperation() {
		log.info("Entering into the method : performOperation()");
		List<String> words = new ArrayList<String>();
		Supplier<ParseFactoy> parseFactory = ParseFactoy::new;

		log.info("Getting the list of words from CSV files");
		for (String csvFile : Constants.WIKI_CSV_FILE_LIST) {
			words.addAll(parseFactory.get().getParser("csv").parseWords(csvFile));
		}
		log.info("Count of words after the csv parse:" + words.size());

		log.info("Getting the list of words from Txt files");
		for (String csvFile : Constants.WIKI_TXT_FILE_LIST) {
			words.addAll(parseFactory.get().getParser("text").parseWords(csvFile));
		}
		log.info("Count of words after the txt parse:" + words.size());

		log.info("Calling the executor service:");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (String str : words) {
			Runnable worker = new WikiRunnable(str);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		log.info("Finished all threads");
	}

}
