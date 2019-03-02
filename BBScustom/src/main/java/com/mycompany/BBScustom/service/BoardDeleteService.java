package com.mycompany.BBScustom.service;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

@Service
public class BoardDeleteService extends AbstractBoardService {

	@Override
	public void excute(Model model) {
		Map<String,Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String idx=request.getParameter("idx");
		boardDao.delete(idx);

	}

}
