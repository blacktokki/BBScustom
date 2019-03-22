package com.mycompany.BBScustom.service.board;

import com.mycompany.BBScustom.service.Service;
import com.mycompany.BBScustom.dao.BoardDao;
import com.mycompany.BBScustom.util.Constant;

public interface BoardService extends Service{
	BoardDao BOARD_DAO=(BoardDao) Constant.getDaoMap().get("BoardMapper");
}
