package com.action.pc.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ReportDao;
import com.entity.Record;
import com.entity.Report;
import com.entity.ReportShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowAllReport class
 * 
 * @author Fitz
 * @date 2018/1/9
 */
public class ShowAllReport extends ActionSupport {
	@Autowired
	ReportDao reportdao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		List<Report> reportresult= reportdao.queryReportByGradeId(gradeId);
		System.out.println(reportresult.get(1).getIsOpen());
		ActionContext context = ActionContext.getContext();
		context.put("reportresult",reportresult);		
		return "success";			
	}
}
