package com.rss.nimp;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

public class ItemRSSCollecte implements Serializable{
	
	private static final long serialVersionUID = 5490974764542387151L;
	
	public int id;
	public URL urlSource;
	public URL urlSourceItem;
	public Date date;
	public String titre;
	public String description;
	public String resume;
	public String lang;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public URL getUrlSource() {
		return urlSource;
	}
	public void setUrlSource(URL urlSource) {
		this.urlSource = urlSource;
	}
	public URL getUrlSourceItem() {
		return urlSourceItem;
	}
	public void setUrlSourceItem(URL urlSourceItem) {
		this.urlSourceItem = urlSourceItem;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	
}
