package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;
import com.mycompany.BBScustom.dto.BoardDto;
import org.springframework.stereotype.Repository;

@Repository
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
	
	public BoardDto replyView(String idx) {
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
		execute("SELECT idx, title, content, bdname, bddate, bdgroup, step, indent, hit FROM board order by bdgroup desc,step asc",new DaoException(){
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
		execute("insert into board (title,content,bdname,bdgroup,step,indent) select ?,?,?, ifnull(max(idx),0)+1 ,0,0 from board;",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setString(1,title);
				ps.setString(2,content);
				ps.setString(3,bdname);	
				ps.executeUpdate();
				return rs;
			}
		});
	}
	
	public void modify(String idx,String bdname,String title,String content) {
		execute("update board set bdname = ?,title = ?,content =?  where idx= ? ",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setString(1,bdname);
				ps.setString(2,title);
				ps.setString(3,content);
				ps.setInt(4,Integer.parseInt(idx));			
				ps.executeUpdate();
				return rs;
			}
		});
	}
	
	public void delete(String idx) {
		execute("delete from board where idx= ? ",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setInt(1,Integer.parseInt(idx));			
				ps.executeUpdate();
				return rs;
			}
		});
	}
	
	public void reply(String idx,String bdname,String title,String content,String bdgroup, String step, String indent){
		System.out.println("-replydao-");
		execute("insert into board (title,content,bdname,bdgroup,step,indent) values (?,?,?,?,?,?);",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setString(1,title);
				ps.setString(2,content);
				ps.setString(3,bdname);	
				ps.setInt(4,Integer.parseInt(bdgroup));	
				ps.setInt(5,Integer.parseInt(step)+1);	
				ps.setInt(6,Integer.parseInt(indent)+1);	
				ps.executeUpdate();
				return rs;
			}
		});
	}
	public void replyShape(String bdgroup,String step){
		execute("update board set step = step+1 where bdgroup = ? and step > ?",new DaoException(){
			public ResultSet executeTry(PreparedStatement ps, ResultSet rs) throws SQLException{
				ps.setInt(1,Integer.parseInt(bdgroup));	
				ps.setInt(2,Integer.parseInt(step));		
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