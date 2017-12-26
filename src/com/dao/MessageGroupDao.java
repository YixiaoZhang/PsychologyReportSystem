package com.dao;


import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import com.entity.MessageGroup;
/**
 * MessageGroupDao class
 * 
 * @author YiXiao Zhang
 * @date 2017/12/11
 */
public class MessageGroupDao {
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/** 新增消息组 */ 
	public boolean addMessageGroup(MessageGroup messageGroup) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(messageGroup);
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
	
	/** 修改消息组 */ 
	public boolean updateMessageGroup(MessageGroup messageGroup) {
		Session s = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(messageGroup);
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
	
	
	/** 查询一个消息组（按id） */ 
	public MessageGroup queryMessageGroup(int id) {
		MessageGroup messageGroup = null;
		Session s = sessionFactory.openSession();
		String hql = "from MessageGroup where id=?";
		Query query = s.createQuery(hql);
		query.setLong(0, id);
		List<MessageGroup> result = query.list();
		if(!result.isEmpty()){
			messageGroup = result.get(0);
		}
		return messageGroup;
	}
	
	/** 查询全部消息组 */ 
	public List<MessageGroup> queryMessageGroup() {
		Session s = sessionFactory.openSession();
		String hql = "from MessageGroup";
		Query query = s.createQuery(hql);
		List<MessageGroup> result = query.list();
		return result;
	}
}

/*
 * 使用示例
 * 				
 *      //第一次使用这个组
		//用户新建消息组并获取消息对话
		MessageGroupDao dao = new MessageGroupDao();
		MessageGroup messageGroup = new MessageGroup("201526810428",1);
		dao.addMessageGroup(messageGroup);
		List<MessageGroup> list = dao.queryMessageGroup();
		messageGroup = list.get(list.size()-1);
		
		//第二次使用这个组
		//通过id
		messageGroup = dao.queryMessageGroup(7);
		
		//新增消息
		Set<Message> message = new HashSet<Message>();
		message.add(new Message(messageGroup.getId(),"s","2017-12-11 22：14","消息内容"));
		message.add(new Message(messageGroup.getId(),"t","2017-12-11 22：15","消息内容"));
		messageGroup.setMessage(message);
		
		//写入
		dao.updateMessageGroup(messageGroup);
 */
