package com.action.pc.grade.dormitory;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * DeleteDormitory class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class DeleteDormitory extends ActionSupport{
	@Autowired
	DormitoryDao dormitorydao;
	String id;

	@Override
	public String execute() throws Exception {
		System.out.println(id);
		boolean result=dormitorydao.deleteDormitory(Integer.parseInt(id));
		if (result) {
			ActionContext context = ActionContext.getContext();
			String page="1"; 
	    	context.put("page", page); 
	    	context.put("result1", result); 
			return "success";
		}
		return "false";
	}

	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}

	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}	
}
