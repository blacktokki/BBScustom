package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;
import javax.sql.DataSource;

import com.mycompany.BBScustom.dto.BoardDto;

public class BoardDao{
	
	private DataSource dataSource;
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public BoardDao(){
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup("java:comp/env/jdbc/mydb");
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	private PreparedStatement connect(String query) throws SQLException{
		connection = dataSource.getConnection();
		return connection.prepareStatement(query);
	}
	
	private void disconnect() {
		try {
			if(resultSet !=null)resultSet.close();
			if(preparedStatement !=null)preparedStatement.close();
			if(connection !=null)connection.close();
		}
		catch(Exception e) {
		}
	}

	public BoardDto contentView(String idx) {
		upHit(idx);
		BoardDto  dto= new BoardDto();
		try {
			preparedStatement=connect("SELECT * FROM board where idx=?");
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
			disconnect();
		}
		
		return dto;
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		try {
			preparedStatement=connect("SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board");
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
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			disconnect();
		}
		return dtos;
	}
	
	public void write(String bdname,String title,String content) {
		try {
			preparedStatement=connect("insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,?,? from board;");
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
			disconnect();
		}
		
	}
	
	private void upHit(String idx) {
		
	}
}