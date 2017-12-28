package com.action.mobile.center;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.StudentDao;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePassword extends ActionSupport{
	@Autowired
	StudentDao dao;
	String password;
	String newpassword;
	String newpassword2;
	@Override
	public String execute() throws Exception {
		System.out.println(password+"|"+newpassword+"|"+newpassword2);
		// TODO 自动生成的方法存根
		Map session = ActionContext.getContext().getSession();
		String id  = (String) session.get("studentId");
		ActionContext context = ActionContext.getContext();
		
		if(!newpassword.equals(newpassword2)){
			context.put("textFalse", "两次密码输入不一致");
		}
		else if(!password.equals(dao.queryStudent(id).getPassword())){
			context.put("textFalse", "旧密码错误！");
		}else{
			Student stu= dao.queryStudent(id);
			stu.setPassword(newpassword);
			dao.updateStudent(stu);
			context.put("textTrue", "修改密码成功！");
		}
		return "success";
	}
	public StudentDao getDao() {
		return dao;
	}
	public void setDao(StudentDao dao) {
		this.dao = dao;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getNewpassword2() {
		return newpassword2;
	}
	public void setNewpassword2(String newpassword2) {
		this.newpassword2 = newpassword2;
	}
	

}
