package com.mycompany.BBScustom.service.board;

import java.util.ArrayList;

import com.mycompany.BBScustom.dto.BoardDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardListService extends BoardService {
	
	@Override
	//@Transactional()
	public void excute(Model model) {
		ArrayList<BoardDto> dtos=getBoardDao().list();
		model.addAttribute("list",dtos);
	}

}
