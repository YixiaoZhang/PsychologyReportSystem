package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Record;
/**
 * RecordDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class RecordDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增记录 */ 
	public boolean addRecord(Record record) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(record);
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
	
	
	/** 删除记录 */ 
	public boolean deleteRecord(String id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Record record = queryRecord(id);
			s.delete(record);
			tx.commit();
			s.close();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			s.close();
		} catch(Exception e){
			return false;
		}
		return false;
	}
	
	/** 查询一个记录（按id） */ 
	public Record queryRecord(String id) {
		Record record = null;
		Session s = sessionFactory.openSession();
		String hql = "from Record where id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Record> result = query.list();
		if(!result.isEmpty()){
			record = result.get(0);
		}
		return record;
	}
	
	/** 查询一个记录（按id） */ 
	public boolean queryStudentIsFilled(String id) {
		Record record = null;
		Session s = sessionFactory.openSession();
		String hql = "select id from Record where recordedId=? and reportId in (select id from Report where isOpen =1)";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Record> result = query.list();
		if(!result.isEmpty()){
			return true;
		}
		return false;
	}
	
	
	
}
