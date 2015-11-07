package com.tarena.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.crm.dao.impl.CustomCareDaoImpl;
import com.tarena.crm.dao.impl.CustomDaoImpl;
import com.tarena.crm.dao.impl.CustomSourceDaoImpl;
import com.tarena.crm.dao.impl.CustomStatusDaoImpl;
import com.tarena.crm.dao.impl.CustomTypeDaoImpl;
import com.tarena.crm.dao.impl.EmpDaoImpl;
import com.tarena.crm.entity.Custom;
import com.tarena.crm.entity.Customcare;
import com.tarena.crm.entity.Customsource;
import com.tarena.crm.entity.Customstatus;
import com.tarena.crm.entity.Customtype;
import com.tarena.crm.entity.Emp;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class BaseAction {
	@RequestPath(path = "/login.do")
	public String toLogin(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("login.do");
		return "/page/login.jsp";
	}

	@RequestPath(path = "/main.do")
	public String toMain(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		CustomDaoImpl cd = new CustomDaoImpl();
		CustomSourceDaoImpl csd = new CustomSourceDaoImpl();
		CustomTypeDaoImpl ct = new CustomTypeDaoImpl();
		CustomStatusDaoImpl cs = new CustomStatusDaoImpl();
		EmpDaoImpl ed = new EmpDaoImpl();
		CustomCareDaoImpl ccd = new CustomCareDaoImpl();
		
		List<Custom> clist = null;
		List<Customsource> csdlist = null; 
		List<Customtype> ctlist = null;
		List<Customstatus> csslist = null;
		List<Emp> elist = null;
		List<Customcare> cclist = null;
		
		try {
			//客户
			clist = cd.findAll();
			//客户来源
			csdlist = csd.findAll();
			//客户类型
			ctlist = ct.findAll();
			//客户状态
			csslist = cs.findAll();
			//员工
			elist = ed.findAll();
			//客户关怀
			cclist = ccd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//客户
		session.setAttribute("clist", clist);
		//客户来源
		session.setAttribute("csdlist", csdlist);
		//客户类型
		session.setAttribute("ctlist", ctlist);
		//客户状态
		session.setAttribute("csslist", csslist);
		//员工
		session.setAttribute("elist", elist);
		//客户关怀
		session.setAttribute("cclist", cclist);
		
		
		System.out.println(clist);
		System.out.println(csdlist);
		return "/page/main.jsp";
	}
}
