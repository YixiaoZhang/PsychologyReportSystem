package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;


/**
 * InstructorDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class InstructorDao {
	static Configuration cfg = new Configuration().configure();
	static SessionFactory sf = cfg.buildSessionFactory();

	/** 新增辅导员 */
	public boolean addInstructor(Instructor instructor) {
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
		String hql = "from Instructor";
		Query query = s.createQuery(hql);
		List<Instructor> result = query.list();
		return result;
	}

}
