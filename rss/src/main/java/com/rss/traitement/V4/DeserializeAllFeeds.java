package com.rss.traitement.V4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.rss.pojo.V4.Feed;
import com.rss.pojo.V4.FeedMessage;
import com.rss.traitement.V4.DeserializeFeed;
import com.rss.traitement.V4.RSSFeedParser;
import com.rss.traitement.V4.SerializeFeed;

public class DeserializeAllFeeds {

	public static Feed une;
	public static Feed afrique;
	public static Feed emploi;
	public static Feed technologie;
	public static Feed economie;

	public static Feed news;
	public static Feed africa;
	public static Feed economics;
	public static Feed technology;
	
	public static String UNE = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/une/feed.ser";
	public static String AFRIQUE = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/afrique/feed.ser";
	public static String EMPLOI = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/emploi/feed.ser";
	public static String TECHNOLOGIE = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/technologie/feed.ser";
	public static String ECONOMIE = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/economie/feed.ser";
	
	public static String NEWS = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/news/feed.ser";
	public static String AFRICA = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/africa/feed.ser";
	public static String ECONOMICS = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/economics/feed.ser";
	public static String TECHNOLOGY = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/technology/feed.ser";
	 
	public static List<Feed> allFeeds = new ArrayList<Feed>();

	public static Feed getUne() {
		return une;
	}

	public static void setUne(Feed une) {
		DeserializeAllFeeds.une = une;
	}

	public static Feed getAfrique() {
		return afrique;
	}

	public static void setAfrique(Feed afrique) {
		DeserializeAllFeeds.afrique = afrique;
	}

	public static Feed getEmploi() {
		return emploi;
	}

	public static void setEmploi(Feed emploi) {
		DeserializeAllFeeds.emploi = emploi;
	}

	public static Feed getTechnologie() {
		return technologie;
	}

	public static void setTechnologie(Feed technologie) {
		DeserializeAllFeeds.technologie = technologie;
	}

	public static Feed getEconomie() {
		return economie;
	}

	public static void setEconomie(Feed economie) {
		DeserializeAllFeeds.economie = economie;
	}

	public static Feed getNews() {
		return news;
	}

	public static void setNews(Feed news) {
		DeserializeAllFeeds.news = news;
	}

	public static Feed getAfrica() {
		return africa;
	}

	public static void setAfrica(Feed africa) {
		DeserializeAllFeeds.africa = africa;
	}

	public static Feed getEconomics() {
		return economics;
	}

	public static void setEconomics(Feed economics) {
		DeserializeAllFeeds.economics = economics;
	}

	public static Feed getTechnology() {
		return technology;
	}

	public static void setTechnology(Feed technology) {
		DeserializeAllFeeds.technology = technology;
	}

	public static List<Feed> getAllFeeds() {
		return allFeeds;
	}

	public static void setAllFeeds(List<Feed> allFeeds) {
		DeserializeAllFeeds.allFeeds = allFeeds;
	}

	public static void get() {

		DeserializeFeed deserialize = new DeserializeFeed();
		
		une = deserialize.deserialize(UNE);
		allFeeds.add(une);
		
		afrique = deserialize.deserialize(AFRIQUE);
		allFeeds.add(afrique);
		
		emploi = deserialize.deserialize(EMPLOI);
		allFeeds.add(emploi);
		
		technologie = deserialize.deserialize(TECHNOLOGIE);
		allFeeds.add(technologie);
		
		economie = deserialize.deserialize(ECONOMIE);
		allFeeds.add(economie);
		
		//EN
		news = deserialize.deserialize(NEWS);
		allFeeds.add(news);
		
		africa = deserialize.deserialize(AFRICA);
		allFeeds.add(africa);
		
		economics = deserialize.deserialize(ECONOMICS);
		allFeeds.add(economics);
		
		technology = deserialize.deserialize(TECHNOLOGY);
		allFeeds.add(technology);

	}

} 
