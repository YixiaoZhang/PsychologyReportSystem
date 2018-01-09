package com.action.mobile.assistant;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.ReportDao;
import com.dao.StudentDao;
import com.entity.RecordShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShowDormitory  extends ActionSupport{
	@Autowired
	ReportDao dao;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		Map session = ActionContext.getContext().getSession();
		String id  = (String) session.get("studentId");
		List<RecordShow> list = dao.queryDormitoryReportByAssistant(id);
		ActionContext context = ActionContext.getContext();
		context.put("list", list);
		

		return "success";
	}

}
