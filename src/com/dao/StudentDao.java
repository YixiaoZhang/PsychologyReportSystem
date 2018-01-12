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

import com.entity.Student;
import com.entity.StudentShow;

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

	/** 寝室长查询填写情况 */
	public String[] queryDormitoryReport(String id) {
		String[] a = { "100", "已填", "未填" };
		Session s = sessionFactory.openSession();
		String hql = "select name from Report where isOpen =1 and gradeId in (select gradeId from Dormitory where leaderId=?)";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
			a[0] = result.get(0);
		}
		hql = "select count(*) from Record where fillId = ? and reportId in (select id from Report where isOpen =1 and gradeId in (select gradeId from Dormitory where leaderId=?))";
		query = s.createQuery(hql);
		query.setString(0, id);
		query.setString(1, id);
		List<Long> result1 = query.list();
		if (!result.isEmpty()) {
			a[1] = Long.toString(result1.get(0));
		}
		hql = "select member1Id,member2Id,member3Id,member4Id,member5Id from Dormitory where leaderId=?";
		query = s.createQuery(hql);
		query.setString(0, id);
		List<Object> result3 = query.list();
		int num = 0;
		if (!result.isEmpty()) {
			Object[] row = (Object[]) result3.get(0);
			for (int i = 0; i < 5; ++i) {
				if (row[i] != null)
					num++;
			}
			a[2] = (num - Integer.parseInt(a[1])) + "";
		}
		return a;
	}

	/** 心理委员查询填写情况 */
	public String[] queryClassReport(String id) {
		String[] a = { "100", "已填", "未填" };
		Session s = sessionFactory.openSession();
		String hql = "select name from Classes where id in (select id from Classes where assistantId=?)";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
			a[0] = result.get(0);
		}
		hql = "select count(*) from Record where reportId in (select id from Report where isOpen =1)and (recordedId in (select id from Student where classes in (select classes from Student where id=?))))";
		query = s.createQuery(hql);
		query.setString(0, id);
		List<Long> result1 = query.list();
		if (!result.isEmpty()) {
			a[1] = Long.toString(result1.get(0));
		}

		hql = "select count(*) from Student where classes in (select classes from Student where id=?)";
		query = s.createQuery(hql);
		query.setString(0, id);
		result1 = query.list();
		if (!result.isEmpty()) {
			a[2] = (Integer.parseInt(Long.toString(result1.get(0))) - Integer.parseInt(a[1])) + "";
		}

		return a;
	}

	public boolean isDormitory(String id) {
		Session s = sessionFactory.openSession();
		String hql = "select id from Dormitory where leaderId=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean isAssistant(String id) {
		Session s = sessionFactory.openSession();
		String hql = "select id from Classes where assistantId=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<String> result = query.list();
		if (!result.isEmpty()) {
			return true;
		}
		return false;
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

	/** 删除学生(学生学号) 
	 * @return */
	public boolean deletStudent(String id) {
		Session s = sessionFactory.openSession();
		String hql = "delete from Student where id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		try {
			query.executeUpdate();
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
		
	}

	/** 修改学生 */
	public boolean updateStudent(Student student) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(student);
			System.out.println(student.getPassword());
			System.out.println(student.getName());
			System.out.println(student.getSex());
			System.out.println(student.getClasses());
			System.out.println(student.getId());
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

	/** 查询一个学生（按id） */
	public Student queryStudent(String id) {
		Student student = null;
		Session s = sessionFactory.openSession();
		String hql = "from Student where id=?";
		Query query = s.createQuery(hql);
		query.setString(0, id);
		List<Student> result = query.list();
		if (!result.isEmpty()) {
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
	/** 查询全部学生 (按班级)*/
	public List<Student> queryStudentbyClasses(int id) {
		Session s = sessionFactory.openSession();
		String hql = "from Student where classesId=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
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

	/** 查询所有学生信息(按年级id) */
	public List<StudentShow> queryStudentInfo(int gradeId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<StudentShow> result = new ArrayList();
		String hql = "SELECT s.id,s.name,s.sex,c.name\r\n" + "From Student s,Classes c\r\n"
				+ "where c.gradeId=? and s.classes=c.id";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			StudentShow ss = new StudentShow();
			ss.setId((String) resultobj.get(i)[0]);
			ss.setName((String) resultobj.get(i)[1]);
			ss.setSex(((String) resultobj.get(i)[2]));
			ss.setClassesName(((String) resultobj.get(i)[3]));
			result.add(ss);
		}

		return result;
	}
	

	/** 查询所有学生信息(按年级id) 分页查询*/
	public List<StudentShow> queryForPageStudentInfo(int gradeId,int offset, int length) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<StudentShow> result = new ArrayList();
		String hql = "SELECT s.id,s.name,s.sex,c.name\r\n" + "From Student s,Classes c\r\n"
				+ "where c.gradeId=? and s.classes=c.id";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			StudentShow ss = new StudentShow();
			ss.setId((String) resultobj.get(i)[0]);
			ss.setName((String) resultobj.get(i)[1]);
			ss.setSex(((String) resultobj.get(i)[2]));
			ss.setClassesName(((String) resultobj.get(i)[3]));
			result.add(ss);
		}

		return result;
	}
	/** 查询所有学生信息(按年级id) 总记录条数*/
	public int getCount(int gradeId) 
	{
		Session s = sessionFactory.openSession();
		String hql = "SELECT count(*)\r\n" + "From Student s,Classes c\r\n"
				+ "where c.gradeId=? and s.classes=c.id";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		return Integer.parseInt(query.list().get(0).toString());
	}
	
	/** 按姓名查询 */
	public List<StudentShow> queryStudentByName(String input, int gradeId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<StudentShow> result = new ArrayList();
		String hql = "SELECT s.id,s.name,s.sex,c.name\r\n" + "From Student s,Classes c\r\n"
				+ "where c.gradeId=? and s.classes=c.id and s.name LIKE '%" + input + "%'";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			StudentShow ss = new StudentShow();
			ss.setId((String) resultobj.get(i)[0]);
			ss.setName((String) resultobj.get(i)[1]);
			ss.setSex(((String) resultobj.get(i)[2]));
			ss.setClassesName(((String) resultobj.get(i)[3]));
			result.add(ss);
		}

		return result;
	}

	/** 按学号查询 */
	public List<StudentShow> queryStudentById(String input, int gradeId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		List<StudentShow> result = new ArrayList();
		String hql = "SELECT s.id,s.name,s.sex,c.name\r\n" + "From Student s,Classes c\r\n"
				+ "where c.gradeId=? and s.classes=c.id and s.id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, gradeId);
		query.setString(1, input);
		List<Object[]> resultobj = query.list();
		for (int i = 0; i < resultobj.size(); i++) {
			StudentShow ss = new StudentShow();
			ss.setId((String) resultobj.get(i)[0]);
			ss.setName((String) resultobj.get(i)[1]);
			ss.setSex(((String) resultobj.get(i)[2]));
			ss.setClassesName(((String) resultobj.get(i)[3]));
			result.add(ss);
		}

		return result;
	}

	/** 查询单个学生信息(按学生id) */
	public StudentShow querySingleStudentInfo(String studentId) {
		// TODO Auto-generated method stub
		Session s = sessionFactory.openSession();
		String hql = "SELECT s.id,s.name,s.sex,c.name\r\n" + "From Student s,Classes c\r\n"
				+ "where s.id=? and s.classes=c.id";
		Query query = s.createQuery(hql);
		query.setString(0,studentId);
		List<Object[]> resultobj = query.list();
		StudentShow ss = new StudentShow();
		ss.setId((String) resultobj.get(0)[0]);
		ss.setName((String) resultobj.get(0)[1]);
		ss.setSex(((String) resultobj.get(0)[2]));
		ss.setClassesName(((String) resultobj.get(0)[3]));
		return ss;
	}

}
