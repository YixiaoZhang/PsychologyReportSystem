package com.action.pc.grade.student;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * InsertStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class InsertStudent extends ActionSupport{
	@Autowired
	StudentDao studentdao;
	String name;
	String id;
	String sex;
	String classesId;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId=(int) session.get("gradeId");
		System.out.println(sex);
		if(sex.equals("2"))
		{
			sex="女";
		}
		else sex="男";
		//学生初始密码均为123
		Student student=new Student(id,name,"123",sex,Integer.parseInt(classesId));
		boolean result=studentdao.addStudent(student);		
		ActionContext context = ActionContext.getContext();
		context.put("result", result);
		return "success";		
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassesId() {
		return classesId;
	}
	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}
	
}
