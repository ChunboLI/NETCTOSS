package com.tarena.crm.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.House;
import com.tarena.crm.entity.Housetype;
import com.tarena.crm.service.HouseService;
import com.tarena.crm.service.HouseTypeService;
import com.tarena.crm.service.impl.HouseServiceImpl;
import com.tarena.crm.service.impl.HouseTypeServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class HouseAction {
	@RequestPath(path = "/house/findAll.do")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<House> lists = new ArrayList<House>();
		PrintWriter out = response.getWriter();
		try {
			HouseServiceImpl houseService = new HouseServiceImpl();
			lists = houseService.findAll();
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/house/findByType.do")
	public void findByType(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<House> listHouse = new ArrayList<House>();
		PrintWriter out = response.getWriter();
		try {
			Housetype housetype = (Housetype) EntityUtil
					.getObject(request, Housetype.class, "housetype");
			HouseTypeService houseTypeService = new HouseTypeServiceImpl();
			Housetype housetype2 = houseTypeService.findByType(housetype);
			Integer type = housetype2.getId();
			HouseService houseService = new HouseServiceImpl();
			listHouse = houseService.findByType(type);
			Object json = JSONArray.toJSON(listHouse);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/house/findById.do")
	public void findById(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			HouseService houseService = new HouseServiceImpl();
			House house = houseService.findById(Long.parseLong(id));
			Object json = JSONArray.toJSON(house);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			out.close();
		}
	}
	
	
	@RequestPath(path = "/house/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		boolean flag = false;
		PrintWriter out = response.getWriter();
		try {
			String id = request.getParameter("id");
			HouseServiceImpl houseService = new HouseServiceImpl();
			flag = houseService.delete(Long.parseLong(id));
			Object json = JSONArray.toJSON(flag);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestPath(path = "/house/add.do")
	public void add(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			House entity = (House) EntityUtil.getObject(request, House.class, "house");
			HouseServiceImpl houseService = new HouseServiceImpl();
			House house = houseService.add(entity);
			Object json = JSONArray.toJSON(house);
			out.println(json.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
