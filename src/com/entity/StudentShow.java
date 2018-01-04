package com.entity;
/**
 * StudentShowclass
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class StudentShow implements java.io.Serializable{
	private String id;
	private String name;
	private String sex;
	private String classesName;
	public StudentShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentShow(String id, String name, String sex, String classesName) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.classesName = classesName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}	
}
