package com.action.pc.report;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ReportDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * SetOpen class
 * 
 * @author Fitz
 * @date 2018/1/11
 */
public class SetOpen extends ActionSupport {
	String isOpen;
	String id;
	@Autowired
	ReportDao reportdao;
	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		if(isOpen.equals("0"))
		{
			//先将所有的月报表都关闭
			reportdao.setClose(gradeId);
			//开启月报表
			reportdao.setOpen(Integer.parseInt(id));
		}
		else
			//关闭心理月报表
			reportdao.setClose(gradeId);
		return "success";

	}
	/**
	 * @return the isOpen
	 */
	public String getIsOpen() {
		return isOpen;
	}
	/**
	 * @param isOpen the isOpen to set
	 */
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
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
