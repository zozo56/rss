package com.rss.traitement.V4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map.Entry;

import com.rss.pojo.V4.Feed;
import com.rss.pojo.V4.FeedMessage;

public class SerializeFeed {
	static final String PATH = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/";
	private DeserializeFeed deserialize;
	String filePath;
	Feed feedOld;
	
	public Feed serialize(String folderName,Feed feed) {
		filePath = PATH+folderName+"/feed.ser";
		deserialize = new DeserializeFeed();
		
		if(deserialize.fileExists(filePath))
		{
			
			feedOld = deserialize.deserialize(filePath);
			
			for (Entry<String, FeedMessage> message : feed.getMessages().entrySet()) {
		    	if(!feedOld.containsKey(message.getKey())){
		    		feedOld.putMessage(message.getKey(), message.getValue());
		    		//System.err.println("nouveu message");
		    		//System.out.println(message.getValue());
		    	}
	  	    }
			
		}
		else
			feedOld = feed;
		
		try
		{
			File file = new File(PATH+folderName); 
			if(!file.exists())
				file.mkdirs(); 

			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(feedOld);
			
			out.close();
			fileOut.close();
			System.out.println("\n Serialized data is saved in "+filePath);
		}catch(IOException i)
		{
			i.printStackTrace();
		}
		
		return feed;
	}
	
}
