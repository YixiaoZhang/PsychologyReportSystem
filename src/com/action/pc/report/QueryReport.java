package com.action.pc.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ReportDao;
import com.entity.ReportShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * QueryStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class QueryReport extends ActionSupport{
	 String method;
	 String input;
	 @Autowired
	 ReportDao reportdao;
	 @Override
	public String execute() throws Exception {
		 List<ReportShow> reportresult=new ArrayList();
		 //按学生学号查询
		 if(method.equals("1"))
	    	{
			 reportresult=reportdao.queryStudentById(input);   
			 ActionContext context = ActionContext.getContext();
		     context.put("reportresult",reportresult);	
	    	}
	
		return "success";
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the input
	 */
	public String getInput() {
		return input;
	}
	/**
	 * @param input the input to set
	 */
	public void setInput(String input) {
		this.input = input;
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
}
