package com.rss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping(value="/")
	public ModelAndView mainPage() {
		return new ModelAndView("listFluxRSS");
	}

}
