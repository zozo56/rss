package com.rss.traitement.V4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.rss.pojo.V4.Feed;
import com.rss.pojo.V4.FeedMessage;
import com.rss.traitement.V4.DeserializeFeed;
import com.rss.traitement.V4.RSSFeedParser;
import com.rss.traitement.V4.SerializeFeed;

public class ReadAllFeeds {

	public static Feed une;
	public static Feed afrique;
	public static Feed emploi;
	public static Feed technologie;
	public static Feed economie;

	public static Feed news;
	public static Feed africa;
	public static Feed economics;
	public static Feed technology;
	 
	public static List<Feed> allFeeds = new ArrayList<Feed>();

	public static Feed getUne() {
		return une;
	}

	public static void setUne(Feed une) {
		ReadAllFeeds.une = une;
	}

	public static Feed getAfrique() {
		return afrique;
	}

	public static void setAfrique(Feed afrique) {
		ReadAllFeeds.afrique = afrique;
	}

	public static Feed getEmploi() {
		return emploi;
	}

	public static void setEmploi(Feed emploi) {
		ReadAllFeeds.emploi = emploi;
	}

	public static Feed getTechnologie() {
		return technologie;
	}

	public static void setTechnologie(Feed technologie) {
		ReadAllFeeds.technologie = technologie;
	}

	public static Feed getEconomie() {
		return economie;
	}

	public static void setEconomie(Feed economie) {
		ReadAllFeeds.economie = economie;
	}

	public static Feed getNews() {
		return news;
	}

	public static void setNews(Feed news) {
		ReadAllFeeds.news = news;
	}

	public static Feed getAfrica() {
		return africa;
	}

	public static void setAfrica(Feed africa) {
		ReadAllFeeds.africa = africa;
	}

	public static Feed getEconomics() {
		return economics;
	}

	public static void setEconomics(Feed economics) {
		ReadAllFeeds.economics = economics;
	}

	public static Feed getTechnology() {
		return technology;
	}

	public static void setTechnology(Feed technology) {
		ReadAllFeeds.technology = technology;
	}

	public static List<Feed> getAllFeeds() {
		return allFeeds;
	}

	public static void setAllFeeds(List<Feed> allFeeds) {
		ReadAllFeeds.allFeeds = allFeeds;
	}

	public static void read() {

		SerializeFeed serialize = new SerializeFeed();

		une = parse("http://rss.lemonde.fr/c/205/f/3050/index.rss");
		serialize.serialize("une",une);
		allFeeds.add(une);

		afrique = parse("http://www.lemonde.fr/rss/tag/afrique.xml");
		serialize.serialize("afrique",afrique);
		allFeeds.add(afrique);

		emploi = parse("http://www.lemonde.fr/rss/tag/emploi.xml");
		serialize.serialize("emploi",emploi);
		allFeeds.add(emploi);

		technologie = parse("http://rss.lemonde.fr/c/205/f/3061/index.rss");
		serialize.serialize("technologie",technologie);
		allFeeds.add(technologie);

		economie = parse("http://rss.lemonde.fr/c/205/f/3055/index.rss");
		serialize.serialize("economie",economie);
		allFeeds.add(economie);

		/////EN
		news = parse("http://www.thetimes.co.uk/tto/news/rss");
		serialize.serialize("news",news);
		allFeeds.add(news);

		africa = parse("http://www.thetimes.co.uk/tto/news/world/africa/rss");
		serialize.serialize("africa",africa);
		allFeeds.add(africa);

		economics = parse("http://www.thetimes.co.uk/tto/business/economics/rss");
		serialize.serialize("economics",economics);
		allFeeds.add(economics);

		technology = parse("http://www.thetimes.co.uk/tto/technology/rss");
		serialize.serialize("technology",technology);
		allFeeds.add(technology);


		DeserializeFeed deserialize = new DeserializeFeed();
		//deserialize.deserialize("/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/une/feed.ser");

	}

	public static Feed parse(String url){
		RSSFeedParser parser = new RSSFeedParser(url);
		Feed feed =  parser.readFeed();
		System.out.println("******************** parse **********************");
		System.out.println("size: "+feed.getMessages().size());
		System.out.println("Title: "+feed.getTitle());

		for (Entry<String, FeedMessage> message : feed.getMessages().entrySet()) {
			//System.out.println(message.getValue());
		}

		System.out.println("******************** / parse **********************");

		return feed;
	}
} 
