package com.mycompany.BBScustom.dao;

import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;

public interface IBoardDao{
	
	public BoardDto contentView(String idx);
	
	public ArrayList<BoardDto> list();
	
	public void write(String bdname,String title,String content);
	
	public void modify(String idx,String bdname,String title,String content);
	
	public void delete(String idx);
	
	public void upHit(String idx);

}