package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Report;
/**
 * ReportDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class ReportDao {
	static Configuration cfg = new Configuration().configure();
	static SessionFactory sf = cfg.buildSessionFactory();
	/** 新增月报表 */ 
	public boolean addReport(Report report) {
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
		String hql = "from Report where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Report> result = query.list();
		if(!result.isEmpty()){
			report = result.get(0);
		}
		return report;
	}
	
	/** 查询全部月报表 */ 
	public List<Report> queryReport() {
		Session s = sf.openSession();
		String hql = "from Report";
		Query query = s.createQuery(hql);
		List<Report> result = query.list();
		return result;
	}
}
