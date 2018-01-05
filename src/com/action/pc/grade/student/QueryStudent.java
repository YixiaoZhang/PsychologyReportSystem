package com.action.pc.grade.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.entity.Student;
import com.entity.StudentShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * QueryStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class QueryStudent extends ActionSupport{
	@Autowired
	StudentDao studentdao;
    String method;
    String input;
    @Override
	public String execute() throws Exception {
    	Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
    	List<StudentShow> listshow=new ArrayList();
    	//按姓名查询
    	if(method.equals("1"))
    	{
    		listshow=studentdao.queryStudentByName(input,gradeId);    		
    	}
    	//按学号查询
    	else {
    		listshow=studentdao.queryStudentById(input,gradeId);
    	}
    	ActionContext context = ActionContext.getContext();
		context.put("list", listshow);
		return "success";   	
    }
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}    
}
