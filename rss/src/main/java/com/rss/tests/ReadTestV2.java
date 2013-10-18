package com.rss.tests;

import java.util.ArrayList;
import java.util.List;

import com.rss.traitement.V2.DeserializeFeed;
import com.rss.traitement.V2.RSSFeedParser;
import com.rss.traitement.V2.SerializeFeed;

import com.rss.pojo.Feed;
import com.rss.pojo.FeedMessage;

public class ReadTestV2 {
  public static void main(String[] args) {
    SerializeFeed serialize = new SerializeFeed();
	
    List<FeedMessage> news = parse("http://rss.lemonde.fr/c/205/f/3050/index.rss");
    serialize.serialize("news_V2",news);
    
    List<FeedMessage> africa = parse("http://www.lemonde.fr/rss/tag/afrique.xml");
    serialize.serialize("africa_V2",africa);
    
    List<FeedMessage> emploi = parse("http://www.lemonde.fr/rss/tag/emploi.xml");
    serialize.serialize("job_V2",emploi);
    
    List<FeedMessage> techno = parse("http://rss.lemonde.fr/c/205/f/3061/index.rss");
    serialize.serialize("technology_V2",techno);
    
    List<FeedMessage> eco = parse("http://rss.lemonde.fr/c/205/f/3055/index.rss");
    serialize.serialize("economy_V2",eco);
    
    DeserializeFeed deserialize = new DeserializeFeed();
    //deserialize.deserialize("/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/news/feed.ser");
    
  }
  
  public static List<FeedMessage> parse(String url){
	  RSSFeedParser parser = new RSSFeedParser(url);
	  List<FeedMessage> entries =  parser.readFeed();
	  
	  System.out.println("******************** parse **********************");
	  System.out.println("size: "+entries.size());
	  for (int i = 0; i < entries.size(); i++) {
		  FeedMessage currentFeedMessage = entries.get(i);
		  System.out.println(currentFeedMessage);
	  }
	  
	  System.out.println("******************** / parse **********************");
	 
	  return entries;
  }
} 
