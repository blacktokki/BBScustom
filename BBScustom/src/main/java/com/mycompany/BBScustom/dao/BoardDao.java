package com.mycompany.BBScustom.dao;

import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import com.mycompany.BBScustom.dto.BoardDto;

public class BoardDao {
	
	DataSource dataSource;
	
	public BoardDao(){
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup("");
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=null;
		
		return dtos;
		
	}
}