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
	private String member1Name;
	private String member2Name;
	private String member3Name;
	private String member4Name;
	private String member5Name;
	private String leaderId;
	private String name2;
	public DormitoryShow(int id, String name, String leaderName, String member1Name, String member2Name,
			String member3Name, String member4Name, String member5Name, String leaderId, String name2) {
		super();
		this.id = id;
		this.name = name;
		this.leaderName = leaderName;
		this.member1Name = member1Name;
		this.member2Name = member2Name;
		this.member3Name = member3Name;
		this.member4Name = member4Name;
		this.member5Name = member5Name;
		this.leaderId = leaderId;
		this.name2 = name2;
	}
	public DormitoryShow() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the member1Name
	 */
	public String getMember1Name() {
		return member1Name;
	}
	/**
	 * @param member1Name the member1Name to set
	 */
	public void setMember1Name(String member1Name) {
		this.member1Name = member1Name;
	}
	/**
	 * @return the member2Name
	 */
	public String getMember2Name() {
		return member2Name;
	}
	/**
	 * @param member2Name the member2Name to set
	 */
	public void setMember2Name(String member2Name) {
		this.member2Name = member2Name;
	}
	/**
	 * @return the member3Name
	 */
	public String getMember3Name() {
		return member3Name;
	}
	/**
	 * @param member3Name the member3Name to set
	 */
	public void setMember3Name(String member3Name) {
		this.member3Name = member3Name;
	}
	/**
	 * @return the member4Name
	 */
	public String getMember4Name() {
		return member4Name;
	}
	/**
	 * @param member4Name the member4Name to set
	 */
	public void setMember4Name(String member4Name) {
		this.member4Name = member4Name;
	}
	/**
	 * @return the member5Name
	 */
	public String getMember5Name() {
		return member5Name;
	}
	/**
	 * @param member5Name the member5Name to set
	 */
	public void setMember5Name(String member5Name) {
		this.member5Name = member5Name;
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
