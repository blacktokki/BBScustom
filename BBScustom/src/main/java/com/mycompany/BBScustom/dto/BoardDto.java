package com.mycompany.BBScustom.dto;
import java.sql.Timestamp;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@Data
public class BoardDto implements IDto{
	int idx;
	String title;
	String content;
	String bdname;
	Timestamp bddate;
	int bdgroup;
	int step;
	int indent;
	int hit;
	
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
