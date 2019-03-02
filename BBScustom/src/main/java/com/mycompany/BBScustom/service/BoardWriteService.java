package com.mycompany.BBScustom.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

@Service
public class BoardWriteService extends AbstractBoardService {

	@Override
	public void excute(Model model) {
		Map<String,Object>map= model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		String bdname= request.getParameter("bdname");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		boardDao.write(bdname,title,content);
	}

}
