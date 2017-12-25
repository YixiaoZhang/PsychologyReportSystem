package com.entity;
/**
 * Instructor class
 * 
 * @author Fitz
 * @date 2017/12/5
 */
public class Instructor implements java.io.Serializable{
    private int id;
    private int gradeId;
    private String password;
    private String name;
	public Instructor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Instructor(int id, int gradeId, String password, String name) {
		super();
		this.id = id;
		this.gradeId = gradeId;
		this.password = password;
		this.name = name;
	}
	public Instructor(int gradeId, String password, String name) {
		super();
		this.gradeId = gradeId;
		this.password = password;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
