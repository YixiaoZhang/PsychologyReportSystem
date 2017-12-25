package com.entity;
/**
 * Administrator class
 * 
 * @author Fitz
 * @date 2017/12/7
 */
public class Administrator implements java.io.Serializable{
	private int id;
	private String name;
	private String password;
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public Administrator(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
