package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Instructor;


/**
 * InstructorDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class InstructorDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增辅导员 */
	public boolean addInstructor(Instructor instructor) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(instructor);
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

	/** 修改辅导员 */
	public boolean updateInstructor(Instructor instructor) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(instructor);
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

	/** 删除辅导员 */
	public boolean deleteInstructor(int id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Instructor instructor = queryInstructor(id);
			s.delete(instructor);
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

	/** 查询一个辅导员（按id） */
	public Instructor queryInstructor(int id) {
		Instructor instructor = null;
		Session s = sessionFactory.openSession();
		String hql = "from Instructor where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Instructor> result = query.list();
		if (!result.isEmpty()) {
			instructor = result.get(0);
		}
		return instructor;
	}

	/** 查询全部辅导员 */
	public List<Instructor> queryInstructor() {
		Session s = sessionFactory.openSession();
		String hql = "from Instructor";
		Query query = s.createQuery(hql);
		List<Instructor> result = query.list();
		return result;
	}
		
	/** 验证辅导员密码 */
	public boolean checkInstructorDao(String name, String password) {
		Session s = sessionFactory.openSession();
		String hql = "from Instructor as u where u.name=? and u.password=?";
		Query query = s.createQuery(hql);
		query.setString(0, name);
		query.setString(1, password);
		List result = query.list();
		if (result.isEmpty()) {
			return false;
		}
		return true;
	}

	/** 获取辅导员id(按姓名)*/
    public int 	getInstructorId(String name)
    {   
    	Instructor instructor=null;
    	int id = 0;
		Session s = sessionFactory.openSession();
		String hql = "from Instructor where name=?";
		Query query = s.createQuery(hql);
		query.setString(0, name);
		List<Instructor> result = query.list();
		if (!result.isEmpty()) {
			instructor = result.get(0);
			id=instructor.getId();
		}
		return id;
    }
    
    /** 获取年级id(按辅导员id)*/
    public int 	getGradeId(int instructorId)
    {   
    	Instructor instructor=null;
    	int id = 0;
		Session s = sessionFactory.openSession();
		String hql = "from Instructor where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, instructorId);
		List<Instructor> result = query.list();
		if (!result.isEmpty()) {
			instructor = result.get(0);
			id=instructor.getId();
		}
		return id;
    }
}
