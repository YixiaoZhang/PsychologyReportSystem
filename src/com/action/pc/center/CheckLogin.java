package com.action.pc.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.InstructorDao;
import com.entity.Instructor;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * CheckLogin class
 * 
 * @author Fitz
 * @date 2018/1/2
 */
public class CheckLogin extends ActionSupport {
	@Autowired
	InstructorDao instructorDao;
	String name;
	String password;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println(name + "  " + password);
		if (instructorDao.checkInstructorDao(name, password)) {
			ApplicationContext act = new ClassPathXmlApplicationContext("beans.xml");
			int instructorId = instructorDao.getInstructorId(name);
			Map session = ActionContext.getContext().getSession();
			int gradeId=instructorDao.getGradeId(instructorId);
			session.put("instructorId", instructorId);
			session.put("gradeId", gradeId);
			session.put("instructorName", name);
			return "success";
		}
		ActionContext context = ActionContext.getContext();
		context.put("error", "true");
		return "false";
	}

	public InstructorDao getInstructorDao() {
		return instructorDao;
	}

	public void setInstructorDao(InstructorDao instructorDao) {
		this.instructorDao = instructorDao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
