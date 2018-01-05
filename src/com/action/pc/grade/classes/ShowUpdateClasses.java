package com.action.pc.grade.classes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.dao.StudentDao;
import com.entity.ClassesShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowUpdateClasses class
 * 
 * @author Fitz
 * @date 2018/1/5
 */
public class ShowUpdateClasses extends ActionSupport {
	String id;
	@Autowired
	ClassesDao classesdao;
	@Override
	public String execute() throws Exception {
		ClassesShow cs=classesdao.queryClassesInfo(Integer.parseInt(id));
		ActionContext context = ActionContext.getContext();
		System.out.println(cs.getName());
		context.put("classes", cs);
		return "success";
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
