package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import com.mycompany.BBScustom.dto.BoardDto;

public class BoardDao{
	
	DataSource dataSource;
	
	public BoardDao(){
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mydb");
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=null;
		Connection connection=null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet= null;
		try {
			connection = dataSource.getConnection();
			String query="SELECT idx, title, content, id, hit, bddate, bdgroup, step, indent FROM board";
			preparedStatement = connection.prepareStatement(query);
			resultSet =preparedStatement.executeQuery();
			/*
			while(resultSet.next()) {
				BoardDto dto= new BoardDto();
				dtos.add(dto);
			}*/
		}
		catch(SQLException sql){
	        System.out.println("SQLException: " + sql.getMessage());
	        System.out.println("SQLState: " + sql.getSQLState());
	        System.out.println("Erro: " + sql.getErrorCode());
	        System.out.println("StackTrace: " + sql.getStackTrace());
	    }
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet !=null)resultSet.close();
				if(preparedStatement !=null)preparedStatement.close();
				if(connection !=null)connection.close();
			}
			catch(Exception e2) {
			}
			
		}
		
				return dtos;
		
	}
}