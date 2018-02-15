package com.java.learning.multithreading.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.java.learning.multithreading.common.Constants;
import com.java.learning.multithreading.ds.Trie;
/**
 * This call is used to make the words count of the files in the folders
 * @author pawank
 *
 */
public class WordCountTrie {
	
	private Logger log = Logger.getLogger(WordCountTrie.class);
	
	private Trie trie = new Trie();
	
	
	/**
	 * This method performs the word count 
	 * @param folderName
	 * @throws IOException
	 */
	public void executeWordCount(String folderName) throws IOException{
		
		log.info("Execuitng wordcount for the folder :" + folderName);
		
		List<Path> fileList =  Files.walk(Paths.get(folderName)).collect(Collectors.toList());
		
		
		log.info("No of executors taken : 5");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (Path str : fileList) {
			Runnable worker = new WordCountRunnable(trie, str.toString());
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		
		trie.printAllWordsInTrie(trie.getRoot(), " ");
		log.info("Completed the  wordcount");
	}
	
	public static void main(String[] args) {
		WordCountTrie trie = new WordCountTrie();
		try {
			trie.executeWordCount(Constants.WIKI_OUTPUT_FOLDER);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
