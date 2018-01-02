package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Classes;
import com.entity.Instructor;

/**
 * ClassesDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class ClassesDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增班级 */ 
	public boolean addClasses(Classes classes) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(classes);
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
	
	/** 修改班级 */ 
	public boolean updateClasses(Classes classes) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(classes);
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
	
	/** 删除班级 */ 
	public boolean deleteClasses(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Classes classes = queryClasses(id);
			s.delete(classes);
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
	
	/** 查询一个班级（按id） */ 
	public Classes queryClasses(int id) {
		Classes classes = null;
		Session s = sessionFactory.openSession();
		String hql = "from Classes where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Classes> result = query.list();
		if(!result.isEmpty()){
			classes = result.get(0);
		}
		return classes;
	}
	
	/** 查询全部班级 */ 
	public List<Classes> queryClasses() {
		Session s = sessionFactory.openSession();
		String hql = "from Classes";
		Query query = s.createQuery(hql);
		List<Classes> result = query.list();
		return result;
	}
	
	/** 查询全部班级 (按辅导员id)*/ 
	public List<Classes> queryClassesbyInstructorId(int instructorId) {
		Session s = sessionFactory.openSession();
		String hql = "from Classes where gradeId in (select gradeId from Instructor where id=?)";
		Query query = s.createQuery(hql);
		query.setLong(0, instructorId);
		List<Classes> result = query.list();
		return result;
	}
}
