package com.action.pc.grade.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.entity.StudentShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowAllStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class ShowAllStudent extends ActionSupport{
	@Autowired
	StudentDao studentdao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		List<StudentShow> listshow = studentdao.queryStudentInfo(gradeId);
		ActionContext context = ActionContext.getContext();
		context.put("list", listshow);
		return "success";
	}
}
