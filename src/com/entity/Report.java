package com.entity;

import java.util.Set;
/**
 * Report class
 * 
 * @author Fitz
 * @date 2017/12/6
 */
public class Report implements java.io.Serializable {
	private int id;
	private String name;
	private int gradeId;
	private int isOpen;
	private Set<Record> record;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Report(int id, String name, int gradeId) {
		super();
		this.id = id;
		this.name = name;
		this.gradeId = gradeId;
		this.isOpen = isOpen;
	}
	public Report(String name, int gradeId,int isOpen) {
		super();
		this.name = name;
		this.gradeId = gradeId;
		this.isOpen = isOpen;
	}
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
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public int getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(int isOpen) {
		this.isOpen = isOpen;
	}
	public Set<Record> getRecord() {
		return record;
	}
	public void setRecord(Set<Record> record) {
		this.record = record;
	}
}
