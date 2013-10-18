package com.rss.nimp;

import java.net.*;
import java.io.*;
import org.jdom.*;
import org.jdom.output.XMLOutputter;
import org.jdom.input.SAXBuilder;

public class Test {

  public final static String DEFAULT_SERVER = "http://www.lemonde.fr/rss/tag/afrique.xml";

  public static void main(String[] args) {

    String server = DEFAULT_SERVER;
    
    try {
      // Transmit the request document
      URL url = new URL("http://www.lemonde.fr/rss/tag/afrique.xml");
      URLConnection connection = url.openConnection();
      //InputStream is = connection.getInputStream(); // To download
      //OutputStream os = connection.getOutputStream(); // To upload

      // Read the response
      InputStream in = connection.getInputStream();
      SAXBuilder parser = new SAXBuilder();
      Document response = parser.build(in);
      //in.close();
      //connection.disconnect();

      // Walk down the tree
      String result = response.getRootElement()
                       .getChild("item")
                       .getChild("link")
                       .getText();
      System.out.println(result);
    }
    catch (Exception e) {
      System.err.println(e);
    }

  }

}
