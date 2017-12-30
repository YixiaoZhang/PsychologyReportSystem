package com.action.mobile.report;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.RecordDao;
import com.dao.ReportDao;
import com.dao.StudentDao;
import com.entity.RecordShow;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InputRecord  extends ActionSupport{
	@Autowired
	StudentDao studentDao;
	@Autowired
	RecordDao recordDao;
	@Autowired
	ReportDao reportDao;
	String id;
	
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		System.out.println(id);
		Student stu  = studentDao.queryStudent(id);
		if(recordDao.queryStudentIsFilled(id)){
			return "false";
		}
		
		
		ActionContext context = ActionContext.getContext();
		context.put("stuName", stu.getName());
		context.put("stuId", stu.getId());
		context.put("repName", reportDao.queryReportNameByStudentId(id));
		context.put("repId", reportDao.queryReportIdByStudentId(id));

		return "success";
	}
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public ReportDao getReportDao() {
		return reportDao;
	}

	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	

}
