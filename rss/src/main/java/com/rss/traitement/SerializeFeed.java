package com.rss.traitement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;
import com.rss.traitement.DeserializeFeed;

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
			
			//Feed feedOld = deserialize.deserialize(filePath);
			feedOld = deserialize.deserialize(filePath);
			Feed feedTemp = feedOld;
			
			for (FeedMessage messageOld : feedOld.getMessages()) {
				//System.out.println(messageOld);
				String guidOld = messageOld.getGuid();
				for (FeedMessage messageNew : feed.getMessages()) {
					//System.out.println(messageNew);
					String guidNew = messageNew.getGuid();
					if(!guidOld.equals(guidNew))
					{
						//feed.getMessages().add(messageNew);
						//feedTemp.getMessages().add(messageNew);
						/*
						System.out.println("old: "+guidOld);
						System.out.println("new: "+guidNew);
						System.err.println("nouveau msg ajouté");
						System.err.println(messageNew);
						*/
					}
					else
						System.err.println("aucun nouveau feed");
				}
			}
			System.out.println("fin double boucle");
			//feed.getMessages().addAll(feedTemp.getMessages());
			
		}
		
		try
		{
			File file = new File(PATH+folderName); 
			if(!file.exists())
				file.mkdirs(); 

			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			//out.writeObject(feed);
			
			out.close();
			fileOut.close();
			System.out.println("\n Serialized data is saved in "+filePath);
		}catch(IOException i)
		{
			i.printStackTrace();
		}
		
		return feed;
	}
	
	public void getFeedMessage(String str){
		for(int i=0; i<feedOld.getMessages().size(); i++){
			FeedMessage currentMessage = feedOld.getMessages().get(i);
			if(currentMessage.getGuid().equals(str)){
				System.err.println("index: "+i);
				System.out.println(currentMessage);
			}
		}
	}
	
}
