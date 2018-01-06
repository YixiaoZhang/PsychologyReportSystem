package com.action.pc.grade.dormitory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowUpdateSingleDormitory class
 * 
 * @author Fitz
 * @date 2018/1/6
 */
public class ShowUpdateSingleDormitory extends ActionSupport {
	@Autowired
	DormitoryDao dormitorydao;
	@Autowired
	StudentDao studentdao;
	String id;
	String name;
	@Override
	public String execute() throws Exception {
		// 得到寝室所有人的id
		List<String> studentidList = new ArrayList();
		// 得到寝室所有人的姓名
		List<String> studentnameList = new ArrayList();
		System.out.println(id);
		studentidList = dormitorydao.findMemberId(Integer.parseInt(id));
		for (int i = 0; i < studentidList.size(); i++) {
			String studentname = studentdao.queryStudent(studentidList.get(i)).getName();
			studentnameList.add(studentname);
		}
		ActionContext context = ActionContext.getContext();
		context.put("list", studentidList);
		System.out.println(name);
		String name2 = name.replace('a', '#');
		System.out.println(name2);
		context.put("name2", name2);
		context.put("id", id);
		return "success";
	}
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
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
}
