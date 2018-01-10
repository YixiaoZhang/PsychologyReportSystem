package com.action.pc.grade.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.dao.StudentDao;
import com.entity.Classes;
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
	@Autowired
	ClassesDao classesdao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		StudentShow ss=studentdao.querySingleStudentInfo(id);
		ActionContext context = ActionContext.getContext();
		System.out.println(ss.getName());
		List<Classes> classeslist=classesdao.queryClassesbyGradeId(gradeId);
		context.put("student", ss);
		context.put("classes", classeslist);
		return "success";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
