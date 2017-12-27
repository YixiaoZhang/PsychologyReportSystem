package com.action.mobile.center;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entity.Student;
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
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			Student stu = studentDao.queryStudent(id);
			boolean isDor = studentDao.isDormitory(id);
			boolean isAss = studentDao.isAssistant(id);
			Map session = ActionContext.getContext().getSession();
			session.put("studentId", stu.getId());
			session.put("studentName", stu.getName());
			session.put("isAss", isAss);
			session.put("isDor", isDor);
			return "success";
		}
		ActionContext context = ActionContext.getContext();
		context.put("error", "true");
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
