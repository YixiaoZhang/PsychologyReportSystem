package com.entity;
/**
 * Classes class
 * 
 * @author Fitz
 * @date 2017/12/6
 */
public class Classes implements java.io.Serializable{
     private int id;
     private String name;
     private int gradeId;
     private String assistantId;
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classes(int id, String name, int gradeId, String assistantId) {
		super();
		this.id = id;
		this.name = name;
		this.gradeId = gradeId;
		this.assistantId = assistantId;
	}
	public Classes(String name, int gradeId, String assistantId) {
		super();
		this.name = name;
		this.gradeId = gradeId;
		this.assistantId = assistantId;
	}
	public Classes(String name, int gradeId) {
		super();
		this.name = name;
		this.gradeId = gradeId;
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
	public String getAssistantId() {
		return assistantId;
	}
	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}
}
