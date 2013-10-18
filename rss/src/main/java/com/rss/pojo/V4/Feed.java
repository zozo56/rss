package com.rss.pojo.V4;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/*
 * Stores an RSS feed
 */
public class Feed implements Serializable{

  private static final long serialVersionUID = 1L;

  final String title;
  final String link;
  final String description;
  final String language;
  final String copyright;
  final String pubDate;

  final Map<String, FeedMessage> entries = new HashMap<String, FeedMessage>();

  public Feed(String title, String link, String description, String language,String copyright, String pubDate) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.language = language;
    this.copyright = copyright;
    this.pubDate = pubDate; 
  }

  public Map<String, FeedMessage> getMessages() {
    return entries; 
  }
  
  public void putMessage(String str, FeedMessage feedMessage) {
	  entries.put(str, feedMessage); 
  }
  
  public boolean containsKey(String key) {
	  return entries.containsKey(key);
  }
  
  public FeedMessage getMessage(String key) {
	  return entries.get(key);
  }

  public String getTitle() {
    return title;
  }

  public String getLink() {
    return link;
  }

  public String getDescription() {
    return description;
  }

  public String getLanguage() {
    return language;
  }

  public String getCopyright() {
    return copyright;
  }

  public String getPubDate() {
    return pubDate;
  }

  @Override
  public String toString() {
    return "Feed [copyright=" + copyright + ", description=" + description
        + ", language=" + language + ", link=" + link + ", pubDate="
        + pubDate + ", title=" + title + "]";
  }

}
