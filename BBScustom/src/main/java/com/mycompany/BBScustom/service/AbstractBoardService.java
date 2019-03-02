package com.mycompany.BBScustom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.mycompany.BBScustom.dao.BoardDao;

@Service
public abstract class AbstractBoardService {
	
	protected static BoardDao boardDao;
	
	@Autowired
	public void setBoardDao(BoardDao boardDao) {
		AbstractBoardService.boardDao = boardDao;
	}
	
	public abstract void excute(Model model);
}
