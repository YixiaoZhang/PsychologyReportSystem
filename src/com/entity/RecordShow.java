package com.entity;

public class RecordShow  implements java.io.Serializable{

	String name;
	String id;
	String dormitory;
	String isFill;
	
	public RecordShow() {
		super();
	}
	public RecordShow(String name, String id, String dormitory, String isFill) {
		super();
		this.name = name;
		this.id = id;
		this.dormitory = dormitory;
		this.isFill = isFill;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDormitory() {
		return dormitory;
	}
	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}
	public String getIsFill() {
		return isFill;
	}
	public void setIsFill(String isFill) {
		this.isFill = isFill;
	}
	
	
}
