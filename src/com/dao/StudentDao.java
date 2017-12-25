package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;
/**
 * StudentDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class StudentDao {
	static Configuration cfg = new Configuration().configure();
	static SessionFactory sf = cfg.buildSessionFactory();
	
	/** 新增学生 */ 
	public boolean addStudent(Student student) {
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
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
		Session s = sf.openSession();
		String hql = "from Student";
		Query query = s.createQuery(hql);
		List<Student> result = query.list();
		return result;
	}
}
