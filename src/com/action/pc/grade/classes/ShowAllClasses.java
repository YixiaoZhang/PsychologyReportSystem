package com.action.pc.grade.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.ClassesDao;
import com.dao.StudentDao;
import com.entity.Classes;
import com.entity.ClassesShow;
import com.entity.RecordShow;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowAllClasses class
 * 
 * @author Fitz
 * @date 2018/1/1
 */
public class ShowAllClasses extends ActionSupport {
	@Autowired
	ClassesDao classesdao;
	@Autowired
	StudentDao studentdao;
	@Override
	public String execute() throws Exception {
		List<Classes> list = classesdao.queryClasses();
		List<ClassesShow> listshow=new ArrayList<ClassesShow>();
		Student s;
		for(int i = 0 ; i < list.size() ; i++) {
			ClassesShow cs=new ClassesShow();
			s=studentdao.queryStudent(list.get(i).getAssistantId());
			cs.setAssistantId(list.get(i).getAssistantId());
			cs.setAssistantName(s.getName());
			cs.setName(list.get(i).getName());
			listshow.add(cs);
			}
		ActionContext context = ActionContext.getContext();
		context.put("list", listshow);
		return "success";
	}
}
