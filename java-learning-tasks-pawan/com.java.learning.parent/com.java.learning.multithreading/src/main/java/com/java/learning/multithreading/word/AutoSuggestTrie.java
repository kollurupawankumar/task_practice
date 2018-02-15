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
import com.java.learning.multithreading.ds.TrieResponseModel;

/**
 * This class uses streams for the auto suggestions
 * @author pawank
 *
 */
public class AutoSuggestTrie {
	
private Logger log = Logger.getLogger(AutoSuggestTrie.class);
	
	private Trie trie = new Trie();
	
	
	/**
	 * This method performs the word count 
	 * @param folderName
	 * @throws IOException
	 */
	public void executeAutoSuggestions(String folderName, String prefix) throws IOException{
		
		log.info("Execuitng wordcount for the folder :" + folderName);
		
		List<Path> fileList =  Files.walk(Paths.get(folderName)).collect(Collectors.toList());
		
		
		log.info("No of executors taken : 5");
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (Path str : fileList) {
			if (str.toString().equalsIgnoreCase(Constants.WIKI_OUTPUT_FOLDER)){
				continue;
			}
			Runnable worker = new AutoSuggestRunnable(trie, str.toString(), prefix);
			executor.execute(worker);
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		
		log.info("Completed the  wordcount");
	}
	
	public void printWordCount(){
		for (TrieResponseModel model : trie.getWordCount()){
			System.out.println(model.getWord()+":"+model.getCount());
		}
	}
	
	public static void main(String[] args) {
		AutoSuggestTrie tri = new AutoSuggestTrie();
		try {
			tri.executeAutoSuggestions(Constants.WIKI_OUTPUT_FOLDER, "java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
