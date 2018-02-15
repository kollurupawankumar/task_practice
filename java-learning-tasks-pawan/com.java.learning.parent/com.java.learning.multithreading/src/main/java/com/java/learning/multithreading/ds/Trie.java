package com.java.learning.multithreading.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import junit.framework.Assert;

/**
 * This contains the operations on the Trie data structure
 * @author pawank
 *
 */
public class Trie {
	
	private Logger log = Logger.getLogger(Trie.class);

	private TrieNode root;
	
	private List<TrieResponseModel> wordCount = new ArrayList<TrieResponseModel>();
	

	/* Constructor */
	public Trie() {
		log.info("Created the trie data structure : Contructor()");
		root = new TrieNode(' ');
	}
	
	public TrieNode getRoot(){
		return root;
	}

	/**
	 * This function is used to insert a word in trie
	 * @param word
	 */
	public synchronized void insert(String word) {
		if (searchNode(word) != null){
			TrieNode current = searchNode(word);
			current.count++;
			return;	
		}
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.getChild(ch);
			if (child != null)
				current = child;
			else {
				// If child not present, adding it io the list
				current.childList.add(new TrieNode(ch));
				current = current.getChild(ch);
			}
			
			
		}
		current.isEnd = true;
		current.count++;
	}
	
	/**
	 * This function is used to search Node of that word in trie
	 * @param word
	 * @return
	 */
	public synchronized TrieNode searchNode(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return null;
			else
				current = current.getChild(ch);
		}
		if (current.isEnd == true)
			return current;
		return null;
	}

	/**
	 * This function is used to search a word in trie
	 * @param word
	 * @return
	 */
	public synchronized boolean search(String word) {
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			if (current.getChild(ch) == null)
				return false;
			else
				current = current.getChild(ch);
		}
		if (current.isEnd == true)
			return true;
		return false;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	 public List<TrieResponseModel> containsPrefix(String prefix) {
	       TrieNode triNode =  searchNode(prefix);
	       if (triNode == null){
	    	   triNode = getRoot();
	       }
	       LinkedList<TrieNode> children = triNode.childList;
	       for (TrieNode node : children){
	    	   getWordsFromNodeInTrie(node, " ");
	       }
	       return wordCount;
	    }


	
	/**
	 *  This function is used to remove function from trie 
	 * @param word
	 */
	public synchronized void remove(String word) {
		if (search(word) == false) {
			System.out.println(word + " does not present in trien");
			return;
		}
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.getChild(ch);
			if (child.count == 1) {
				current.childList.remove(child);
				return;
			} else {
				child.count--;
				current = child;
			}
		}
		current.isEnd = false;
	}

	/**
	 * Print all the words from the data structures
	 * @param root
	 * @param s
	 */
	public void getWordsFromNodeInTrie(TrieNode root, String s) {
		if ("".equalsIgnoreCase(s.trim())){
			wordCount = new ArrayList<TrieResponseModel>();
		}
		TrieNode current = root;
		if (root.childList == null || root.childList.size() == 0)
			return;
		Iterator<TrieNode> iter = current.childList.iterator();
		while (iter.hasNext()) {
			TrieNode node = iter.next();
			s += node.data;
			getWordsFromNodeInTrie(node, s);
			if (node.isEnd == true) {
				TrieResponseModel model = new TrieResponseModel();
				model.setWord(s);
				model.setCount(node.count);
				wordCount.add(model);
				s = s.substring(0, s.length() - 1);
			} else {
				s = s.substring(0, s.length() - 1);
			}
		}

	}

	public List<TrieResponseModel> getWordCount() {
		return wordCount;
	}

	
	
	
}
