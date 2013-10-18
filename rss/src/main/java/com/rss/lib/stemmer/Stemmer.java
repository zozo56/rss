package com.rss.lib.stemmer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class Stemmer {

	public String lang;
	public String fileSource;
	public String fileDestination;
	
	
	
	public Stemmer(String lang, String fileSource, String fileDestination) {
		this.lang = lang;
		this.fileSource = fileSource;
		this.fileDestination = fileDestination;
	}
	
	//public void stem(String lang, String fileSource, String fileDestination) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

	public void stem() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {

		Class stemClass = Class.forName("com.rss.lib.stemmer." + lang + "Stemmer");
		SnowballStemmer stemmer = (SnowballStemmer) stemClass.newInstance();

		Reader reader;
		reader = new InputStreamReader(new FileInputStream(fileSource));
		reader = new BufferedReader(reader);

		StringBuffer input = new StringBuffer();

		OutputStream outstream;

		//outstream = new FileOutputStream(fileDestination);
		outstream = System.out;
		
		Writer output = new OutputStreamWriter(outstream);
		output = new BufferedWriter(output);

		int repeat = 1;

		//Object [] emptyArgs = new Object[0];
		int character;
		while ((character = reader.read()) != -1) {
			char ch = (char) character;
			if (Character.isWhitespace((char) ch)) {
				if (input.length() > 0) {
					stemmer.setCurrent(input.toString());
					//String[] tabStr = input.toString().split(",");
					//System.err.println(tabStr[0]);
					//System.err.println(tabStr[1]);
					for (int i = repeat; i != 0; i--) {
						stemmer.stem();
					}
					output.write(stemmer.getCurrent());
					output.write('\n');
					input.delete(0, input.length());
				}
			} else {
				input.append(Character.toLowerCase(ch));
			}
		}
		
		output.flush();
		output.close();
		reader.close();
		outstream.close();
		
	}
	
	public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		Stemmer stem = new Stemmer("french", "/Users/jb/Documents/workspaceJ2EE/rss/src/main/resources/une/feed.ser", "");
		stem.stem();
		
	}
}
