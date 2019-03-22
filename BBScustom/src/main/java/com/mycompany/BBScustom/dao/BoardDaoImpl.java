package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDaoImpl implements BoardDao,JdbcTemplateDao{

	public BoardDto contentView(String idx) {
		String query = "SELECT * FROM board where idx = " + idx;
		return JDBC_TEMPLATE.queryForObject(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
		
	public ArrayList<BoardDto> list() {
		String query = "SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board order by bdgroup desc,step asc";
		return (ArrayList<BoardDto>) JDBC_TEMPLATE.query(query, new BeanPropertyRowMapper<BoardDto>(BoardDto.class));
	}
	
	public void write(String bdname,String title,String content) { 
		String query = "insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,0,0 from board";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,title); 
 				ps.setString(2,content); 
 				ps.setString(3,bdname);	
			}
		});
	}
	
	public void modify(final String idx, final String bdname, final String title, final String content) {
		String query = "update board set bdname = ?,title = ?,content =?  where idx= ? ";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bdname);
				ps.setString(2, title);
				ps.setString(3, content);
				ps.setInt(4, Integer.parseInt(idx));
			}
		});
	}
	
	public void delete(final String idx) {
		String query = "delete from mvc_board where idx = ?";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, idx);
			}
		});
	} 

	public void reply(String bdname,String title,String content,String bdgroup, String step, String indent) {
		String query = "insert into board (title,content,bdname,bdgroup,step,indent) values (?,?,?,?,?,?)";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,title); 
				ps.setString(2,content); 
				ps.setString(3,bdname);	 
				ps.setInt(4,Integer.parseInt(bdgroup));	 
				ps.setInt(5,Integer.parseInt(step)+1);	 
				ps.setInt(6,Integer.parseInt(indent)+1); 
			}
		});
		
	}
	
	public void replyShape(String bdgroup,String step){
		String query = "update board set step = step+1 where bdgroup = ? and step > ?";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bdgroup);
				ps.setString(2, step);
			}
		});
	}
	
	public void upHit(String idx) {
		String query = "update board set hit = hit+1 where idx= ?";
		JDBC_TEMPLATE.update(query, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, Integer.parseInt(idx));
			}
		});
	}
}