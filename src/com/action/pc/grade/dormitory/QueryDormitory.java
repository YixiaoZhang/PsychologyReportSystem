package com.action.pc.grade.dormitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.entity.DormitoryShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * QueryDormitory class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class QueryDormitory extends ActionSupport {
	String method;
	String input;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		List<DormitoryShow> listshow = new ArrayList();
		if (method.equals("1")) {
			listshow = dormitorydao.queryDormitoryInfoByName(gradeId,input);
		}else if(method.equals("2")){
			listshow = dormitorydao.queryDormitoryInfoByStudentName(gradeId,input);
		}
		else
			listshow = dormitorydao.queryDormitoryInfoByStudentId(gradeId,input);
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
