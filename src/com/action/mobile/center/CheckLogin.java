package com.action.mobile.center;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CheckLogin extends ActionSupport {
	@Autowired
	StudentDao studentDao;
	String id;
	String password;
	
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		if (studentDao.checkStudent(id, password)) {
			return "success";
		}
		return "false";
	}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
