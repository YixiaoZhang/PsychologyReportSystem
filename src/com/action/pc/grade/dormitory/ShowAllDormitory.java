package com.action.pc.grade.dormitory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.javatuples.Triplet;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.DormitoryDao;
import com.dao.StudentDao;
import com.entity.Dormitory;
import com.entity.DormitoryShow;
import com.entity.PageBean;
import com.entity.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ShowAllDormitory class
 * 
 * @author Fitz
 * @date 2018/1/3
 */
public class ShowAllDormitory extends ActionSupport {
	@Autowired
	DormitoryDao dormitorydao;
	PageBean pageBean;
	String page;
	String result1;//刪除
	String result;//添加
	String result2;//更新

	@Override
	public String execute() throws Exception {
		Map session = ActionContext.getContext().getSession();
		int gradeId = (int) session.get("gradeId");
		// 总记录数
		int count = dormitorydao.getCount(gradeId);
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
		List<DormitoryShow> listshow = dormitorydao.queryForPageDormitoryInfo(gradeId, offset, length);
		ActionContext context = ActionContext.getContext();
		context.put("list", listshow);
		npageBean.setPageSize(pageSize);
		npageBean.setCurrentPage(currentPage);
		npageBean.setAllRow(count);
		npageBean.setTotalPage(totalPage);
		npageBean.setList(listshow);
		npageBean.init();
		pageBean=npageBean;
		context.put("pageBean", pageBean);
		return "success";
	}
	
	public String getResult2() {
		return result2;
	}

	public void setResult3(String result2) {
		this.result2 = result2;
	}

	public String getResult1() {
		return result1;
	}

	public void setResult1(String result1) {
		this.result1 = result1;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public DormitoryDao getDormitorydao() {
		return dormitorydao;
	}

	public void setDormitorydao(DormitoryDao dormitorydao) {
		this.dormitorydao = dormitorydao;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}	
}
