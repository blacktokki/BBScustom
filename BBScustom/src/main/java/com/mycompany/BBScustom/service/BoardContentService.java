package com.mycompany.BBScustom.service;

import org.springframework.ui.Model;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class BoardContentService implements BoardService {

	@Override
	public void excute(Model model) {
		
		Map<String,Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String id=request.getParameter("id");
		
	}

}
