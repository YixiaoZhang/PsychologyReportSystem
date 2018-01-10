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
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s" + " where d.gradeId=?"
				+ " and d.leaderId=s.id";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			DormitoryShow ds = new DormitoryShow();
			ds.setId((int) resultobj.get(i)[0]);
			ds.setName((String) resultobj.get(i)[1]);
			ds.setLeaderName(((String) resultobj.get(i)[2]));
			ds.setLeaderId(((String) resultobj.get(i)[3]));
			ds.setName2(ds.getName().replace('#', 'a'));
			result.add(ds);
		}
		return result;
	}

	/** 得到寝室成员顺序号 */
	public int findMemberNum(String id) {
		// TODO Auto-generated method stub
		// 成员顺序号
		int number = -1;
		Session s = sessionFactory.openSession();
		String hql = "select leaderId,member1Id,member2Id,member3Id,member4Id,member5Id"
				+ " from Dormitory where leaderId=? or member1Id=? or member2Id=? "
				+ "or member3Id=? or member4Id=? or member5Id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, id);
		query.setString(2, id);
		query.setString(3, id);
		query.setString(4, id);
		query.setString(5, id);
		List<Object[]> resultobj = query.list();
		if (resultobj.size() != 0) {
			for (number = 0; number < 5; number++) {
				if (resultobj.get(0)[number] != null) {
					if (resultobj.get(0)[number].toString().equals(id)) {
						return number;
					}
				}
			}
		}
		return number;
	}

	/** 删除学生所造寝室id(学生id,该学生属性列) */
	public void deleteMemberId(String id, String string) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		String hql = "update Dormitory set " + string + "=NULL where leaderId=?" + " or member1Id=? or member2Id=? "
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

	/** 查询寝室 (按寝室名) */
	public List<DormitoryShow> queryDormitoryInfoByName(int gradeId, String input) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<DormitoryShow> result = new ArrayList();
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s" + " where d.gradeId=?"
				+ " and d.leaderId=s.id and d.name LIKE '%" + input + "%'";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			DormitoryShow ds = new DormitoryShow();
			ds.setId((int) resultobj.get(i)[0]);
			ds.setName((String) resultobj.get(i)[1]);
			ds.setLeaderName(((String) resultobj.get(i)[2]));
			ds.setLeaderId(((String) resultobj.get(i)[3]));
			result.add(ds);
		}
		return result;
	}

	/** 查询寝室 (按成员姓名) */
	public List<DormitoryShow> queryDormitoryInfoByStudentName(int gradeId, String input) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<DormitoryShow> result = new ArrayList();
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s" + " where d.gradeId=?"
				+ " and d.leaderId=s.id and s.name LIKE '%" + input + "%'";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			DormitoryShow ds = new DormitoryShow();
			ds.setId((int) resultobj.get(i)[0]);
			ds.setName((String) resultobj.get(i)[1]);
			ds.setLeaderName(((String) resultobj.get(i)[2]));
			ds.setLeaderId(((String) resultobj.get(i)[3]));
			result.add(ds);
		}
		return result;
	}

	/** 查询寝室 (按成员学号) */
	public List<DormitoryShow> queryDormitoryInfoByStudentId(int gradeId, String input) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<DormitoryShow> result = new ArrayList();
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s" + " where d.gradeId=?"
				+ " and d.leaderId=s.id and s.id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		query.setString(1, input);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			DormitoryShow ds = new DormitoryShow();
			ds.setId((int) resultobj.get(i)[0]);
			ds.setName((String) resultobj.get(i)[1]);
			ds.setLeaderName(((String) resultobj.get(i)[2]));
			ds.setLeaderId(((String) resultobj.get(i)[3]));
			result.add(ds);
		}
		return result;
	}

	/** 查询寝成员所有id(按成员学号) */
	public List<String> findMemberId(int id) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<String> result = new ArrayList();
		String hql = "SELECT d.leaderId,d.member1Id,d.member2Id,d.member3Id,d.member4Id,d.member5Id "
				+ "FROM Dormitory d" + " where d.id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < 6; i++) {
			if (resultobj.get(0)[i] != null) {
				String studentid = resultobj.get(0)[i].toString();
				System.out.println(studentid);
				result.add(studentid);
			}
		}
		return result;
	}

	/** 查询单个寝室 (按寝室id) */
	public DormitoryShow querySingleDormitory(int id) {
		Session s = sessionFactory.openSession();
		DormitoryShow ds = new DormitoryShow();
		String hql = "SELECT d.id,d.name,s.name,s.id " + "FROM Dormitory d,Student s" + " where d.id=?"
				+ " and d.leaderId=s.id";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<Object[]> resultobj = query.list();
		ds.setId((int) resultobj.get(0)[0]);
		ds.setName((String) resultobj.get(0)[1]);
		ds.setLeaderName(((String) resultobj.get(0)[2]));
		ds.setLeaderId(((String) resultobj.get(0)[3]));
		ds.setName2(ds.getName().replace('#', 'a'));
		return ds;
	}

	public void updateDormitoryInfo(Dormitory dormitory) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		String hql = "UPDATE Dormitory SET name=?,leaderId=?";
	
		if (!dormitory.getMember1Id().equals("0")) {
			System.out.println("213");
			System.out.println(dormitory.getMember1Id());
			hql += ",member1Id='" + dormitory.getMember1Id()+"'";
		} else
			hql += ",member1Id=NULL";
		
		if (!dormitory.getMember2Id().equals("0")) {
			hql += ",member2Id='" + dormitory.getMember2Id()+"'";
		} else
			hql += ",member2Id=NULL";
		
		if (!dormitory.getMember3Id().equals("0")) {
			hql += ",member3Id='" + dormitory.getMember3Id()+"'";
		} else
			hql += ",member3Id=NULL";
		
		if (!dormitory.getMember4Id().equals("0")) {
			hql += ",member4Id='" + dormitory.getMember4Id()+"'";
		} else
			hql += ",member4Id=NULL";
		
		if (!dormitory.getMember5Id().equals("0")) {
			hql += ",member5Id='" + dormitory.getMember5Id()+"'";
		} else
			hql += ",member5Id=NULL";
		hql += " where id=?";
		Query query = s.createQuery(hql);
		query.setString(0, dormitory.getName());
		query.setString(1, dormitory.getLeaderId());		
		query.setLong(2, dormitory.getId());
		query.executeUpdate();
	}

	public void updateDormitoryMemberInfo(int id, String[] memberId) {
		// TODO Auto-generated method stub
		int i = 0;
		Session s = sessionFactory.openSession();
		String hql = "UPDATE Dormitory SET leaderId=?,member1Id=?,member2Id=?,"
				+ "member3Id=?,member4Id=?,member5Id=? where id=?";
		Query query = s.createQuery(hql);
		System.out.println(memberId.length);
		for (; i < memberId.length; i++) {
			query.setString(i, memberId[i]);
			System.out.println(memberId[i]);
		}
		System.out.println(i);
		for (; i < 6; i++)
			query.setParameter(i, null);
		query.setLong(6, id);
		query.executeUpdate();
	}
}
