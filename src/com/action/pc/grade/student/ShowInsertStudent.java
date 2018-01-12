package com.action.pc.grade.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.entity.Classes;
import com.entity.StudentShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowInsertStudent  class
 * 
 * @author Fitz
 * @date 2018/1/11
 */
public class ShowInsertStudent extends ActionSupport{
	@Autowired
	ClassesDao classesdao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		ActionContext context = ActionContext.getContext();
		List<Classes> classeslist=classesdao.queryClassesbyGradeId(gradeId);
		System.out.println(classeslist.get(4).getName());
		context.put("classes", classeslist);
		return "success";
	}
}
