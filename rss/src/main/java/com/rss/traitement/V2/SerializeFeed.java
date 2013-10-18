package com.rss.traitement.V2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;

public class SerializeFeed {
	static final String PATH = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/";
	private DeserializeFeed deserialize;
	String filePath;
	
	public void serialize(String name,List<FeedMessage> feed) {
		
		filePath = PATH+name+"/feed.ser";
		deserialize = new DeserializeFeed();
		if(deserialize.fileExists(filePath))
		{
			List<FeedMessage> feedOld = deserialize.deserialize(filePath);
			
			for (int i = 0; i > feedOld.size(); i++) {
				FeedMessage currentMessageOld = feedOld.get(i);
				String guidOld = currentMessageOld.getGuid();
				for (int j = 0; j < feed.size(); j++) {
					FeedMessage currentMessageNew = feed.get(j);
					String guidNew = currentMessageNew.getGuid();
					if(!guidOld.equals(guidNew))
					{
						feedOld.add(currentMessageNew);
					}
					System.out.println("i: "+i+" - j: "+j);
				}
			}
			System.out.println("serial. size: "+feedOld.size());
		}
		
		
		try
		{
			File file = new File(PATH+name); 
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
	
	public Boolean feedMessageExists(Feed feedNew, String file) {
		Feed feedOld = null;
		try
	      {
	         FileInputStream fileIn = new FileInputStream(file);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         feedOld = (Feed) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return false;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Feed class not found");
	         c.printStackTrace();
	         return false;
	      }
		
		for (FeedMessage messageNew : feedOld.getMessages()) {
			System.out.println(feedOld.getMessages().contains(messageNew));
		}
		
		return true;
	}

}
