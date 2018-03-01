package com.java.learning.blog.model;

import java.util.Observable;

/**
 * This conatins the white paper information
 * 
 * @author pawank
 *
 */
public class WhitePaper extends Observable {

	private int id;
	private String title;
	private String content;
	private String docLocation;
	
	public WhitePaper(int id, String title, String content, String docLocation) {
		this.id=id;
		this.title=title;
		this.content = content;
	}

	public void changeMessage(WhitePaper message) {
		setChanged();
		notifyObservers(message);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDocLocation() {
		return docLocation;
	}

	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}

	@Override
	public String toString() {
		return "WhitePaper [id=" + id + ", title=" + title + ", content=" + content + ", docLocation=" + docLocation
				+ "]";
	}

	
	
}
