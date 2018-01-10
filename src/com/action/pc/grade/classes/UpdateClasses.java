package com.action.pc.grade.classes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.entity.Classes;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * UpdateClasses class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class UpdateClasses extends ActionSupport{
	 String classesId;
     String classesName;
     String assistantName;
     String assistantId;
     @Autowired
 	ClassesDao classesdao;
     @Override
 	public String execute() throws Exception {
    	 Map session = ActionContext.getContext().getSession();
 		int gradeId=(int) session.get("gradeId");
 		System.out.println(assistantId);
    	 Classes  classes=new Classes(Integer.parseInt(classesId),classesName,gradeId,assistantId);
    	 classesdao.updateClasses(classes);
    	 return "success";
     }
	public String getClassesId() {
		return classesId;
	}
	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}
	public String getClassesName() {
		return classesName;
	}
	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}
	public String getAssistantName() {
		return assistantName;
	}
	public void setAssistantName(String assistantName) {
		this.assistantName = assistantName;
	}
	public String getAssistantId() {
		return assistantId;
	}
	public void setAssistantId(String assistantId) {
		this.assistantId = assistantId;
	}   
}
