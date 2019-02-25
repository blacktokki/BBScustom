package com.mycompany.BBScustom.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.mycompany.BBScustom.dao.BoardDao;

public class BoardWriteService implements BoardService {

	@Override
	public void excute(Model model) {
		Map<String,Object>map= model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		String bdname= request.getParameter("bdname");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		BoardDao dao=new BoardDao();
		dao.write(bdname,title,content);
	}

}
