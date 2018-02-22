package com.java.learning.collections;

/**
 * LRU Implementation using array and String
 * @author pawank
 *
 */
public class LRUImpl implements ILRU {

	private String[] lru;

	private int index = -1;

	private int capacity;

	public LRUImpl(int size) {
		lru = new String[size];
		this.capacity = size;
	}
	
	/**
	 * This method is used to check the weather a string is present or not
	 * @param element
	 * @return
	 */
	private int getIndex(String element) {
		for (int i = 0; i < capacity; i++) {
			if (lru[i] == element)
				return i;
		}
		return -1;
	}
	
	/**
	 * This method is used to add a string to LRU
	 * If size is there following should be the output
	 * Added (pawan, billa, pawan)
	 * pawan null null 
	 * billa pawan null 
	 * pawan billa null 

	 */
	@Override
	public void add(String url) {
		int index1 = getIndex(url);
		index++;
		if (lru[0] == null) {
			lru[index] = url;

		} else if (index1 != -1) {
			delete(index1);
			lru[0] = url;
		} else if (index == capacity) {
			delete(capacity);
			lru[0] = url;
		} else if (index < capacity) {
			delete(index);
			lru[0] = url;
		}

	}

	/**
	 * This method is used to manuplate the array
	 */
	@Override
	public void delete(int index) {
		for (int i = index; i > 0; i--) {
			lru[i] = lru[i-1];
		}

	}

	/**
	 * This method is used to print the LRU output
	 */
	@Override
	public void printLRU() {
		for (int i = 0; i < capacity; i++) {
			System.out.print(lru[i]+" ");
		}
		System.out.println();

	}

	public static void main(String[] args) {
		ILRU lru = new LRUImpl(3);
		lru.add("pawan");
		lru.printLRU();
		lru.add("billa");
		lru.printLRU();
		//lru.add("chanti");
		//lru.printLRU();
		lru.add("pawan");
		lru.printLRU();

	}

}
