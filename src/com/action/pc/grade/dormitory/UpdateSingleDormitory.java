package com.action.pc.grade.dormitory;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateSingleDormitory extends ActionSupport {
	String id;
	String memberid;
	String name;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		String memberId[]=memberid.split(", ");
		for(int i=0;i<memberId.length;i++)
		{
			System.out.println(memberId[i]);
		}
		dormitorydao.updateDormitoryMemberInfo(Integer.parseInt(id),memberId);
		String name2=name.replace('a', '#');
		ActionContext context = ActionContext.getContext();
		context.put("name2", name2);
		return "success";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}

	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
