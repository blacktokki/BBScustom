package com.mycompany.BBScustom.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.mycompany.BBScustom.dao.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public void excute(Model model) {
		Map<String,Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String idx=request.getParameter("idx");
		BoardDao dao = new BoardDao();
		dao.delete(idx);

	}

}
