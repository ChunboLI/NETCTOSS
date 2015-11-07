package com.tarena.crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.dao.impl.CustomDaoImpl;
import com.tarena.crm.dao.impl.EmpDaoImpl;
import com.tarena.crm.entity.Custom;
import com.tarena.crm.entity.Emp;
import com.tarena.crm.entity.Temp;
import com.tarena.crm.service.impl.CustomSourceServiceImpl;
import com.tarena.crm.service.impl.CustomStatusServiceImpl;
import com.tarena.crm.service.impl.CustomTypeServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class Allot {
	@RequestPath(path = "/allot1.do")
	public void allot(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			List<Custom> custom = new ArrayList<Custom>();
			List<Custom> customs = new ArrayList<Custom>();
			CustomDaoImpl dao = new CustomDaoImpl();
			custom = dao.findAll();
			for(int i=0;i<custom.size();i++){
				if(custom.get(i).getBelongTo()==0){
					customs.add(custom.get(i));
				}
			}
			List<Temp> customTemps = new ArrayList<Temp>();
			for(final Custom c:customs){
				customTemps.add(new Temp(){
					public Long id = c.getId();
					public String name = c.getName();
					public String job = c.getJob();
					public String status = new CustomStatusServiceImpl().findById(c.getStatus()).getStatus();	//zhuangtai
					public String source = new CustomSourceServiceImpl().findById(c.getSource()).getSource();	//laiyuan
					public String type = new CustomTypeServiceImpl().findById(c.getType()).getType();	//leixing
					public String company = c.getCompany();	
					public String remarks = c.getRemarks();	//beizhu
					public String createDate = c.getCreateDate().toString();	
					public Long belongTo = c.getBelongTo();
				});
			}
			Object json = JSONArray.toJSON(customTemps);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@RequestPath(path = "/allot2.do")
	public void allot2(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			long id = Long.parseLong(request.getParameter("id"));
			long name = Long.parseLong(request.getParameter("name"));
			Emp emp = new Emp();
			EmpDaoImpl empdao = new EmpDaoImpl();
			emp = empdao.findById(name);
			Custom custom = new Custom();
			CustomDaoImpl dao = new CustomDaoImpl();

			custom = dao.findById(id);
			custom.setBelongTo(emp.getId());
			dao.modify(name,id);	
			Object json = JSONArray.toJSON(custom);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}




