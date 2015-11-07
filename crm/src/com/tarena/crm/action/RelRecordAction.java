package com.tarena.crm.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Relrecord;
import com.tarena.crm.entity.Temp;
import com.tarena.crm.service.impl.CustomServiceImpl;
import com.tarena.crm.service.impl.EmpServiceImpl;
import com.tarena.crm.service.impl.RelRecordServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class RelRecordAction {
	@RequestPath(path = "/relRecord/add.do")
	public void add(HttpServletRequest request, 
					HttpServletResponse response) throws Exception{	
		PrintWriter out = response.getWriter();
		Relrecord rec = (Relrecord) EntityUtil.getObject(request, Relrecord.class, "record");
		rec.setTime(new Date());
		String nextTime = request.getParameter("record.nextTime");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		rec.setNextTime(sdf.parse(nextTime));
		try {
			new RelRecordServiceImpl().add(rec);
			out.print("ok");
		} catch (Exception e) {
			out.print("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/relRecord/delete.do")
	public void delete(HttpServletRequest request, 
					HttpServletResponse response)throws Exception{
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		try{
			new RelRecordServiceImpl().delete(Long.parseLong(id));
			out.print("ok");
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
	}
	
	@RequestPath(path = "/relRecord/findAll.do")
	public void findAll(HttpServletRequest request, 
			HttpServletResponse response)throws Exception{
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		try{
			List<Relrecord> rels = new RelRecordServiceImpl().findAll();
			List<Temp> relTrans = new ArrayList<Temp>();
			for(int i=0;i<rels.size();i++){
				final Relrecord rel = rels.get(i);			
				relTrans.add(new Temp(){
					public Long id= rel.getId();
					public String custom = 
							new CustomServiceImpl().findById(rel.getCustom()).getName();
					public String time = 
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rel.getTime());
					public String nextTime = 
							new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rel.getNextTime());
					public String type = rel.getType();
					public String emp = 
							new EmpServiceImpl().findById(rel.getEmp()).getName();
					public String theme = rel.getTheme();
					public String remarks = rel.getRemarks();
				});
			}
			Object json =  JSONArray.toJSON(relTrans);
			out.print(json);
		}catch(Exception e){
			out.println("fail");
		}finally{
			out.close();
		}
	}
}
