package com.action.mobile.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.dao.StudentDao;
import com.entity.Classes;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CenterInfo extends ActionSupport{
	@Autowired
	StudentDao studentDao;
	@Autowired
	ClassesDao classesDao;
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根

		Map session = ActionContext.getContext().getSession();
		String id  = (String) session.get("studentId");
		Student student = studentDao.queryStudent(id);
		Classes classes = classesDao.queryClasses(student.getClasses());
		ActionContext context = ActionContext.getContext();
		context.put("name", student.getName());
		context.put("id", student.getId());
		context.put("classes", classes.getName());

		return "success";
	}

}
