package com.java.learning.blog.model;

import java.util.List;
import java.util.Observable;

public class Comment extends Observable{
	
	private int id;
	private String comment;
	private List<Comment> replies;
	
	
	public void changeMessage(Comment message) {
		setChanged();
		notifyObservers(message);
	} 
	
	public Comment(int id, String comment, List<Comment> replies) {
		this.id=id;
		this.comment=comment;
		this.replies=replies;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<Comment> getReplies() {
		return replies;
	}
	public void setReplies(List<Comment> replies) {
		this.replies = replies;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", comment=" + comment + ", replies=" + replies + "]";
	}
	
	

}
