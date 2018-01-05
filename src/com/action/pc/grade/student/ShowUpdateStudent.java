package com.action.pc.grade.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.entity.StudentShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowUpdateStudent  class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class ShowUpdateStudent extends ActionSupport{
	String id;
	@Autowired
	StudentDao studentdao;
	@Override
	public String execute() throws Exception {
		StudentShow ss=studentdao.querySingleStudentInfo(id);
		ActionContext context = ActionContext.getContext();
		System.out.println(ss.getName());
		context.put("student", ss);
		return "success";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
