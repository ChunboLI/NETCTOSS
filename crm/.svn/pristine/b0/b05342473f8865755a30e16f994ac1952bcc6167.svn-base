package com.tarena.crm.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Notice;
import com.tarena.crm.service.impl.NoticeServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.EntityUtil;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class NoticeAction {
	@RequestPath(path = "/notice/findAll.do")
	public void findAll(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Notice> lists = new ArrayList<Notice>();
		PrintWriter out = response.getWriter();
		try {
			NoticeServiceImpl noticeService = new NoticeServiceImpl();
			lists = noticeService.findAll();
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/notice/findByTheme.do")
	public void findByTheme(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<Notice> lists = new ArrayList<Notice>();
		PrintWriter out = response.getWriter();
		try {
			Notice entity = (Notice) EntityUtil.getObject(request, Notice.class, "notice");
			NoticeServiceImpl noticeService = new NoticeServiceImpl();
			lists = noticeService.findByTheme(entity);
			Object json = JSONArray.toJSON(lists);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
	
	@RequestPath(path = "/notice/addNotice.do")
	public void addNotice(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			
			Notice entity = (Notice) EntityUtil.getObject(request, Notice.class, "notice");
			entity.setTime(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			entity.setEndTime(sdf.parse(request.getParameter("notice.endTime")));
			System.out.println(entity.getTime());
			System.out.println(entity.getEndTime());
			NoticeServiceImpl noticeService = new NoticeServiceImpl();
			Notice notice = noticeService.add(entity);
			Object json = JSONArray.toJSON(notice);
			String str = json.toString();
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}
	}
}
