package com.java.learning.multithreading;

import com.java.learning.multithreading.split.SplitFile;
import com.java.learning.multithreading.utils.Constants;
import com.java.learning.multithreading.wiki.WikiOperation;
import com.java.learning.multithreading.word.AutoSuggest;
import com.java.learning.multithreading.word.WordCount;

/**
 * This is single file which runs of all four tasks
 * 
 * @author pawank
 *
 */
public class App {
	public static void main(String[] args) {
		SplitFile sp = new SplitFile();
		sp.splitOperation(Constants.SPLIT_LINES_INPUT, 50000);

		WikiOperation operation = new WikiOperation();
		operation.performOperation();

		WordCount w = new WordCount();
		w.getWordCount(Constants.WIKI_OUTPUT_FOLDER);

		AutoSuggest as = new AutoSuggest();
		for (String s : as.autoSuggest("jay")) {
			System.out.println(s);
		}
	}
}
