package com.mycompany.BBScustom.service;

import com.mycompany.BBScustom.dto.BoardDto;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BoardContentService extends AbstractBoardService {

	@Override
	public void excute(Model model) {
		
		Map<String,Object> map= model.asMap();
		HttpServletRequest request=(HttpServletRequest)map.get("request");
		String idx=request.getParameter("idx");
		dao.upHit(idx);
		BoardDto dto = dao.contentView(idx);
		model.addAttribute("content_view",dto);
	}

}
