package com.action.mobile.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CenterIndex extends ActionSupport{
	@Autowired
	StudentDao dao;
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		Map session = ActionContext.getContext().getSession();
		String id  = (String) session.get("studentId");
		String[] a = dao.queryDormitoryReport(id);
		String[] b = dao.queryClassReport(id);
		ActionContext context = ActionContext.getContext();
		context.put("dor0", a[0]);
		context.put("dor1", a[1]);
		context.put("dor2", a[2]);
		context.put("class0", b[0]);
		context.put("class1", b[1]);
		context.put("class2", b[2]);

		return "success";
	}

}
