package com.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rss.traitement.V4.DeserializeAllFeeds;
import com.rss.traitement.V4.ReadAllFeeds;

@Controller
public class RSSControllerDeserializer {
	
	@RequestMapping(value="/listDes")
	public ModelAndView listFluxRSSDes() {
		ModelAndView modelAndView = new ModelAndView("listFluxRSS");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("allFeeds", DeserializeAllFeeds.getAllFeeds());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/uneDes")
	public ModelAndView uneDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getUne());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/afriqueDes")
	public ModelAndView afriqueDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getAfrique());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/emploiDes")
	public ModelAndView emploiDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEmploi());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/technologieDes")
	public ModelAndView technologieDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getTechnologie());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/economieDes")
	public ModelAndView economieDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEconomie());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/newsDes")
	public ModelAndView newsDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getNews());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/africaDes")
	public ModelAndView africaDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getAfrica());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/economicDes")
	public ModelAndView economicDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getEconomics());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/technologyDes")
	public ModelAndView technologyDes() {
		ModelAndView modelAndView = new ModelAndView("feed");
		
		DeserializeAllFeeds.get();
		modelAndView.addObject("feed", DeserializeAllFeeds.getTechnology());
		
		return modelAndView;
	}
}
