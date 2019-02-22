package com.mycompany.BBScustom.service;

import org.springframework.ui.Model;
import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;
import com.mycompany.BBScustom.dao.BoardDao;


public class BoardListService implements BoardService {

	@Override
	public void excute(Model model) {
		BoardDao dao=new BoardDao();
		ArrayList<BoardDto> dtos=dao.list();
		model.addAttribute("list",dtos);
	}

}
