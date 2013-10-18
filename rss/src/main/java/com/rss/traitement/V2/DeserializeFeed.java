package com.rss.traitement.V2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.rss.pojo.FeedMessage;

public class DeserializeFeed {

	List<FeedMessage> feed = null;
	static final String PATH = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/";
	
	public Boolean fileExists(String file){
		File fileExists = new File(file);
		if(fileExists.exists())
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<FeedMessage> deserialize(String file) {
		
		if(fileExists(file))
		{
			try
		      {
		         FileInputStream fileIn = new FileInputStream(file);
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         feed = (List<FeedMessage>) in.readObject();
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
		System.out.println("size: "+feed.size());
	    for (int i = 0; i < feed.size(); i++) {
	    	FeedMessage currentFeedMessage = feed.get(i);
	    	System.out.println(currentFeedMessage);
	    }
	    System.out.println("********************/ deserialise**********************");
		return feed;
	}
	
}
