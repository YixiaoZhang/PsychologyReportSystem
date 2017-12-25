package com.entity;
/**
 * Grade class
 * 
 * @author Fitz
 * @date 2017/12/5
 */
public class Grade implements java.io.Serializable{
	private int id;
	private String name;
	public Grade() {
		
	}
	public Grade(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Grade(String name) {
		super();
		this.name = name;
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
}
