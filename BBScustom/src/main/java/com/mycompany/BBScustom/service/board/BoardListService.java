package com.mycompany.BBScustom.service.board;

import java.util.ArrayList;

import com.mycompany.BBScustom.dto.BoardDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardListService implements BoardService {
	
	@Override
	//@Transactional()
	public void excute(Model model) {
		ArrayList<BoardDto> dtos=BOARD_DAO.list();
		model.addAttribute("list",dtos);
	}

}
