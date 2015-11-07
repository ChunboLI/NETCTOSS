package com.tarena.crm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Department;
import com.tarena.crm.service.DepartmentService;
import com.tarena.crm.service.impl.DepartmentServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class DepartmentAction {
	@RequestPath(path = "/department/findAll.do")
	public void findAll(HttpServletRequest request,HttpServletResponse response)throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Department> lists = new ArrayList<Department>();
		PrintWriter out = response.getWriter();
		try {
			DepartmentService departService = new DepartmentServiceImpl();
			lists = departService.findAll();
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/department/findByName.do")
	public void findByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Department> lists = new ArrayList<Department>();
		PrintWriter out = response.getWriter();
		try {
			Department department = (Department) EntityUtil
					.getObject(request, Department.class, "department");
			DepartmentService departmentService = new DepartmentServiceImpl();
			lists = departmentService.findByName(department);
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
