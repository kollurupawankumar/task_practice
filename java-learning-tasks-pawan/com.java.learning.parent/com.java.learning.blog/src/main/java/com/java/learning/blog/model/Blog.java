package com.java.learning.blog.model;

import java.util.List;
import java.util.Observable;

public class Blog extends Observable {
	
	private int id;

	private List<Article> articles;

	private List<WhitePaper> whitePapers;

	private List<Comment> comments;
	
	public void changeMessage(Blog message, Object obj) {
		setChanged();
		notifyObservers(message);
		if (obj instanceof Article){
			Article article = (Article) obj;
			for (Article a : articles){
				if ( a != null && article.getId() == a.getId()){
					a.changeMessage(a);
				}
			}
		}else if (obj instanceof WhitePaper) {
			WhitePaper wp = (WhitePaper) obj;
			for (WhitePaper a : whitePapers){
				if ( a != null && wp.getId() == a.getId()){
					a.changeMessage(a);
				}
			}
		}else if (obj instanceof Comment) {
			Comment comment = (Comment) obj;
			for (Comment a : comments){
				if ( a != null && comment.getId() == a.getId()){
					a.changeMessage(a);
				}
			}
		}
	
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<WhitePaper> getWhitePapers() {
		return whitePapers;
	}

	public void setWhitePapers(List<WhitePaper> whitePapers) {
		this.whitePapers = whitePapers;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	} 
	
	

	
	

}
