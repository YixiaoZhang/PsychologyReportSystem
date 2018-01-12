package com.action.pc.grade.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.dao.StudentDao;
import com.entity.Classes;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * UpdateClasses class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class UpdateStudent extends ActionSupport {
	String studentId;
	String studentName;
	String studentSex;
	String classesName;
	String classesId;
	@Autowired
	StudentDao studentdao;
	@Autowired
	ClassesDao classesdao;

	@Override
	public String execute() throws Exception {
		// 学生初始密码均为123
		System.out.println(studentId);		
		System.out.println(classesId);
		Student student = new Student(studentId, studentName,"123",studentSex,Integer.parseInt(classesId));
		boolean result2=studentdao.updateStudent(student);
		ActionContext context = ActionContext.getContext();
		String page="1"; 
    	context.put("page", page); 
		context.put("result2", result2);
		return "success";
	}
	/**
	 * @return the classesId
	 */
	public String getClassesId() {
		return classesId;
	}

	/**
	 * @param classesId the classesId to set
	 */
	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

	/**
	 * @return the classesdao
	 */
	public ClassesDao getClassesdao() {
		return classesdao;
	}

	/**
	 * @param classesdao the classesdao to set
	 */
	public void setClassesdao(ClassesDao classesdao) {
		this.classesdao = classesdao;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getClassesName() {
		return classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public StudentDao getStudentdao() {
		return studentdao;
	}

	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
}
