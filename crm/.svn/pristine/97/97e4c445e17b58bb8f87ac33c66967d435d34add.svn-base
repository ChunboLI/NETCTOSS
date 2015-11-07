package com.tarena.crm.action;

import java.io.PrintWriter;

import javax.servlet.http.*;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.dao.impl.CustomStatusDaoImpl;
import com.tarena.crm.dao.impl.CustomTypeDaoImpl;
import com.tarena.crm.entity.Customstatus;
import com.tarena.crm.entity.Customtype;
import com.tarena.crm.service.impl.CustomStatusServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class CustomStatusAction {
	@RequestPath(path = "/customStatus/add.do")
	public void add(HttpServletRequest request, 
					HttpServletResponse response) throws Exception{
		Customstatus cs = (Customstatus) EntityUtil.getObject(request, Customstatus.class, "entity");
		PrintWriter out = response.getWriter();
		try {
			new CustomStatusServiceImpl().add(cs);
			out.print("ok");
		} catch (Exception e) {
			out.print("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customStatus/delete.do")
	public void delete(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try{
			new CustomStatusServiceImpl().delete(Long.parseLong(id));
			out.print("ok");
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customStatus/findAll.do")
	public void findAll(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try{
			Object json = JSONArray.toJSON(
					new CustomStatusServiceImpl().findAll());
			out.print(json);
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
		
	}
}
