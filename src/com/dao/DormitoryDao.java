package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.Classes;
import com.entity.ClassesShow;
import com.entity.Dormitory;
import com.entity.DormitoryShow;
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
		} catch (Exception e) {
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
		if (!result.isEmpty()) {
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
		if (!result.isEmpty()) {
			Object[] row = (Object[]) result.get(0);
			for (int i = 0; i < 5; ++i) {
				if (row[i] != null)
					stuId.add((String) row[i]);
			}
			grade = Integer.toString((int) row[5]);
			dorName = (String) row[6];
		}
		for (String temp : stuId) {
			RecordShow rs = new RecordShow();
			rs.setId(temp);
			rs.setDormitory(dorName);
			hql = "select id from Record where recordedId=? and reportId in (select id from Report where isOpen =1 and gradeId=?)";
			query = s.createQuery(hql);
			query.setString(0, temp);
			query.setString(1, grade);
			result = query.list();
			if (result.isEmpty()) {
				rs.setIsFill("0");// 未填写
			} else {
				rs.setIsFill("1");// 已填写
			}
			hql = "select name from Student where id=?";
			query = s.createQuery(hql);
			query.setString(0, temp);
			List<String> result1 = query.list();
			if (!result1.isEmpty()) {
				rs.setName(result1.get(0));
			}
			list.add(rs);
		}
		return list;
	}

	
	/** 查询全部寝室 (按年级id) */
	public List<DormitoryShow> queryDormitoryInfo(int gradeId) {
		Session s = sessionFactory.openSession();
		List<DormitoryShow> result = new ArrayList();
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s"
				+ " where d.gradeId=?" + " and d.leaderId=s.id";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj  = query.list();
		for(int i=0;i<resultobj.size();i++)
		{
			DormitoryShow ds = new DormitoryShow();
			ds.setId((int) resultobj.get(i)[0]);
			ds.setName((String) resultobj.get(i)[1]);
			ds.setLeaderName(((String) resultobj.get(i)[2]));	
			ds.setLeaderId(((String) resultobj.get(i)[3]));	
			result.add(ds);	
		}					
		return result;
	}

	/**得到寝室成员顺序号*/
	public int findMemberNum(String id) {
		// TODO Auto-generated method stub
		//成员顺序号
		int number=-1;
		Session s = sessionFactory.openSession();
		String hql ="select leaderId,member1Id,member2Id,member3Id,member4Id,member5Id"
				+ " from Dormitory where leaderId=? or member1Id=? or member2Id=? "
				+ "or member3Id=? or member4Id=? or member5Id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, id);
		query.setString(2, id);
		query.setString(3, id);
		query.setString(4, id);
		query.setString(5, id);
		List<Object[]> resultobj  = query.list();
		if(resultobj.size()!=0)
		{
			for(number=0;number<5;number++)
			{
				if(resultobj.get(0)[number]!=null)
				{
					if(resultobj.get(0)[number].toString().equals(id))
					{
						return number;
					}
				}			
			}
		}		
		return number;
	}

	/** 删除学生所造寝室id(学生id,该学生属性列)*/
	public void deleteMemberId(String id, String string) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		String hql="update Dormitory set "+string+"=NULL where leaderId=?"+" or member1Id=? or member2Id=? "
				+ "or member3Id=? or member4Id=? or member5Id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, id);
		query.setString(2, id);
		query.setString(3, id);
		query.setString(4, id);
		query.setString(5, id);
		query.executeUpdate();
	}

}
