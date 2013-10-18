package com.rss.nimp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.tika.Tika;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class RSSICollector {
	
	private String categorie;

	public String getCategorie() {
		return categorie;
	}

	public List<SyndFeed> getRSS(URL url1){
		URL url = null;
		try {
			url = new URL("http://www.lemonde.fr/rss/tag/afrique.xml");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		// Connecting to the RSS url
		HttpURLConnection httpcon = null;
		try {
			httpcon = (HttpURLConnection)url.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	  
		// Reading the feed  
		SyndFeedInput input = new SyndFeedInput();  
		SyndFeed feed = null;
		try {
			feed = input.build(new XmlReader(httpcon));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FeedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		List<SyndFeed> entries = feed.getEntries();  
		categorie = feed.getTitle();
		
		
		return entries;
	}
}
