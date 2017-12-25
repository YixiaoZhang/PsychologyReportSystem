package com.entity;
/**
 * Record  class
 * 
 * @author Fitz
 * @date 2017/12/6
 */
public class Record implements java.io.Serializable{
    private int id;
    private int reportId;
    private String recordedId;
    private String fillId;
    private String time;
    private String content;
    private String question1;
    private String question2;
    private String question3;
    private String question4;
    private String question5;
    private String question6;
    private String question7;
    private String question8;
    private String question9;
	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Record(int id, int reportId, String recordedId, String fillId, String time, String content, String question1,
			String question2, String question3, String question4, String question5, String question6, String question7,
			String question8, String question9) {
		super();
		this.id = id;
		this.reportId = reportId;
		this.recordedId = recordedId;
		this.fillId = fillId;
		this.time = time;
		this.content = content;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
	}
	public Record(int reportId, String recordedId, String fillId, String time, String content, String question1,
			String question2, String question3, String question4, String question5, String question6, String question7,
			String question8, String question9) {
		super();
		this.reportId = reportId;
		this.recordedId = recordedId;
		this.fillId = fillId;
		this.time = time;
		this.content = content;
		this.question1 = question1;
		this.question2 = question2;
		this.question3 = question3;
		this.question4 = question4;
		this.question5 = question5;
		this.question6 = question6;
		this.question7 = question7;
		this.question8 = question8;
		this.question9 = question9;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public String getRecordedId() {
		return recordedId;
	}
	public void setRecordedId(String recordedId) {
		this.recordedId = recordedId;
	}
	public String getFillId() {
		return fillId;
	}
	public void setFillId(String fillId) {
		this.fillId = fillId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getQuestion3() {
		return question3;
	}
	public void setQuestion3(String question3) {
		this.question3 = question3;
	}
	public String getQuestion4() {
		return question4;
	}
	public void setQuestion4(String question4) {
		this.question4 = question4;
	}
	public String getQuestion5() {
		return question5;
	}
	public void setQuestion5(String question5) {
		this.question5 = question5;
	}
	public String getQuestion6() {
		return question6;
	}
	public void setQuestion6(String question6) {
		this.question6 = question6;
	}
	public String getQuestion7() {
		return question7;
	}
	public void setQuestion7(String question7) {
		this.question7 = question7;
	}
	public String getQuestion8() {
		return question8;
	}
	public void setQuestion8(String question8) {
		this.question8 = question8;
	}
	public String getQuestion9() {
		return question9;
	}
	public void setQuestion9(String question9) {
		this.question9 = question9;
	}
}
