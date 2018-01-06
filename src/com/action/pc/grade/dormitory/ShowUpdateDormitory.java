package com.action.pc.grade.dormitory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.entity.DormitoryShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowUpdateDormitory class
 * 
 * @author Fitz
 * @date 2018/1/6
 */
public class ShowUpdateDormitory extends ActionSupport{
	String id;
	@Autowired
	DormitoryDao dormitorydao;
	@Override
	public String execute() throws Exception {
		DormitoryShow ds= dormitorydao.querySingleDormitory(Integer.parseInt(id));
		ActionContext context = ActionContext.getContext();
		System.out.println(ds.getName());
		System.out.println(ds.getId());
		context.put("dormitory", ds);
		return "success";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
}
