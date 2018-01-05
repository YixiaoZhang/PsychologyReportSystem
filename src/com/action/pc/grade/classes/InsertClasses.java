package com.action.pc.grade.classes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.entity.Classes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * InsertClasses class
 * 
 * @author Fitz
 * @date 2018/1/2
 */
public class InsertClasses extends ActionSupport{
	@Autowired
	ClassesDao classesdao;
	String classesName;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId=(int) session.get("gradeId");	
		System.out.println(classesName+" "+gradeId);
		Classes classes=new Classes(classesName,gradeId);
		classesdao.addClasses(classes);
		return "success";
	}
	public ClassesDao getClassesdao() {
		return classesdao;
	}
	public void setClassesdao(ClassesDao classesdao) {
		this.classesdao = classesdao;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}	
}
