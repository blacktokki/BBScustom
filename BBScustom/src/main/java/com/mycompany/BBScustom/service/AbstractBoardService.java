package com.mycompany.BBScustom.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.mycompany.BBScustom.dao.BoardDao;

@Service
public abstract class AbstractBoardService {
	
	protected static BoardDao dao=new BoardDao();
	
	public abstract void excute(Model model);
}
