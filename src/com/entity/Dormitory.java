package com.entity;

/**
 * Dormitory class
 * 
 * @author Fitz
 * @date 2017/12/5
 */
public class Dormitory implements java.io.Serializable{
	private int id;
	private String name;
	private String leaderId;
	private String member1Id;
	private String member2Id;
	private String member3Id;
	private String member4Id;
	private String member5Id;
	private int gradeId;
	public Dormitory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dormitory(int id, String name, String leaderId, String member1Id, String member2Id, String member3Id,
			String member4Id, String member5Id, int gradeId) {
		super();
		this.id = id;
		this.name = name;
		this.leaderId = leaderId;
		this.member1Id = member1Id;
		this.member2Id = member2Id;
		this.member3Id = member3Id;
		this.member4Id = member4Id;
		this.member5Id = member5Id;
		this.gradeId = gradeId;
	}
	public Dormitory(String name, String leaderId, String member1Id, String member2Id, String member3Id,
			String member4Id, String member5Id, int gradeId) {
		super();
		this.name = name;
		this.leaderId = leaderId;
		this.member1Id = member1Id;
		this.member2Id = member2Id;
		this.member3Id = member3Id;
		this.member4Id = member4Id;
		this.member5Id = member5Id;
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
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getMember1Id() {
		return member1Id;
	}
	public void setMember1Id(String member1Id) {
		this.member1Id = member1Id;
	}
	public String getMember2Id() {
		return member2Id;
	}
	public void setMember2Id(String member2Id) {
		this.member2Id = member2Id;
	}
	public String getMember3Id() {
		return member3Id;
	}
	public void setMember3Id(String member3Id) {
		this.member3Id = member3Id;
	}
	public String getMember4Id() {
		return member4Id;
	}
	public void setMember4Id(String member4Id) {
		this.member4Id = member4Id;
	}
	public String getMember5Id() {
		return member5Id;
	}
	public void setMember5Id(String member5Id) {
		this.member5Id = member5Id;
	}
	public int getGradeId() {
		return gradeId;
	}
	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}
}
