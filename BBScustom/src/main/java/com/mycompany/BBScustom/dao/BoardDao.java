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
	public BoardDto contentView(String idx) {
		//uphit(idx);
		BoardDto dto = null;
		Connection connection=null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet= null;
		try {
			connection = dataSource.getConnection();
			String query="SELECT * FROM board where idx=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1,Integer.parseInt(idx));
			resultSet =preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int idx2=resultSet.getInt("idx");
				String title=resultSet.getString("title");
				String content=resultSet.getString("content");
				String bdname=resultSet.getString("bdname");
				Timestamp bddate=resultSet.getTimestamp("bddate");
				int bdgroup=resultSet.getInt("bdgroup");
				int step=resultSet.getInt("step");
				int indent=resultSet.getInt("indent");
				int hit=resultSet.getInt("hit");
				dto= new BoardDto(idx2,title,content,bdname,bddate,bdgroup,step,indent,hit);
			}
		}
		catch(Exception e) {
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
		
		
		return dto;
	}
	
	public void write(String bdname,String title,String content) {
		Connection connection=null;
		PreparedStatement preparedStatement= null;
		try {
			connection = dataSource.getConnection();
			String query="insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,?,? from board;";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,title);
			preparedStatement.setString(2,content);
			preparedStatement.setString(3,bdname);
			preparedStatement.setInt(4,0);
			preparedStatement.setInt(5,0);			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(preparedStatement !=null)preparedStatement.close();
				if(connection !=null)connection.close();
			}
			catch(Exception e2) {
			}
			
		}
		
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		Connection connection=null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet= null;
		try {
			connection = dataSource.getConnection();
			String query="SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board";
			preparedStatement = connection.prepareStatement(query);
			resultSet =preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idx=resultSet.getInt("idx");
				String title=resultSet.getString("title");
				String content=resultSet.getString("content");
				String bdname=resultSet.getString("bdname");
				Timestamp bddate=resultSet.getTimestamp("bddate");
				int bdgroup=resultSet.getInt("bdgroup");
				int step=resultSet.getInt("step");
				int indent=resultSet.getInt("indent");
				int hit=resultSet.getInt("hit");
				BoardDto dto= new BoardDto(idx,title,content,bdname,bddate,bdgroup,step,indent,hit);
				dtos.add(dto);
			}
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