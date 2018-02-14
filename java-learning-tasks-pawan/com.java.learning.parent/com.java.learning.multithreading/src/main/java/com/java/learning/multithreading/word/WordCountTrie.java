package com.java.learning.multithreading.word;

import com.java.learning.multithreading.ds.Trie;
import com.java.learning.multithreading.ds.TrieNode;

public class WordCountTrie {
	
	public static void main(String[] args) {
		 Trie dict = new Trie();
	        dict.insert("are");
	        dict.insert("area");
	        dict.insert("base");
	        dict.insert("cat");
	        dict.insert("cater");
	        dict.insert("basement");
	        
	        //traverse
	        dict.traverse(null);
	}

}
