package com.entity;
/**
 * DormitoryShow class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class DormitoryShow implements java.io.Serializable{
	private int id;
	private String name;
	private String leaderName;
	private String leaderId;
	private String name2;
	public DormitoryShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DormitoryShow(int id, String name, String leaderName, String leaderId) {
		super();
		this.id = id;
		this.name = name;
		this.leaderName = leaderName;
		this.leaderId = leaderId;
		this.name2=name.replaceAll("#", "a");
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
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}	
	
}
