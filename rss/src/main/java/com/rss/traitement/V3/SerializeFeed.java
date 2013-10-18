package com.rss.traitement.V3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;
import com.rss.traitement.V3.DeserializeFeed;

public class SerializeFeed extends Thread{
	static final String PATH = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/";
	private DeserializeFeed deserialize;
	String filePath;
	
	String folderName;
	Feed feedToSerialize;
	Feed feedToSerializeTemp;
	
	public SerializeFeed(String folderName, Feed feed) {
		//this.folderName = folderName;
		filePath = PATH+folderName+"/feed.ser"; 
		feedToSerialize = feed;
		deserialize = new DeserializeFeed(filePath);
		this.start();
	}
	
	public synchronized void serialize() {
		while(deserialize.isAlive()){
			try {
				this.wait();
				System.out.println("wait");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try
		{
			File file = new File(PATH+folderName); 
			if(!file.exists())
				file.mkdirs(); 

			FileOutputStream fileOut = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			
			//out.writeObject(feedToSerialize);
			
			out.close();
			fileOut.close();
			System.out.println("\n Serialized data is saved in "+filePath);
		}catch(IOException i)
		{
			i.printStackTrace();
		}
	}
	
	public synchronized void serialize(String folderName,Feed feed) {
		
		filePath = PATH+folderName+"/feed.ser";
		//deserialize = new DeserializeFeed();
		
		//deserialize = new DeserializeFeed();
		if(deserialize.fileExists(filePath))
		{
			
			Feed feedOld = deserialize.deserialize(filePath);
			
			for (FeedMessage messageOld : feedOld.getMessages()) {
				System.out.println(messageOld);
				String guidOld = messageOld.getGuid();
				for (FeedMessage messageNew : feed.getMessages()) {
					System.out.println(messageNew);
					String guidNew = messageNew.getGuid();
					if(!guidOld.equals(guidNew))
					{
						//feed.getMessages().add(messageNew);
						System.out.println("old: "+guidOld);
						System.out.println("new: "+guidNew);
						System.err.println("nouveau msg ajouté");
						System.err.println(messageNew);
					}
					else
						System.err.println("aucun nouveau feed");
				}
			}
			System.out.println("fin double boucle");
			
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
	}
	
	public void run() {
		
		if(deserialize.fileExists(filePath))
		{
			
			Feed feedOld = deserialize.deserialize(filePath);
			feedToSerializeTemp = feedToSerialize;
			for (FeedMessage messageOld : feedOld.getMessages()) {
				System.out.println(messageOld);
				String guidOld = messageOld.getGuid();
				for (FeedMessage messageNew : feedToSerialize.getMessages()) {
					System.out.println(messageNew);
					String guidNew = messageNew.getGuid();
					if(!guidOld.equals(guidNew))
					{
						feedToSerializeTemp.getMessages().add(messageNew);
						System.out.println("old: "+guidOld);
						System.out.println("new: "+guidNew);
						System.err.println("nouveau msg ajouté");
						System.err.println(messageNew);
					}
					else
						System.err.println("aucun nouveau feed");
				}
			}
			feedToSerialize = feedToSerializeTemp;
			System.out.println("fin double boucle");
			
		}
		
		serialize();
	}
	
}
