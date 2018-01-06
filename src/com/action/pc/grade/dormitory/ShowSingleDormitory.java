package com.action.pc.grade.dormitory;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowSingleDormitory class
 * 
 * @author Fitz
 * @date 2018/1/6
 */
public class ShowSingleDormitory extends ActionSupport{
	@Autowired
	DormitoryDao dormitorydao;
	String id;
	@Override
	public String execute() throws Exception {
		//得到寝室所有人的id
		String test;
		return "success";
	}
}
