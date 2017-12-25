package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Classes;
import com.entity.Instructor;

/**
 * ClassesDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class ClassesDao {
	static Configuration cfg = new Configuration().configure();
	static SessionFactory sf = cfg.buildSessionFactory();
	
	/** 新增班级 */ 
	public boolean addClasses(Classes classes) {
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
		String hql = "from Classes";
		Query query = s.createQuery(hql);
		List<Classes> result = query.list();
		return result;
	}
}
