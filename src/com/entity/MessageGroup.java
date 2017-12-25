package com.entity;

import java.util.Set;

/**
 * MessageGroup class
 * 
 * @author Fitz
 * @date 2017/12/7
 */
public class MessageGroup {
	private int id;
	private String studentId;
	private int instructorId;
	private Set<Message> message;
	public MessageGroup() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageGroup(int id, String studentId, int instructorId, Set<Message> message) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.instructorId = instructorId;
		this.message = message;
	}
	public MessageGroup(String studentId, int instructorId) {
		super();
		this.studentId = studentId;
		this.instructorId = instructorId;		
	}
	public MessageGroup(String studentId, int instructorId, Set<Message> message) {
		super();
		this.studentId = studentId;
		this.instructorId = instructorId;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public Set<Message> getMessage() {
		return message;
	}
	public void setMessage(Set<Message> message) {
		this.message = message;
	}
}
