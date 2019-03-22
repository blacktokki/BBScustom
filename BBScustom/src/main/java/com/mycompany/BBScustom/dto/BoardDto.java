package com.mycompany.BBScustom.dto;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class BoardDto{
	int idx;
	String title;
	String content;
	String bdname;
	Timestamp bddate;
	int bdgroup;
	int step;
	int indent;
	int hit;
	
	public BoardDto() {
	}
	
	public BoardDto(int idx,String title,String content,String bdname,Timestamp bddate,int bdgroup,int step,int indent,int hit) {
		this.idx=idx;
		this.title=title;
		this.content=content;
		this.bdname=bdname;
		this.bddate=bddate;
		this.bdgroup=bdgroup;
		this.step=step;
		this.indent=indent;
		this.hit=hit;
	}
}
