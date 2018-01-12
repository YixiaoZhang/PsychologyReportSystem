package com.action.pc.grade.dormitory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.entity.Dormitory;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
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
	String member1Id;
	String member2Id;
	String member3Id;
	String member4Id;
	String member5Id;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		System.out.println(member1Id);
		System.out.println(member5Id);
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		Dormitory dormitory=new Dormitory(Integer.parseInt(id),name,leaderId,member1Id,member2Id,member3Id,member4Id,member5Id,gradeId);
		//dormitorydao.updateDormitory(dormitory);
		boolean result=dormitorydao.updateDormitoryInfo(dormitory);
		ActionContext context = ActionContext.getContext();
		String page="1"; 
    	context.put("page", page); 
    	context.put("result2", result); 
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
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
	/**
	 * @return the member1Id
	 */
	public String getMember1Id() {
		return member1Id;
	}
	/**
	 * @param member1Id the member1Id to set
	 */
	public void setMember1Id(String member1Id) {
		this.member1Id = member1Id;
	}
	/**
	 * @return the member2Id
	 */
	public String getMember2Id() {
		return member2Id;
	}
	/**
	 * @param member2Id the member2Id to set
	 */
	public void setMember2Id(String member2Id) {
		this.member2Id = member2Id;
	}
	/**
	 * @return the member3Id
	 */
	public String getMember3Id() {
		return member3Id;
	}
	/**
	 * @param member3Id the member3Id to set
	 */
	public void setMember3Id(String member3Id) {
		this.member3Id = member3Id;
	}
	/**
	 * @return the member4Id
	 */
	public String getMember4Id() {
		return member4Id;
	}
	/**
	 * @param member4Id the member4Id to set
	 */
	public void setMember4Id(String member4Id) {
		this.member4Id = member4Id;
	}
	/**
	 * @return the member5Id
	 */
	public String getMember5Id() {
		return member5Id;
	}
	/**
	 * @param member5Id the member5Id to set
	 */
	public void setMember5Id(String member5Id) {
		this.member5Id = member5Id;
	}	
}
