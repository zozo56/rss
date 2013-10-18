package com.rss.nimp;

//	ROME example adapted from ROM tutorial by pfm, sept. 2012
//  CLASS RSSICrawler : a very simple RSS Reader to start with
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import org.apache.tika.Tika;
import org.apache.tomcat.util.http.fileupload.FileUtils;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
	      
	public class _RSSICollector {
	    	private static String path = "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/";
	    	static Hashtable<String, String> hashTable;
	    	
	    	public static void feedHashTable(String item, String url){
	    		hashTable = new Hashtable<String, String>();
	    		hashTable.put(item, url);
	    	}
	    	
	    	public static String createFolder(String name){
	    		File file = new File(path+name); 
	    		file.mkdirs(); 
	    		return path+name+"/";
	    	}
	    	
	    	public static void createFile(String path, String name, String content) throws IOException{
	    		File file = new File(path+name); 
	    		file.createNewFile();
	    		
    			BufferedWriter writer = new BufferedWriter( new FileWriter(path+name));
    		    writer.write(content);
    		    writer.close();
	    	}
	    	
	        public static void main(String[] args) throws Exception {
	        	
	        	// TEST some RSS url
	        	//URL url = new URL("http://www.rottentomatoes.com/syndication/rss/in_theaters.xml"); // RSS feed
	        	//URL url = new URL("http://feeds.feedburner.com/manishchhabra27");  // blog
	        	URL url = new URL("http://www.lemonde.fr/rss/tag/afrique.xml");
	        	

	        	  if (args.length > 0) {
	        		    try {
	        		      url = new URL(args[0]);
	        		    } catch(Exception ex) { 
	        		    ex.printStackTrace(); 
	        		    } 
	        		  } // end if (args...
	        	  // proxy management required when accessing the web from the UBS : 
	        	  // For campus of Vannes use the following specs:
	        	  //System.setProperty("http.proxySet", "true");
	        	  //System.setProperty("http.proxyHost", "squidva.univ-ubs.fr");
	        	  //System.setProperty("http.proxyPort", "3128");
	        	  //System.setProperty("http.proxyType", "4");

	            // Connecting to the RSS url
	            HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();  
	            
	            // Reading the feed  
	            SyndFeedInput input = new SyndFeedInput();  
	            SyndFeed feed = input.build(new XmlReader(httpcon));  
	            List<SyndFeed> entries = feed.getEntries();  
	            Iterator<SyndFeed> itEntries = entries.iterator(); 
	            
	            String chemin = createFolder("afrique");
	            
	            // Parsing the feed
	            String st;
	            int i = 0;
	            String contentItem;
	            String currentItem;
	            while (itEntries.hasNext()) {  
	                SyndEntry entry = (SyndEntry) itEntries.next();  
	                
		    		/*
		    		st=entry.getTitle().replaceAll("\\n", "").replaceAll("\\t", "");
	                System.out.println("Title: " + st);  
	                System.out.println("Link: " + entry.getLink());
	                System.out.println("Author: " + entry.getAuthor());  
	                System.out.println("Publish Date: " + entry.getPublishedDate()); 
	                if(entry.getDescription()!=null)
	                	System.out.println("Description: " + entry.getDescription().getValue());        
	                System.out.println();  
	                */
	                System.out.println("teste: " + entry);
	                System.out.println("PublishedDate: " + entry.getPublishedDate());
	                
	                Tika tika = new Tika();
	                
	                currentItem = "item"+i+".txt";
	                contentItem = tika.parseToString(new URL(entry.getLink()));
	                
	                //creation d'un fichier item avec son contenu
	                //createFile(chemin, currentItem, contentItem);
	                
	                //mapping item et son url
	                //feedHashTable(currentItem, entry.getLink());
	                
	                //System.out.println(i);
	                i++;
	            }  
	        }  
	    }  
	
