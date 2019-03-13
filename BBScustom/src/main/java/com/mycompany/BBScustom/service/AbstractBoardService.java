package com.mycompany.BBScustom.service;

//import java.util.Map;

//import javax.servlet.http.HttpServletRequest;

//import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.mycompany.BBScustom.dao.BoardDao;

public abstract class AbstractBoardService{
	
	@Autowired
	private BoardDao boardDaoMapper;
	
	@SuppressWarnings("unused")
	@Autowired
	private BoardDao boardDaoImpl;
	
	public BoardDao getBoardDao() {
		return boardDaoMapper;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public abstract void excute(Model model);
	/*
	public void excute(Model model) {
		Map<String,Object>map= model.asMap();
		HttpServletRequest request =(HttpServletRequest) map.get("request");
		excute(request);
	}
	public abstract void excute(HttpServletRequest request);
	*/
}
