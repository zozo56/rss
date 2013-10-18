package com.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rss.traitement.V4.DeserializeAllFeeds;
import com.rss.traitement.V4.ReadAllFeeds;

@Controller
public class RSSControllerSerializer {
	
	@RequestMapping(value="/list")
	public ModelAndView listFluxRSS() {
		ModelAndView modelAndView = new ModelAndView("listFluxRSS");
		
		ReadAllFeeds.read();
		
		modelAndView.addObject("allFeeds", ReadAllFeeds.getAllFeeds());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/une")
	public ModelAndView une() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getUne());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/afrique")
	public ModelAndView afrique() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getAfrique());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/emploi")
	public ModelAndView emploi() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEmploi());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/technologie")
	public ModelAndView technologie() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getTechnologie());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/economie")
	public ModelAndView economie() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEconomie());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/news")
	public ModelAndView news() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getNews());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/africa")
	public ModelAndView africa() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getAfrica());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/economic")
	public ModelAndView economic() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEconomics());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/technology")
	public ModelAndView technology() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getTechnology());
		
		return modelAndView;
	}
	
}
