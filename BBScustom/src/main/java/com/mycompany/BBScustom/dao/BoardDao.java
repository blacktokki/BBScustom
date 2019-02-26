package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;

import com.mycompany.BBScustom.dto.BoardDto;

public class BoardDao extends AbstractDao{
	
	public BoardDao(){
		bindName("java:comp/env/jdbc/mydb");
	}
	
	private BoardDto createBoardDto() throws SQLException{
		int idx=resultSet.getInt("idx");
		String title=resultSet.getString("title");
		String content=resultSet.getString("content");
		String bdname=resultSet.getString("bdname");
		Timestamp bddate=resultSet.getTimestamp("bddate");
		int bdgroup=resultSet.getInt("bdgroup");
		int step=resultSet.getInt("step");
		int indent=resultSet.getInt("indent");
		int hit=resultSet.getInt("hit");
		return new BoardDto(idx,title,content,bdname,bddate,bdgroup,step,indent,hit);
	}
	
	public BoardDto contentView(String idx) {
		upHit(idx);
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		execute("SELECT * FROM board where idx=?",new DaoQuery(){
			public void executeTry() throws SQLException{
				preparedStatement.setInt(1,Integer.parseInt(idx));
				resultSet =preparedStatement.executeQuery();
				if(resultSet.next()) {
					BoardDto dto= createBoardDto();
					dtos.add(dto);
				}
			}
		});
		return dtos.get(0);
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		execute("SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board",new DaoQuery(){
		public void executeTry() throws SQLException{
			resultSet =preparedStatement.executeQuery();
				while(resultSet.next()) {
					BoardDto dto= createBoardDto();
					dtos.add(dto);
				}
			}
		});
		return (ArrayList<BoardDto>) dtos;
	}
	
	public void write(String bdname,String title,String content) {
		execute("insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,?,? from board;",new DaoQuery(){
			public void executeTry() throws SQLException{
				preparedStatement.setString(1,title);
				preparedStatement.setString(2,content);
				preparedStatement.setString(3,bdname);
				preparedStatement.setInt(4,0);
				preparedStatement.setInt(5,0);			
				preparedStatement.executeUpdate();
			}
		});
	}
	
	private void upHit(String idx) {
		
	}

}