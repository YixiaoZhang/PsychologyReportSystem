package com.action.pc.grade.student;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.dao.StudentDao;
import com.entity.PageBean;
import com.entity.StudentShow;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowAllStudent class
 * 
 * @author Fitz
 * @date 2018/1/4
 */
public class ShowAllStudent extends ActionSupport {
	@Autowired
	StudentDao studentdao;
	PageBean pageBean;
	String page;
	/** 分页查询 */
	@Override
	public String execute() throws Exception {	
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		// 总记录数
		int count = studentdao.getCount(gradeId);
		// 单页记录总条数
		int pageSize = 10;
		// 总页数
		int totalPage = PageBean.countTotalPage(pageSize, count);
		// 当前页开始记录
		int offset = PageBean.countOffset(pageSize, Integer.parseInt(page));
		// 每页记录数
		int length = pageSize;
		// 当前页数
		// 把分页信息保存到Bean	
		PageBean npageBean=new PageBean();
		int currentPage = PageBean.countCurrentPage(Integer.parseInt(page));
		List<StudentShow> listshow = studentdao.queryForPageStudentInfo(gradeId, offset, length);
		System.out.println(pageSize);
		npageBean.setPageSize(pageSize);
		npageBean.setCurrentPage(currentPage);
		npageBean.setAllRow(count);
		npageBean.setTotalPage(totalPage);
		npageBean.setList(listshow);
		npageBean.init();
		pageBean=npageBean;
		ActionContext context = ActionContext.getContext();
		context.put("pageBean", pageBean);
		return "success";
	}
	public StudentDao getStudentdao() {
		return studentdao;
	}
	public void setStudentdao(StudentDao studentdao) {
		this.studentdao = studentdao;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

}
