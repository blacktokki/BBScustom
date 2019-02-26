package com.mycompany.BBScustom.dto;
import java.sql.Timestamp;

public class BoardDto extends AbstractDto{
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
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBdname() {
		return bdname;
	}
	public void setBdname(String bdname) {
		this.bdname = bdname;
	}
	public Timestamp getBddate() {
		return bddate;
	}
	public void setBddate(Timestamp bddate) {
		this.bddate = bddate;
	}
	public int getBdgroup() {
		return bdgroup;
	}
	public void setBdgroup(int bdgroup) {
		this.bdgroup = bdgroup;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	
}
