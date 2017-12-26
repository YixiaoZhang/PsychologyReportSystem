package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Dormitory;
import com.entity.Grade;

/**
 * GradeDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class GradeDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增年级 */ 
	public boolean addGrade(Grade grade) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(grade);
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
	
	/** 修改年级 */ 
	public boolean updateGrade(Grade grade) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(grade);
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
	
	/** 删除年级 */ 
	public boolean deleteGrade(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Grade grade = queryGrade(id);
			s.delete(grade);
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
	
	/** 查询一个年级（按id） */ 
	public Grade queryGrade(int id) {
		Grade grade = null;
		Session s = sessionFactory.openSession();
		String hql = "from Grade where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Grade> result = query.list();
		if(!result.isEmpty()){
			grade = result.get(0);
		}
		return grade;
	}
	
	/** 查询全部年级 */ 
	public List<Grade> queryGrade() {
		Session s = sessionFactory.openSession();
		String hql = "from Grade";
		Query query = s.createQuery(hql);
		List<Grade> result = query.list();
		return result;
	}
}
