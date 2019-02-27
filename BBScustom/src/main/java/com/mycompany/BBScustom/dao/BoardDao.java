package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;

public class BoardDao extends AbstractDao implements IBoardDao{
	
	public BoardDao(){
		initialize("java:comp/env/jdbc/mydb",BoardDto.class);
	}
	
	public BoardDto contentView(String idx) {
		ArrayList<BoardDto> dtos = new ArrayList<>();
		execute("SELECT * FROM board where idx=?",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setInt(1,Integer.parseInt(idx));
				rs =ps.executeQuery();
				if(rs.next()) {
					BoardDto dto= (BoardDto) bprm.mapRow(rs, 0);
					dtos.add(dto);
				}
				return rs;
			}
		});
		return dtos.get(0);
	}
	
	public ArrayList<BoardDto> list(){
		ArrayList<BoardDto> dtos=new ArrayList<BoardDto>();
		execute("SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				rs =ps.executeQuery();
				for(int i=0;rs.next();i++) {
					BoardDto dto= (BoardDto) bprm.mapRow(rs, i);
					dtos.add(dto);
				}
				return rs;
			}
		});
		return (ArrayList<BoardDto>) dtos;
	}
	
	public void write(String bdname,String title,String content) {
		execute("insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,?,? from board;",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setString(1,title);
				ps.setString(2,content);
				ps.setString(3,bdname);
				ps.setInt(4,0);
				ps.setInt(5,0);			
				ps.executeUpdate();
				return rs;
			}
		});
	}
	
	public void upHit(String idx) {
		execute("update board set hit = hit+1 where idx= ? ",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setString(1,idx);			
				ps.executeUpdate();
				return rs;
			}
		});
	}

}