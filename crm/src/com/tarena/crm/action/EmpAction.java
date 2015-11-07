package com.tarena.crm.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Emp;
import com.tarena.crm.service.EmpService;
import com.tarena.crm.service.impl.EmpServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class EmpAction {
	@RequestPath(path = "/emp/findAll.do")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Emp> lists = new ArrayList<Emp>();
		PrintWriter out = response.getWriter();
		try {
			EmpServiceImpl empService = new EmpServiceImpl();
			lists = empService.findAll();
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/emp/findByName.do")
	public void findByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Emp> lists = new ArrayList<Emp>();
		PrintWriter out = response.getWriter();
		try {
			Emp emp = (Emp) EntityUtil.getObject(request, Emp.class, "emp");
			EmpServiceImpl empService = new EmpServiceImpl();
			lists = empService.findByName(emp.getName());
			Object json = JSONArray.toJSON(lists);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestPath(path = "/emp/findById.do")
	public void findById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Emp findemp = new Emp();
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			EmpServiceImpl empService = new EmpServiceImpl();
			findemp = empService.findById(Long.parseLong(id));
			Object json = JSONArray.toJSON(findemp);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestPath(path = "/emp/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		boolean flag = false;
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			EmpServiceImpl empService = new EmpServiceImpl();
			flag = empService.delete(Long.parseLong(id));
			Object json = JSONArray.toJSON(flag);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
