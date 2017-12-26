package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Student;
/**
 * StudentDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class StudentDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增学生 */ 
	public boolean addStudent(Student student) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(student);
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
	
	/** 修改学生 */ 
	public boolean updateStudent(Student student) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(student);
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
	
	/** 删除学生 */ 
	public boolean deleteStudent(String id) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			Student student = queryStudent(id);
			s.delete(student);
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
	
	/** 查询一个学生（按id） */ 
	public Student queryStudent(String id) {
		Student student = null;
		Session s = sessionFactory.openSession();
		String hql = "from Student where id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Student> result = query.list();
		if(!result.isEmpty()){
			student = result.get(0);
		}
		return student;
	}
	
	/** 查询全部学生 */ 
	public List<Student> queryStudent() {
		Session s = sessionFactory.openSession();
		String hql = "from Student";
		Query query = s.createQuery(hql);
		List<Student> result = query.list();
		return result;
	}
	
	/** 验证学生密码 */
	public boolean checkStudent(String id, String password) {
		Session s = sessionFactory.openSession();
		String hql = "from Student as u where u.id=? and u.password=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, password);
		List result = query.list();
		if (result.isEmpty()) {
			return false;
		}
		return true;
	}
}
