package com.action.pc.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ReportDao;
import com.entity.Record;
import com.entity.ReportShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ShowAllRecord class
 * 
 * @author Fitz
 * @date 2018/1/10
 */
public class ShowAllRecord extends ActionSupport{
	@Autowired
	ReportDao reportdao;
	String id;
	@Override
	public String execute() throws Exception {
		List<ReportShow> reportresult= reportdao.queryReportbyReportId(Integer.parseInt(id));	
		System.out.println(reportresult.get(2).getStudentId());
			
		ActionContext context = ActionContext.getContext();
		context.put("reportresult",reportresult);		
		return "success";			
	}
	/**
	 * @return the reportdao
	 */
	public ReportDao getReportdao() {
		return reportdao;
	}
	/**
	 * @param reportdao the reportdao to set
	 */
	public void setReportdao(ReportDao reportdao) {
		this.reportdao = reportdao;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
}
