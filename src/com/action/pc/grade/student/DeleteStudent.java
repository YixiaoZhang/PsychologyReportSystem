package com.action.pc.grade.student;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.StudentDao;
import com.opensymphony.xwork2.ActionSupport;

/**
 * DeleteStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class DeleteStudent extends ActionSupport {
	@Autowired
	StudentDao studentdao;
	@Autowired
	StudentDao classesdao;
	@Autowired
	DormitoryDao dormitorydao;
	String id;

	@Override
	public String execute() throws Exception {
		System.out.println(id);
		// 判断该学生是否为心理委员
		if (classesdao.isAssistant(id)) {
			// 删除班级表中该学生的id

		}
		// 得到寝室成员顺序号
		int number = dormitorydao.findMemberNum(id);
		// 删除寝室中该学生的id
		switch (number) {
		case 0:
			//寝室长
			dormitorydao.deleteMemberId(id,"leaderId");
			break;
		case 1:
			//成员一
			dormitorydao.deleteMemberId(id,"member1Id");
			break;
		case 2:
			//成员二
			dormitorydao.deleteMemberId(id,"member2Id");
			break;
		case 3:
			//成员三
			dormitorydao.deleteMemberId(id,"member3Id");
			break;
		case 4:
			//成员四
			dormitorydao.deleteMemberId(id,"member4Id");
			break;
		case 5:
			//成员五
			dormitorydao.deleteMemberId(id,"member5Id");
			break;
			default:
				//找不到寝室成员
				break;
				
		}
		// 删除学生中该学生的id
		studentdao.deletStudent(id);
		return "success";

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
