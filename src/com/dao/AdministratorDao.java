package com.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Administrator;

/**
 * AdministratorDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class AdministratorDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/** 验证管理员密码 */
	public boolean checkAdministrator(String name, String password) {
		Session s = sessionFactory.openSession();
		String hql = "from Administrator as u where u.name=? and u.password=?";
		Query query = s.createQuery(hql);
		query.setString(0, name);
		query.setString(1, password);
		List result = query.list();
		if (result.isEmpty()) {
			return false;
		}
		return true;
	}

	/** 新增管理员 */ 
	public boolean addAdministrator(Administrator administrator) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(administrator);
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

}
