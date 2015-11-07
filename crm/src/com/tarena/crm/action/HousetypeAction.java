package com.tarena.crm.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Housetype;
import com.tarena.crm.service.impl.HouseTypeServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;


@Action
public class HousetypeAction {
	@RequestPath(path = "/housetype/findAll.do")
	public void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Housetype> lists = new ArrayList<Housetype>();
		PrintWriter out = response.getWriter();
		try {
			HouseTypeServiceImpl housetypeService = new HouseTypeServiceImpl();
			lists = housetypeService.findAll();
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/housetype/findByType.do")
	public void findByType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			Housetype entity = (Housetype) EntityUtil.getObject(request, Housetype.class, "housetype");
			HouseTypeServiceImpl housetypeService = new HouseTypeServiceImpl();
			Housetype housetype = housetypeService.findByType(entity);
			Object json = JSONArray.toJSON(housetype);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
