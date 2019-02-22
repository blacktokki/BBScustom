package com.mycompany.BBScustom.dto;
import java.sql.Timestamp;

public class BoardDto {
	int idx;
	String title;
	String content;
	String id;
	int hit;
	Timestamp date;
	int boardgroup;
	int step;
	int intent;
	
	public BoardDto() {
		
	}
	public BoardDto(int idx,String title,String content,String id,int hit,Timestamp date,int boardgroup,int step,int intent) {
		this.idx=idx;
		this.title=title;
		this.content=content;
		this.id=id;
		this.hit=hit;
		this.date=date;
		this.boardgroup=boardgroup;
		this.step=step;
		this.intent=intent;
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getBoardgroup() {
		return boardgroup;
	}
	public void setBoardgroup(int boardgroup) {
		this.boardgroup = boardgroup;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIntent() {
		return intent;
	}
	public void setIntent(int intent) {
		this.intent = intent;
	}
}
