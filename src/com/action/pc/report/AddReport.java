package com.action.pc.report;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ReportDao;
import com.entity.Report;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * AddReport class
 * 
 * @author Fitz
 * @date 2018/1/10
 */
public class AddReport extends ActionSupport {
	String name;
	@Autowired
	ReportDao reportdao;

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		Report report = new Report();
		report.setName(name);
		report.setGradeId(gradeId);
		boolean result = reportdao.addReport(report);
		if (result)
			return "success";
		else
			return "false";
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the reportdao
	 */
	public ReportDao getReportdao() {
		return reportdao;
	}

	/**
	 * @param reportdao
	 *            the reportdao to set
	 */
	public void setReportdao(ReportDao reportdao) {
		this.reportdao = reportdao;
	}

}
