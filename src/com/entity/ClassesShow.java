package com.entity;
/**
 * ClassesShow class
 * 
 * @author Fitz
 * @date 2018/1/1
 */
public class ClassesShow implements java.io.Serializable{
	 private int id;
     private String name;
     private String assistantName;
     private String assistantId;    
	public ClassesShow() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassesShow(int id, String name, String assistantName, String assistantId) {
		super();
		this.id = id;
		this.name = name;
		this.assistantName = assistantName;
		this.assistantId = assistantId;
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

	public String getAssistantName() {
		return assistantName;
	}

	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}

	public String getAssistantId() {
		return assistantId;
	}

	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}  
}
