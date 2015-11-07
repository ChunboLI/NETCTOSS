package com.tarena.crm.action;

import java.util.List;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.dao.BaseDao;
import com.tarena.crm.dao.impl.CustomTypeDaoImpl;
import com.tarena.crm.entity.Customtype;
import com.tarena.crm.service.impl.CustomTypeServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class CustomTypeAction {
	@RequestPath(path = "/customType/add.do")
	public void add(HttpServletRequest request, 
					HttpServletResponse response) throws Exception{
		String type = (String) request.getParameter("type");
		PrintWriter out = response.getWriter();
		try {
			Object flag = new CustomTypeServiceImpl().add(new Customtype(type));
			if(flag == null){
				out.print("fail");
				return;
			}
			out.print("ok");
		} catch (Exception e) {
			out.print("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customType/delete.do")
	public void delete(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try{
			new CustomTypeServiceImpl().delete(Long.parseLong(id));
			out.print("ok");
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/customType/findAll.do")
	public void findAll(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try{
			List all = new CustomTypeServiceImpl().findAll();
			if(all == null){
				out.println("fail");
				return ;
			}
			Object json =  JSONArray.toJSON(all);
			out.print(json);
		}catch(Exception e){
			out.println("error");
		}finally{
			out.close();
		}
	}
	
}
