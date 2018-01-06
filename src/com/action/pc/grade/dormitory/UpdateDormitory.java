package com.action.pc.grade.dormitory;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdateClasses class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class UpdateDormitory extends ActionSupport{
	String id;
	String name;
	String leaderId;
	String leaderName;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		System.out.println(id);
		dormitorydao.updateDormitoryInfo(Integer.parseInt(id),name,leaderId,leaderName);
		return "success";
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
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
}
