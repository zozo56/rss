package com.rss.traitement.V3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;

public class DeserializeFeed extends Thread{

	Feed feed = null;
	String fileToDeserialize;
	
	public DeserializeFeed(String fileToDeserialize){
		this.start();
		this.fileToDeserialize = fileToDeserialize;
	}
	
	public Boolean fileExists(String file){
		File fileExists = new File(file);
		if(fileExists.exists())
			return true;
		else
			return false;
	}
	
	public synchronized Feed deserialize() {
		
		File fileExists = new File(fileToDeserialize); 
		if(fileExists.exists())
		{
			try
		      {
		         FileInputStream fileIn = new FileInputStream(fileToDeserialize);
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
		}else
		{
			System.out.println("No such file "+fileToDeserialize);
		}
		
		//affichage de l'entete
		System.out.println("********************deserialise**********************");
	    System.out.println(feed);
	    //affichage des messages
	    for (FeedMessage message : feed.getMessages()) {
	      System.out.println(message);
	    }
	    System.out.println("nb feed: "+feed.getMessages().size());
	    System.out.println("******************** deserialise**********************");
	    
		return feed;
	}
	
	public synchronized Feed deserialize(String file) {
		
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
		}else
		{
			System.out.println("No such file "+file);
		}
		
		//affichage de l'entete
		System.out.println("********************deserialise**********************");
	    System.out.println(feed);
	    //affichage des messages
	    for (FeedMessage message : feed.getMessages()) {
	      System.out.println(message);
	    }
	    System.out.println("nb feed: "+feed.getMessages().size());
	    System.out.println("******************** deserialise**********************");
	    
		return feed;
	}
	
	public void run(){
		//deserialize();
	}
	
}
