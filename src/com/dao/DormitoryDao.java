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
import com.entity.Dormitory;

/**
 * DormitoryDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class DormitoryDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增寝室 */ 
	public boolean addDormitory(Dormitory dormitory) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(dormitory);
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
	
	/** 修改寝室 */ 
	public boolean updateDormitory(Dormitory dormitory) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(dormitory);
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
	
	/** 删除寝室 */ 
	public boolean deleteDormitory(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Dormitory dormitory = queryDormitory(id);
			s.delete(dormitory);
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
	
	/** 查询一个寝室（按id） */ 
	public Dormitory queryDormitory(int id) {
		Dormitory dormitory = null;
		Session s = sessionFactory.openSession();
		String hql = "from Dormitory where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Dormitory> result = query.list();
		if(!result.isEmpty()){
			dormitory = result.get(0);
		}
		return dormitory;
	}
	
	/** 查询全部寝室 */ 
	public List<Dormitory> queryDormitory() {
		Session s = sessionFactory.openSession();
		String hql = "from Dormitory";
		Query query = s.createQuery(hql);
		List<Dormitory> result = query.list();
		return result;
	}
}
