package com.mycompany.BBScustom.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

@Service
public class BoardReplyService extends AbstractBoardService {

	@Override
	public void excute(Model model) {
		Map<String,Object>map= model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		String idx= request.getParameter("idx");
		String bdname= request.getParameter("bdname");
		String title= request.getParameter("title");
		String content= request.getParameter("content");
		String bdgroup= request.getParameter("bdgroup");
		String step= request.getParameter("step");
		String indent= request.getParameter("indent");
		dao.replyShape(bdgroup,step);
		dao.reply(idx,bdname,title,content,bdgroup,step,indent);

	}

}
