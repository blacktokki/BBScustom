package com.mycompany.BBScustom.controller;


import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.mycompany.BBScustom.service.Service;

@Controller
public class BoardController {
	
	@Resource(name="boardServiceMap")
	private Map<String,Service> boardServiceMap;
	
	public void excuteService(String name,Model model) {
		boardServiceMap.get(name).excute(model);
	}
	
	public void excuteService(String name,Model model,HttpServletRequest request) {
		excuteService(name,model.addAttribute("request",request));
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		excuteService("List",model);
		return  "list";
	}
	
	@RequestMapping(value = "/write_view")
	public String write_view(Model model) {
		return  "write_view";
	}
	
	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(HttpServletRequest request,Model model) {
		excuteService("Write",model,request);
		return  "redirect:list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		excuteService("Content",model,request);
		return  "content_view";
	}
	
	@RequestMapping(value = "/modify",method=RequestMethod.POST)
	public String modify(HttpServletRequest request,Model model) {
		excuteService("Modify",model,request);
		return  "redirect:list";
	}
	
	@RequestMapping(value = "/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		excuteService("ReplyView",model,request);
		return "reply_view";
	}

	@RequestMapping(value = "/reply",method=RequestMethod.POST)
	public String reply(HttpServletRequest request,Model model) {
		excuteService("Reply",model,request);
		return  "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,Model model) {
		excuteService("Delete",model,request);
		return  "redirect:list";
	}
	/*
	@RequestMapping(value = "/content_view/**")
	public String content_view_redirect(HttpServletRequest request) {
		String idx=request.getParameter("idx");
		try { 
	        Integer.parseInt(idx); 
	    } catch(Exception e) { 
	    	return "redirect:/";
	    }
		return  "redirect:/content_view?idx="+idx;
	}
	
	@RequestMapping(value = "/reply_view/**")
	public String reply_view_redirect(HttpServletRequest request) {
		String idx=request.getParameter("idx");
		try { 
	        Integer.parseInt(idx); 
	    } catch(Exception e) { 
	    	return "redirect:/";
	    }
		return  "redirect:/reply_view?idx="+idx;
			
	}*/
}
