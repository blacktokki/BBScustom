package com.mycompany.BBScustom.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */	
	@RequestMapping(value = "/")
	public String home(Model model,Locale locale)
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	/*
	@RequestMapping(value = {"/{val:[^(resources)].*}/**","/*"},method = RequestMethod.GET)
	public String redirect(HttpServletRequest request, Model model)
	{
		String str=request.getRequestURI();
		String str2=str.replaceFirst(request.getContextPath(),"");
		str2=str2.substring(0,str2.lastIndexOf("/"));
		logger.info("redirect:{} >>> {}",str, str2);
		
		return "redirect:"+str2;
	}*/
}
