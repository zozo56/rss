package com.rss.traitement.V4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.rss.pojo.V4.Feed;
import com.rss.pojo.V4.FeedMessage;

public class DeserializeFeed {

	Feed feed = null;
	
	public Boolean fileExists(String file){
		File fileExists = new File(file);
		if(fileExists.exists())
			return true;
		else
			return false;
	}
	
	public Feed deserialize(String file) {
		
		File fileExists = new File(file); 
		if(fileExists.exists())
		{
			try
		      {
		         FileInputStream fileIn = new FileInputStream(file);
		         ObjectInputStream in = new ObjectInputStream(fileIn); 
		         feed = (Feed) in.readObject(); 
		         
		         in.close();
		         fileIn.close();
		      }catch(IOException i)
		      {
		         i.printStackTrace();
		      }catch(ClassNotFoundException c)
		      {
		         System.out.println("Feed class not found");
		         c.printStackTrace();
		      }
			
			
			//affichage de l'entete
			System.out.println("********************deserialise**********************");
		    //affichage des messages
		    for (Entry<String, FeedMessage> message : feed.getMessages().entrySet()) {
		    	//System.out.println(message.getValue().getTitle());
		    	message.getValue().getAuthor();
		    	message.getValue().getDescription();
		    	message.getValue().getTitle();
	    	}
		    System.out.println("Title: "+feed.getTitle());
		    System.out.println("nb feed: "+feed.getMessages().size());
		    System.out.println("******************** /deserialise**********************");
		}else
		{
			System.out.println("No such file "+file);
		}
		
		return feed;
	}
	
	
}
