package com.mycompany.BBScustom.service;

import org.springframework.ui.Model;

import com.mycompany.BBScustom.dao.BoardDao;
import com.mycompany.BBScustom.dto.BoardDto;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;


public class BoardContentService implements BoardService {

	@Override
	public void excute(Model model) {
		
		Map<String,Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String idx=request.getParameter("idx");
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.contentView(idx);
		model.addAttribute("content_view",dto);
	}

}
