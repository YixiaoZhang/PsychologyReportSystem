package com.action.pc.grade.dormitory;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.entity.Dormitory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * InsertDormitory class
 * 
 * @author Fitz
 * @date 2018/1/10
 */
public class InsertDormitory extends ActionSupport{
	String DormitoryName;
	String DormitoryLeaderId;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId=(int) session.get("gradeId");	
		//System.out.println(classesName+" "+gradeId);
		Dormitory dormitory=new Dormitory(DormitoryName,DormitoryLeaderId,gradeId);
		boolean result=dormitorydao.addDormitory(dormitory);
		ActionContext context = ActionContext.getContext();
		String page="1";
    	context.put("result", result);  
    	context.put("page", page); 
		return "success";
	}
	public String getDormitoryName() {
		return DormitoryName;
	}
	public void setDormitoryName(String dormitoryName) {
		DormitoryName = dormitoryName;
	}
	public String getDormitoryLeaderId() {
		return DormitoryLeaderId;
	}
	public void setDormitoryLeaderId(String dormitoryLeaderId) {
		DormitoryLeaderId = dormitoryLeaderId;
	}
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
	
}
