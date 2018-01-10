package com.action.pc.grade.dormitory;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.StudentDao;
import com.entity.Dormitory;
import com.entity.DormitoryShow;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowUpdateDormitory class
 * 
 * @author Fitz
 * @date 2018/1/6
 */
public class ShowUpdateDormitory extends ActionSupport{
	String id;
	@Autowired
	DormitoryDao dormitorydao;
	@Autowired
	StudentDao studentdao;
	@Override
	public String execute() throws Exception {
		DormitoryShow ds= dormitorydao.querySingleDormitory(Integer.parseInt(id));
		ActionContext context = ActionContext.getContext();
		Dormitory dormitory= dormitorydao.queryDormitory(Integer.parseInt(id));
		System.out.println(dormitory.getMember1Id());
		if(dormitory.getMember1Id()!=null)
		{
			Student student1=studentdao.queryStudent(dormitory.getMember1Id());
			ds.setMember1Name(student1.getName());
		}else 
			{
			ds.setMember1Name("无");
			dormitory.setMember1Id("0");
			}
		if(dormitory.getMember2Id()!=null)
		{
			Student student2=studentdao.queryStudent(dormitory.getMember2Id());
			ds.setMember2Name(student2.getName());
		} else {
			ds.setMember2Name("无");
			dormitory.setMember2Id("0");
		}
		
		if(dormitory.getMember3Id()!=null)
		{
			Student student3=studentdao.queryStudent(dormitory.getMember3Id());
			ds.setMember3Name(student3.getName());
		}else {
			ds.setMember3Name("无");
			dormitory.setMember3Id("0");
		}
		if(dormitory.getMember4Id()!=null)
		{
			Student student4=studentdao.queryStudent(dormitory.getMember4Id());
			ds.setMember4Name(student4.getName());
		}else {
			ds.setMember4Name("无");
			dormitory.setMember4Id("0");
		}
		if(dormitory.getMember5Id()!=null)
		{
			System.out.println("213123");
			Student student5=studentdao.queryStudent(dormitory.getMember5Id());
			ds.setMember5Name(student5.getName());
		}{
			ds.setMember5Name("无");
			dormitory.setMember5Id("0");
		}
		context.put("dormitory", ds);
		context.put("dormitoryInfo", dormitory);
		return "success";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}
	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}
}
