package com.java.learning.blog;

import java.util.Arrays;
import java.util.Collections;

import com.java.learning.blog.model.Article;
import com.java.learning.blog.model.Blog;
import com.java.learning.blog.model.Comment;
import com.java.learning.blog.model.User;
import com.java.learning.blog.model.WhitePaper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       User[] u = new User[10];
       Article[] a = new Article[3];
       WhitePaper[] wp = new WhitePaper[3];
       Comment[] c = new Comment[3];
       
       for(int i=0 ; i <=9 ; i++){
    	   u[i] = new User();
    	   u[i].setuName("Pawan"+i);
    	   if (i<3){
    		   a[i] = new Article(i, "sample "+i, "description "+i, null, null);
    		   a[i].addObserver(u[i]);
    	   }else if(i < 6){
    		   wp[i-3] = new WhitePaper(i, "white paper :"+i, "sample Content :"+i, "sample location");
    		   wp[i-3].addObserver(u[i]);
    	   }else if (i<9){
    		   c[i-6] = new Comment(i, "Comments :"+i, null);
    		   c[i-6].addObserver(u[i]);
    	   }		   
    	 
       }
       
       Blog b = new Blog();
	   b.setArticles(Arrays.asList(a));
	   b.setWhitePapers(Arrays.asList(wp));
	   b.setComments(Arrays.asList(c));
	   
	   b.changeMessage(b, a[2]);
    }
}
