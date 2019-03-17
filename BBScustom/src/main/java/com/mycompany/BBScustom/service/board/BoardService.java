package com.mycompany.BBScustom.service.board;

import javax.annotation.Resource;
import com.mycompany.BBScustom.dao.BoardDao;
import com.mycompany.BBScustom.service.Service;

import lombok.Getter;

public abstract class BoardService implements Service{
	
	@Resource(name="boardDaoMapper")
	@Getter
	private BoardDao boardDao;
}
