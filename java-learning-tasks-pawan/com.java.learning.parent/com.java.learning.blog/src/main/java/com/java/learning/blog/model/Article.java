package com.java.learning.blog.model;

import java.util.Arrays;
import java.util.Observable;

/**
 * This conatins the article information
 * 
 * @author pawank
 *
 */
public class Article extends Observable {

	private int id;
	private String title; // mandadtory
	private String description; // optional
	private byte[] video; // optional
	private byte[] image; // optional
	
	public Article(int id, String title, String description, byte[] video, byte[] image) {
		this.id = id;
		this.title=title;
		this.description = description;
		this.video = video;
		this.image = image;
	}
	
	public void changeMessage(Article message) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", video="
				+ Arrays.toString(video) + ", image=" + Arrays.toString(image) + "]";
	}
	
	

}
