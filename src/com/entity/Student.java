package com.entity;
/**
 * Student class
 * 
 * @author Fitz
 * @date 2017/12/6
 */
public class Student implements java.io.Serializable{
	private String id;
	private String name;
	private String password;
	private String sex;
	private int classes;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String id, String name, String password, String sex, int classes) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.classes = classes;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getClasses() {
		return classes;
	}
	public void setClasses(int classes) {
		this.classes = classes;
	}
}
