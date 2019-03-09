package com.mycompany.BBScustom.dao;

import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;

public interface BoardDao extends Dao{
	
	public BoardDto contentView(String idx);
	
	public BoardDto replyView(String idx);
	
	public ArrayList<BoardDto> list();
	
	public void write(String bdname,String title,String content);
	
	public void modify(String idx,String bdname,String title,String content);
	
	public void delete(String idx);
	
	public void reply(String bdname,String title,String content,String bdgroup, String step, String indent);
	
	public void replyShape(String bdgroup,String step);
	
	public void upHit(String idx);

}