package com.rss.tests;

import java.util.Map.Entry;

import com.rss.pojo.V4.Feed;
import com.rss.pojo.V4.FeedMessage;
import com.rss.traitement.V4.DeserializeFeed;
import com.rss.traitement.V4.RSSFeedParser;
import com.rss.traitement.V4.SerializeFeed;

public class ReadTestV4 {
  public static void main(String[] args) {
	
	SerializeFeed serialize = new SerializeFeed();
    
    Feed une = parse("http://rss.lemonde.fr/c/205/f/3050/index.rss");
    serialize.serialize("une",une);
    
    Feed afrique = parse("http://www.lemonde.fr/rss/tag/afrique.xml");
    serialize.serialize("afrique",afrique);
    
    Feed emploi = parse("http://www.lemonde.fr/rss/tag/emploi.xml");
    serialize.serialize("emploi",emploi);
    
    Feed technologie = parse("http://rss.lemonde.fr/c/205/f/3061/index.rss");
    serialize.serialize("technologie",technologie);
    
    Feed economie = parse("http://rss.lemonde.fr/c/205/f/3055/index.rss");
    serialize.serialize("economie",economie);
    
    /////EN
    Feed news = parse("http://www.thetimes.co.uk/tto/news/rss");
    serialize.serialize("news",news);
    
    Feed africa = parse("http://www.thetimes.co.uk/tto/news/world/africa/rss");
    serialize.serialize("africa",africa);
    
    Feed economics = parse("http://www.thetimes.co.uk/tto/business/economics/rss");
    serialize.serialize("economics",economics);
    
    Feed technology = parse("http://www.thetimes.co.uk/tto/technology/rss");
    serialize.serialize("technology",technology);
    
    
    DeserializeFeed deserialize = new DeserializeFeed();
    //deserialize.deserialize("/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/une/feed.ser");
    
  }
  
  public static Feed parse(String url){
	  RSSFeedParser parser = new RSSFeedParser(url);
	  Feed feed =  parser.readFeed();
	  System.out.println("******************** parse **********************");
	  System.out.println("size: "+feed.getMessages().size());
	  
	  for (Entry<String, FeedMessage> message : feed.getMessages().entrySet()) {
	    	//System.out.println(message.getValue());
  	  }
	  
	  System.out.println("******************** / parse **********************");
	 
	  return feed;
  }
} 
