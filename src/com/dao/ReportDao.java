package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.RecordShow;
import com.entity.Report;
/**
 * ReportDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class ReportDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增月报表 */ 
	public boolean addReport(Report report) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(report);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return true;
	}
	
	/** 修改月报表 */ 
	public boolean updateReport(Report report) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(report);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			return false;
		} finally {
			if (s != null) {
				s.close();
			}
		}
		return true;
	}
	
	
	/** 查询一个月报表（按id） */ 
	public Report queryReport(int id) {
		Report report = null;
		Session s = sessionFactory.openSession();
		String hql = "from Report where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Report> result = query.list();
		if(!result.isEmpty()){
			report = result.get(0);
		}
		return report;
	}
	
	/** 查询开启的报表名称（按学生id） */ 
	public String queryReportNameByStudentId(String id) {
		Report report = null;
		Session s = sessionFactory.openSession();
		String hql = "select name from Report where isOpen=1 and gradeId in (select gradeId from Classes where id in (select classes from Student where id = ?))";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if(!result.isEmpty()){
			return result.get(0);
		}
		return "error";
	}
	
	/** 通过学生id查月报表id */ 
	public String queryReportIdByStudentId(String id) {
		Report report = null;
		Session s = sessionFactory.openSession();
		String hql = "select id from Report where isOpen=1 and gradeId in (select gradeId from Classes where id in (select classes from Student where id = ?))";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Integer> result = query.list();
		if(!result.isEmpty()){
			return result.get(0).toString();
		}
		return "error";
	}
	
	/** 心理委员显示寝室长列表 */
	public List<RecordShow> queryDormitoryReportByAssistant(String id) {
		List<RecordShow> list = new ArrayList<RecordShow>();
		Session s = sessionFactory.openSession();
		String hql = "SELECT leaderId FROM Dormitory where gradeId in (select gradeId from Classes where assistantId =?) and leaderId in (select id from Student where classes in (select classes from Student where id = ?))";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
		}
		List<Object> result0 = query.list();
		for (String temp : result) {
			RecordShow rs = new RecordShow();
			rs.setId(temp);
			rs.setDormitory("");
			hql = "select id from Record where recordedId=? and reportId in (select id from Report where isOpen =1 and gradeId in (select gradeId from Classes where assistantId =?))";
			query = s.createQuery(hql);
			query.setString(0, temp);
			query.setString(1, id);
			result0 = query.list();
			if (result0.isEmpty()) {
				rs.setIsFill("0");// 未填写
			} else {
				rs.setIsFill("1");// 已填写
			}
			hql = "select name from Student where id=?";
			query = s.createQuery(hql);
			query.setString(0, temp);
			List<String> result1 = query.list();
			if (!result1.isEmpty()) {
				rs.setName(result1.get(0));
			}
			list.add(rs);
		}
		return list;
	}
	
	/** 心理委员显示班级列表 */
	public List<RecordShow> queryClassReportByAssistant(String id) {
		List<RecordShow> list = new ArrayList<RecordShow>();
		Session s = sessionFactory.openSession();
		String hql = "select id from Student where classes in (select classes from Student where id = ?)";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
		}
		
		List<Object> result0 = query.list();
		for (String temp : result) {
			RecordShow rs = new RecordShow();
			rs.setId(temp);
			rs.setDormitory("");
			hql = "select id from Record where recordedId=? and reportId in (select id from Report where isOpen =1 and gradeId in (select gradeId from Classes where assistantId =?))";
			query = s.createQuery(hql);
			query.setString(0, temp);
			query.setString(1, id);
			result0 = query.list();
			if (result0.isEmpty()) {
				rs.setIsFill("0");// 未填写
			} else {
				rs.setIsFill("1");// 已填写
			}
			hql = "select name from Student where id=?";
			query = s.createQuery(hql);
			query.setString(0, temp);
			List<String> result1 = query.list();
			if (!result1.isEmpty()) {
				rs.setName(result1.get(0));
			}
			list.add(rs);
		}
		return list;
	}
	
	
	
	/** 查询全部月报表 */ 
	public List<Report> queryReport() {
		Session s = sessionFactory.openSession();
		String hql = "from Report";
		Query query = s.createQuery(hql);
		List<Report> result = query.list();
		return result;
	}
}
