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

public class ClassesIndex  extends ActionSupport{
	@Autowired
	ReportDao reportDao;
	@Autowired
	StudentDao stuDao;
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		Map session = ActionContext.getContext().getSession();
		String id  = (String) session.get("studentId");
		
		
		List<RecordShow> list = reportDao.queryClassReportByAssistant(id);
		String[] a = stuDao.queryClassReport(id);
		ActionContext context = ActionContext.getContext();
		context.put("dor0", a[0]);
		context.put("dor1", a[1]);
		context.put("dor2", a[2]);
		context.put("list", list);
		
		System.out.println(a[0]+"|"+a[1]+"|"+a[2]+"|"+list.size());

		return "success";
	}
}