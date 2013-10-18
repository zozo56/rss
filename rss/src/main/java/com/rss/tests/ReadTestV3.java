package com.rss.tests;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;
import com.rss.traitement.V3.DeserializeFeed;
import com.rss.traitement.V3.RSSFeedParser;
import com.rss.traitement.V3.SerializeFeed;

public class ReadTestV3 {
  public static void main(String[] args) {
	  
	Feed news = parse("http://rss.lemonde.fr/c/205/f/3050/index.rss");
    SerializeFeed serialize = new SerializeFeed("news",news);
    serialize.serialize();
    
    /*
    Feed africa = parse("http://www.lemonde.fr/rss/tag/afrique.xml");
    serialize.serialize("africa",africa);
    
    Feed emploi = parse("http://www.lemonde.fr/rss/tag/emploi.xml");
    serialize.serialize("job",emploi);
    
    Feed techno = parse("http://rss.lemonde.fr/c/205/f/3061/index.rss");
    serialize.serialize("technology",techno);
    
    Feed eco = parse("http://rss.lemonde.fr/c/205/f/3055/index.rss");
    serialize.serialize("economy",eco);
    */
    //DeserializeFeed deserialize = new DeserializeFeed("/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/news/feed.ser");
    //deserialize.deserialize();
    //deserialize.deserialize("/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/news/feed.ser");
    
  }
  
  public static Feed parse(String url){
	  RSSFeedParser parser = new RSSFeedParser(url);
	  Feed feed =  parser.readFeed();
	  System.out.println("******************** parse **********************");
	  /*
	  System.out.println("******************** parse **********************");
	  System.out.println("size: "+feed.getMessages().size());
	  
	  for (FeedMessage message : feed.getMessages()) {
		  System.out.println(message);
	  }
	  
	  System.out.println("******************** / parse **********************");
	 */
	  return feed;
  }
} 
