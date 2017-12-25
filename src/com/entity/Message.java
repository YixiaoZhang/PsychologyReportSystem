package com.entity;
/**
 * Message  class
 * 
 * @author Fitz
 * @date 2017/12/6
 */
public class Message implements java.io.Serializable{
	private int id;
	private int groupId;
	private String flag;
	private String sendTime;
	private String content;
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message(int id, int groupId, String flag, String sendTime,String content) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.flag = flag;
		this.sendTime = sendTime;
		this.content = content;
	}
	public Message(int groupId, String flag, String sendTime,String content) {
		super();
		this.groupId = groupId;
		this.flag = flag;
		this.sendTime = sendTime;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
