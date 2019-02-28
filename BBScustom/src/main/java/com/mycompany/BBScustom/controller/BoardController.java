package com.mycompany.BBScustom.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.BBScustom.service.*;
/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	BoardService service;
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
			logger.info("list()");
			service=new BoardListService();
			service.excute(model);
			return  "list";
	}
	
	@RequestMapping(value = "/write_view")
	public String write_view(Model model) {
			logger.info("write_view()");
			return  "write_view";
	}
	
	@RequestMapping(value = "/write",method=RequestMethod.POST)
	public String write(HttpServletRequest request,Model model) {
			logger.info("write()");
			model.addAttribute("request",request);
			service=new BoardWriteService();
			service.excute(model);
			return  "redirect:list";
	}
	
	@RequestMapping(value = "/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		logger.info("content_view()");
		model.addAttribute("request",request);
		service=new BoardContentService();
		service.excute(model);
		return  "content_view";
	}
	
	@RequestMapping(value = "/modify",method=RequestMethod.POST)
	public String modify(HttpServletRequest request,Model model) {
		logger.info("modify()");
		model.addAttribute("request",request);
		service=new BoardModifyService();
		service.excute(model);
		return  "redirect:list";
	}
	
	@RequestMapping(value = "/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		logger.info("reply_view()");
		model.addAttribute("request",request);
		service=new BoardReplyViewService();
		service.excute(model);
		return "reply_view";
	}

	@RequestMapping(value = "/reply",method=RequestMethod.POST)
	public String reply(HttpServletRequest request,Model model) {
		logger.info("reply()");
		model.addAttribute("request",request);
		service=new BoardReplyService();
		service.excute(model);
		return  "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request,Model model) {
		logger.info("delete()");
		model.addAttribute("request",request);
		service=new BoardDeleteService();
		service.excute(model);
		return  "redirect:list";
	}
}
