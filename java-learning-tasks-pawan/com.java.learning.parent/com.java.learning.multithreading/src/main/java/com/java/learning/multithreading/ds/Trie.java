package com.java.learning.multithreading.ds;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private TrieNode root;

	// Constructor
	public Trie() {
		root = new TrieNode((char) 0);
	}
	
	public void traverse(TrieNode root){
		TrieNode crawl = root;
		if (root == null ){
			root = this.root;
		}
		for (Map.Entry<Character, TrieNode> map : root.getChildren().entrySet()){
			System.out.print(root.getValue());
			traverse(map.getValue());
			if (map.getValue().isEnd()){
				System.out.println("");
			}
		}
		
	}

	// Method to insert a new word to Trie
	public void insert(String word) {

		// Find length of the given word
		int length = word.length();
		TrieNode crawl = root;
		// Traverse through all characters of given word
		for (int level = 0; level < length; level++) {
			HashMap<Character, TrieNode> child = crawl.getChildren();
			char ch = word.charAt(level);

			// If there is already a child for current character of given word
			if (child.containsKey(ch))
				crawl = child.get(ch);
			else // Else create a child
			{
				TrieNode temp = new TrieNode(ch);
				child.put(ch, temp);
				crawl = temp;

			}
		}

		// Set bIsEnd true for last character
		crawl.setIsEnd(true);

	}
}
