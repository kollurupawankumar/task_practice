package com.java.learning.multithreading.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.java.learning.multithreading.ds.Trie;

public class WordCountRunnable implements Runnable {

	private Trie trie;

	private String fileName;

	public WordCountRunnable(Trie trie, String fileName) {
		this.trie = trie;
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			List<String> strList = Files.lines(Paths.get(fileName)).map(w -> w.split("\\s+")).flatMap(Arrays::stream)
					.collect(Collectors.toList());
			for (String str : strList) {
				trie.insert(str);
			}

		} catch (IOException e) {

		}

	}

}
