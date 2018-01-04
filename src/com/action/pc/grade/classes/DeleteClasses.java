package com.action.pc.grade.classes;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteClasses class
 * 
 * @author Fitz
 * @date 2018/1/3
 */
public class DeleteClasses extends ActionSupport {
	@Autowired
	ClassesDao classesdao;
	String id;

	@Override
	public String execute() throws Exception {
		System.out.println(id);
		if (classesdao.deleteClasses(Integer.parseInt(id))) {
			return "success";
		}
		return "false";
	}

	public ClassesDao getClassesdao() {
		return classesdao;
	}

	public void setClassesdao(ClassesDao classesdao) {
		this.classesdao = classesdao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
