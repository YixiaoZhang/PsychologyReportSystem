package com.action.mobile.report;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.RecordDao;
import com.entity.Record;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import oracle.sql.DATE;

public class SubmitRecord  extends ActionSupport{
	@Autowired
	RecordDao recordDao;
	String radio1;
	String radio2;
	String radio3;
	String radio4;
	String radio5;
	String radio6;
	String radio7;
	String radio8;
	String radio9;
	String text;
	String recordId;
	String fillId;
	String repId;
	
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		Record record = new Record();
		record.setRecordedId(recordId);
		record.setReportId(Integer.parseInt(repId));
		record.setFillId(fillId);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		record.setTime(df.format(new Date()));
		record.setQuestion1(radio1.substring(0, 1));
		record.setQuestion2(radio2.substring(0, 1));
		record.setQuestion3(radio3.substring(0, 1));
		record.setQuestion4(radio4.substring(0, 1));
		record.setQuestion5(radio5.substring(0, 1));
		record.setQuestion6(radio6.substring(0, 1));
		record.setQuestion7(radio7.substring(0, 1));
		record.setQuestion8(radio8.substring(0, 1));
		record.setQuestion9(radio9.substring(0, 1));
		record.setContent(text);
		if(recordDao.addRecord(record)){
			return "success";
		}
		else
			return "error";
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}

	public String getRadio1() {
		return radio1;
	}

	public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}

	public String getRadio2() {
		return radio2;
	}

	public void setRadio2(String radio2) {
		this.radio2 = radio2;
	}

	public String getRadio3() {
		return radio3;
	}

	public void setRadio3(String radio3) {
		this.radio3 = radio3;
	}

	public String getRadio4() {
		return radio4;
	}

	public void setRadio4(String radio4) {
		this.radio4 = radio4;
	}

	public String getRadio5() {
		return radio5;
	}

	public void setRadio5(String radio5) {
		this.radio5 = radio5;
	}

	public String getRadio6() {
		return radio6;
	}

	public void setRadio6(String radio6) {
		this.radio6 = radio6;
	}

	public String getRadio7() {
		return radio7;
	}

	public void setRadio7(String radio7) {
		this.radio7 = radio7;
	}

	public String getRadio8() {
		return radio8;
	}

	public void setRadio8(String radio8) {
		this.radio8 = radio8;
	}

	public String getRadio9() {
		return radio9;
	}

	public void setRadio9(String radio9) {
		this.radio9 = radio9;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getFillId() {
		return fillId;
	}

	public void setFillId(String fillId) {
		this.fillId = fillId;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}
	
	

	
}
