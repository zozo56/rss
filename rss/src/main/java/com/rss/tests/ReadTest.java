package com.rss.tests;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;
import com.rss.traitement.DeserializeFeed;
import com.rss.traitement.RSSFeedParser;
import com.rss.traitement.SerializeFeed;

public class ReadTest {
  public static void main(String[] args) {
	
	SerializeFeed serialize = new SerializeFeed();
    
    Feed news = parse("http://rss.lemonde.fr/c/205/f/3050/index.rss");
    serialize.serialize("news",news);
    
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
    //DeserializeFeed deserialize = new DeserializeFeed();
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
