package com.jsp.ex.model;

import java.util.Date;

public class BoardDTO {
	// 멤버 변수 - DB테이블 컬럼값
	private int id;
	private String name;
	private String title;
	private String content;
	private Date date;
	private int hit;
	private int group;
	private int step;
	private int indent;
	
	//생성자
	public BoardDTO(int id, String name, String title, String content, Date date, int hit, int group, int step, int indent) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.content = content;
		this.date = date;
		this.hit = hit;
		this.group = group;
		this.step = step;
		this.indent = indent;
	}

	//get set	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BoardDTO() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
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
	
}
