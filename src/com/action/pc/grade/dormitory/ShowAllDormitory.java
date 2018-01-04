package com.action.pc.grade.dormitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.StudentDao;
import com.entity.Dormitory;
import com.entity.DormitoryShow;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowAllDormitory class
 * 
 * @author Fitz
 * @date 2018/1/3
 */
public class ShowAllDormitory extends ActionSupport {
	@Autowired
	DormitoryDao dormitorydao;
	@Autowired
	StudentDao studentdao;

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		List<DormitoryShow> listshow = dormitorydao.queryDormitoryInfo(gradeId);
		ActionContext context = ActionContext.getContext();
		context.put("list", listshow);
		return "success";
	}
}
