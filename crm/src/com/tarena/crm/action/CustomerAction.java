package com.tarena.crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.dao.impl.CustomDaoImpl;
import com.tarena.crm.dao.impl.CustomInfoDaoImpl;
import com.tarena.crm.entity.Custom;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;


@Action
public class CustomerAction {
	
	@RequestPath(path = "/custom/update.do")
	public void update(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		System.out.println("custom/update.do");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		Long id = Long.parseLong(request.getParameter("id"));
		Long belongTo = Long.parseLong(request.getParameter("belongto"));
		String name = request.getParameter("name");
		Integer source =Integer.parseInt(request.getParameter("source"));
		String job = request.getParameter("job");
		Integer type = Integer.parseInt(request.getParameter("type"));
		Integer gender = Integer.parseInt(request.getParameter("gender"));
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String mobliephone = request.getParameter("mobliephone");
		String qq = request.getParameter("qq");
		String address = request.getParameter("address");
		String weibo = request.getParameter("weibo");
		String phone = request.getParameter("phone");
		String msn = request.getParameter("msn");
		String company = request.getParameter("company");
		Long creator = Long.parseLong(request.getParameter("creator"));
		Integer modifier = Integer.parseInt(request.getParameter("modifier"));
		Integer status = Integer.parseInt(request.getParameter("status"));
		
		
		Custom c = new Custom();
		c.setId(id);
		c.setName(name);
		c.setSource(source);
		c.setJob(job);
		c.setType(type);
		c.setGender(gender);
		c.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			c.setBirthday(sdf.parse(birthday));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setMobliePhone(mobliephone);
		c.setQq(qq);
		c.setAddress(address);
		c.setWeibo(weibo);
		c.setPhone(phone);
		c.setMsn(msn);
		c.setCompany(company);
		c.setCreator(creator);
		c.setModifier(modifier);
		c.setStatus(status);
		c.setBelongTo(belongTo);
		
		CustomDaoImpl cdi = new CustomDaoImpl();
		
		boolean flag = cdi.modify(c);
		
		if(flag){
			out.println("修改成功");
			
		}else{
			throw new ServletException("error");
			
		}
		
	}
	
	@RequestPath(path = "/custom/add.do")
	public void add(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		System.out.println("custom/add.do");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		System.out.println(name);
		Integer source =Integer.parseInt(request.getParameter("source"));
		String job = request.getParameter("job");
		Integer type = Integer.parseInt(request.getParameter("type"));
		Integer gender = Integer.parseInt(request.getParameter("gender"));
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String mobliephone = request.getParameter("mobliephone");
		String qq = request.getParameter("qq");
		String address = request.getParameter("address");
		String weibo = request.getParameter("weibo");
		String phone = request.getParameter("phone");
		String msn = request.getParameter("msn");
		String company = request.getParameter("company");
		Long creator = Long.parseLong(request.getParameter("creator"));
		Integer modifier = Integer.parseInt(request.getParameter("modifier"));
		Integer status = Integer.parseInt(request.getParameter("status"));
		String remarks = request.getParameter("remarks");
		Date d = new Date();
		
		Custom c = new Custom();
		c.setName(name);
		System.out.println("cAction"+c.getName());
		c.setSource(source);
		c.setJob(job);
		c.setType(type);
		c.setGender(gender);
		c.setEmail(email);
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		try {
			c.setBirthday(sdf.parse(birthday));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		c.setMobliePhone(mobliephone);
		c.setQq(qq);
		c.setAddress(address);
		c.setWeibo(weibo);
		c.setPhone(phone);
		c.setMsn(msn);
		c.setCompany(company);
		c.setCreator(creator);
		c.setModifier(modifier);
		c.setStatus(status);
		c.setRemarks(remarks);
		c.setCreateDate(d);
		c.setBelongTo(0L);
		
		CustomDaoImpl cdi = new CustomDaoImpl();
		
		Custom c1 = new Custom();
		
		try {
			c1 = cdi.add(c);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(c1 != null){
			out.println("添加成功");
			
		}else{
			throw new ServletException("error");
			
		}
	}
	
	@RequestPath(path = "/custom/findAll.do")
	public void findAllCustom (HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		CustomInfoDaoImpl cd = new CustomInfoDaoImpl();	
		try{
			Object json =  JSONArray.toJSON(cd.findAll());
			out.println(json);
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
		
	}
	
	@RequestPath(path = "/custom/findOne.do")
	public void findOne(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		CustomDaoImpl cd = new CustomDaoImpl();	
		String name = request.getParameter("name");
		try{
			Object json =  JSONArray.toJSON(cd.findByName(name));
			out.println(json);
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
		
	}
	
	
	@RequestPath(path = "/custom/see.do")
	public void seeOne(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		HttpSession session = request.getSession();
		Long id = Long.parseLong(request.getParameter("id"));
		CustomDaoImpl cd= new CustomDaoImpl();	
		Custom c = new Custom();
		
		c = cd.findById(id);
		System.out.println(c);
		session.setAttribute("custom", c);
	}
	
	@RequestPath(path = "/custom/delete.do")
	public void deleteOne(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Long id = Long.parseLong(request.getParameter("id"));
		CustomDaoImpl cd= new CustomDaoImpl();	
		if(cd.delete(id)){
			out.println("删除成功！");
		}
		
	}
	
	
	
	
	
	
	
}
