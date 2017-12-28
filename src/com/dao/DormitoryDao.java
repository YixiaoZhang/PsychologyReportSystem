package com.dao;

import java.util.ArrayList;
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
import com.entity.RecordShow;

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
	
	/** 寝室长显示列表 */ 
	public List<RecordShow> queryDormitoryReport(String id) {
		List<RecordShow> list = new ArrayList<RecordShow>();
		Session s = sessionFactory.openSession();
		String hql = "select member1Id,member2Id,member3Id,member4Id,member5Id,gradeId,name from Dormitory where leaderId=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Object> result = query.list();
		List<String> stuId = new ArrayList<String>();
		int num = 0;
		String grade = "";
		String dorName = "";
		if(!result.isEmpty()){
			Object[] row = (Object[])result.get(0);
			for(int i=0;i<5;++i){
				if(row[i]!=null)
					stuId.add((String) row[i]);
			}
			grade = Integer.toString((int) row[5]);
			dorName = (String) row[6];
		}
		for(String temp : stuId){
			RecordShow rs = new RecordShow();
			rs.setId(temp);
			rs.setDormitory(dorName);
			hql = "select id from Record where recordedId=? and reportId in (select id from Report where isOpen =1 and gradeId=?)";
			query = s.createQuery(hql);
			query.setString(0, temp);
			query.setString(1, grade);
			result = query.list();
			if(result.isEmpty()){
				rs.setIsFill("0");//未填写
			}else{
				rs.setIsFill("1");//已填写
			}
			hql = "select name from Student where id=?";
			query = s.createQuery(hql);
			query.setString(0, temp);
			List<String> result1 = query.list();
			if(!result1.isEmpty()){
				rs.setName(result1.get(0));
			}
			list.add(rs);
		}
		return list;
	}
	
	
	
	
	
	
}
