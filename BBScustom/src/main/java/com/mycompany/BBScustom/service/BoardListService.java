package com.mycompany.BBScustom.service;

import java.util.ArrayList;

import com.mycompany.BBScustom.dto.BoardDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Service;

@Service
public class BoardListService extends AbstractBoardService {
	
	@Override
	public void excute(Model model) {
		ArrayList<BoardDto> dtos=boardDao.list();
		model.addAttribute("list",dtos);
	}

}
