package com.java.learning.multithreading.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.common.Constants;
import com.java.learning.multithreading.common.IOUtils;
import com.java.learning.multithreading.exception.MultiThreadException;

/**
 * This class is used to take input as folder and generate the distinct word
 * count on each word
 * 
 * @author pawank
 *
 */
public class WordCount {

	private static final Logger log = Logger.getLogger(WordCount.class);

	public void getWordCount(String folderName) {

		log.info("Entering into word count method ");

		Path intermediatePath = Paths.get(Constants.WORD_CNT_INT_FILE);
		if (Files.exists(intermediatePath)) {
			try {
				Files.delete(intermediatePath);
				Files.createFile(intermediatePath);
			} catch (IOException e) {
				log.error("Error performing the file Operations :" + e.getMessage());
			}
		}

		try (Stream<Path> paths = Files.walk(Paths.get(folderName))) {
			paths.forEach(x -> {
				if (!x.endsWith("wiki_output")) {
					try {
						log.info("Getting the words for the file :" + x);
						Stream<String> stre = Files.lines(x).map(w -> w.split("\\s+")).flatMap(Arrays::stream).sorted();
						IOUtils.writeToFile(Constants.WORD_CNT_INT_FILE, stre, StandardOpenOption.APPEND);
						log.info("Successfully written to the file :" + Constants.WORD_CNT_INT_FILE);
					} catch (Exception e) {
						log.error("Error while writing to the file :" + e.getMessage());
					}

				}

			});

			// perform a word count now on the file

			Map<String, Integer> wordCounter = Files.lines(intermediatePath).collect(Collectors.toList()).stream()
					.collect(Collectors.toMap(w -> w.toLowerCase(), w -> 1, Integer::sum));

			Map<String, Integer> wordCounter1 = new TreeMap<String, Integer>(wordCounter);
			String file1 = "";
			for (Map.Entry<String, Integer> map : wordCounter1.entrySet()) {
				file1 = file1 + map.getKey() + ":" + map.getValue() + "\n";
			}
			IOUtils.writeToFile(Constants.WORD_CNT_FILE, file1);

		} catch (IOException e) {
			log.error("Error while streaming the files : " + e.getMessage());
		} catch (MultiThreadException e) {
			log.error("Error while writing the word count file :" + e.getMessage());
		}

	}

}
