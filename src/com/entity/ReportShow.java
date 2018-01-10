package com.entity;
/**
 * ShowAllReport class
 * 
 * @author Fitz
 * @date 2018/1/10
 */
public class ReportShow implements java.io.Serializable{
   int reportId;
   int recordId;
   String reportName;
   String classesName;
   String studentName;
   String studentId;
   String fillId;
   String time;
   String answer1;
   String answer2;
   String answer3;
   String answer4;
   String answer5;
   String answer6;
   String answer7;
   String answer8;
   String answer9;
public ReportShow() {
	super();
	// TODO Auto-generated constructor stub
}
public ReportShow(int reportId, int recordId, String reportName, String classesName, String studentName,
		String studentId, String fillId, String time, String answer1, String answer2, String answer3, String answer4,
		String answer5, String answer6, String answer7, String answer8, String answer9) {
	super();
	this.reportId = reportId;
	this.recordId = recordId;
	this.reportName = reportName;
	this.classesName = classesName;
	this.studentName = studentName;
	this.studentId = studentId;
	this.fillId = fillId;
	this.time = time;
	this.answer1 = answer1;
	this.answer2 = answer2;
	this.answer3 = answer3;
	this.answer4 = answer4;
	this.answer5 = answer5;
	this.answer6 = answer6;
	this.answer7 = answer7;
	this.answer8 = answer8;
	this.answer9 = answer9;
}
/**
 * @return the fillId
 */
public String getFillId() {
	return fillId;
}
/**
 * @param fillId the fillId to set
 */
public void setFillId(String fillId) {
	this.fillId = fillId;
}
/**
 * @return the answer1
 */
public String getAnswer1() {
	return answer1;
}
/**
 * @param answer1 the answer1 to set
 */
public void setAnswer1(String answer1) {
	this.answer1 = answer1;
}
/**
 * @return the answer2
 */
public String getAnswer2() {
	return answer2;
}
/**
 * @param answer2 the answer2 to set
 */
public void setAnswer2(String answer2) {
	this.answer2 = answer2;
}
/**
 * @return the answer3
 */
public String getAnswer3() {
	return answer3;
}
/**
 * @param answer3 the answer3 to set
 */
public void setAnswer3(String answer3) {
	this.answer3 = answer3;
}
/**
 * @return the answer4
 */
public String getAnswer4() {
	return answer4;
}
/**
 * @param answer4 the answer4 to set
 */
public void setAnswer4(String answer4) {
	this.answer4 = answer4;
}
/**
 * @return the answer5
 */
public String getAnswer5() {
	return answer5;
}
/**
 * @param answer5 the answer5 to set
 */
public void setAnswer5(String answer5) {
	this.answer5 = answer5;
}
/**
 * @return the answer6
 */
public String getAnswer6() {
	return answer6;
}
/**
 * @param answer6 the answer6 to set
 */
public void setAnswer6(String answer6) {
	this.answer6 = answer6;
}
/**
 * @return the answer7
 */
public String getAnswer7() {
	return answer7;
}
/**
 * @param answer7 the answer7 to set
 */
public void setAnswer7(String answer7) {
	this.answer7 = answer7;
}
/**
 * @return the answer8
 */
public String getAnswer8() {
	return answer8;
}
/**
 * @param answer8 the answer8 to set
 */
public void setAnswer8(String answer8) {
	this.answer8 = answer8;
}
/**
 * @return the answer9
 */
public String getAnswer9() {
	return answer9;
}
/**
 * @param answer9 the answer9 to set
 */
public void setAnswer9(String answer9) {
	this.answer9 = answer9;
}
/**
 * @return the recordId
 */
public int getRecordId() {
	return recordId;
}
/**
 * @param recordId the recordId to set
 */
public void setRecordId(int recordId) {
	this.recordId = recordId;
}
/**
 * @return the reportId
 */
public int getReportId() {
	return reportId;
}
/**
 * @param reportId the reportId to set
 */
public void setReportId(int reportId) {
	this.reportId = reportId;
}
/**
 * @return the reportName
 */
public String getReportName() {
	return reportName;
}
/**
 * @param reportName the reportName to set
 */
public void setReportName(String reportName) {
	this.reportName = reportName;
}
/**
 * @return the classesName
 */
public String getClassesName() {
	return classesName;
}
/**
 * @param classesName the classesName to set
 */
public void setClassesName(String classesName) {
	this.classesName = classesName;
}
/**
 * @return the studentName
 */
public String getStudentName() {
	return studentName;
}
/**
 * @param studentName the studentName to set
 */
public void setStudentName(String studentName) {
	this.studentName = studentName;
}
/**
 * @return the studentId
 */
public String getStudentId() {
	return studentId;
}
/**
 * @param studentId the studentId to set
 */
public void setStudentId(String studentId) {
	this.studentId = studentId;
}
/**
 * @return the time
 */
public String getTime() {
	return time;
}
/**
 * @param time the time to set
 */
public void setTime(String time) {
	this.time = time;
}
   
}
