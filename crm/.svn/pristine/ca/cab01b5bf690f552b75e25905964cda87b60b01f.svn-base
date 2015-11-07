package com.tarena.crm.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Customsource;
import com.tarena.crm.service.impl.CustomSourceServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class CustomSourceAction {
	@RequestPath(path = "/customSource/add.do")
	public void add(HttpServletRequest request, 
					HttpServletResponse response) throws Exception{
		String source = (String) request.getParameter("source");
		PrintWriter out = response.getWriter();
		try {
			new CustomSourceServiceImpl().add(
					new Customsource(source));
			out.print("ok");
		} catch (Exception e) {
			out.print("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customSource/delete.do")
	public void delete(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try{
			new CustomSourceServiceImpl().delete(
					Long.parseLong(id));
			out.print("ok");
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customSource/findAll.do")
	public void findAll(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try{
			Object json = JSONArray.toJSON(
					new CustomSourceServiceImpl().findAll());
			out.print(json);
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
		
	}
}
