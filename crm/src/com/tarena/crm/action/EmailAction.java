package com.tarena.crm.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONArray;
import com.tarena.crm.entity.Email;
import com.tarena.crm.entity.Emp;
import com.tarena.crm.entity.Temp;
import com.tarena.crm.service.impl.EmailServiceImpl;
import com.tarena.crm.service.impl.EmpServiceImpl;
import com.tarena.minispringmvc.servlet.Action;
import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class EmailAction {
	/**
	 * 发送邮件
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestPath(path="/sendMail.do")
	public String sendMail(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("hahaha");
		Email email = new Email();
		long receiver = Long.parseLong(request.getParameter("receiver"));
		long sender = Long.parseLong(request.getParameter("sender"));
		String theme = request.getParameter("theme");
		String content = request.getParameter("content");
		System.out.println(receiver+" "+theme+" "+" "+content);
		email.setContent(content);
		email.setTheme(theme);
		email.setReceiver(receiver);
		email.setSender(sender);
		EmailServiceImpl esi = new EmailServiceImpl();
		try {
			esi.sendEmail(email);
			String str = "添加成功";
			out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.close();
		return null;
	}
	/**
	 * 异步获取员工
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestPath(path="/getReceiver.do")
	public void getReceiver(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		EmpServiceImpl esi = new EmpServiceImpl();
		List<Emp> emps = esi.findAll();
		Object json = JSONArray.toJSON(emps);
		System.out.println("111");
		String jsonStr = json.toString();
		System.out.println(jsonStr);
		out.println(jsonStr);
		out.close();
	}
	/**
	 * 收件箱
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestPath(path="/getInbox.do")
	public void getInbox(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		/*Thread t = new Thread();
		t.sleep(2000);*/
		System.out.println("getInbox");
		long receiver = Long.parseLong(request.getParameter("receiver"));
		EmailServiceImpl esi = new EmailServiceImpl();
		List<Email> emails = esi.inbox(receiver, true);
		Object json = JSONArray.toJSON(idToString(emails));
		String jsonStr = json.toString();
		//System.out.println(jsonStr);
		out.println(jsonStr);
		out.close();
	}
	/**
	 * 收件箱搜索
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestPath(path="/inboxSearch.do")
	public void inboxSearch(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String keyWords = request.getParameter("keyWords");//搜索关键字
		String condition = request.getParameter("condition");//根据什么搜索
		long receiver = Long.parseLong(request.getParameter("receiver"));
		EmailServiceImpl esi = new EmailServiceImpl();
		List<Email> emails = null;
		if("sender".equals(condition)){
			emails = esi.inboxBySender(keyWords, receiver, true);
			System.out.println("sender");
		}else if("theme".equals(condition)){
			emails = esi.inboxByTheme(keyWords, receiver, true);
		}else if("content".equals(condition)){
			emails = esi.inboxByContent(keyWords, receiver, true);
		}
		System.out.println(emails);
		Object json = JSONArray.toJSON(idToString(emails));
		String jsonStr = json.toString();
		//System.out.println(jsonStr);
		out.println(jsonStr);
		out.close();
	}
	
	/**
	 * 发件箱
	 */
	@RequestPath(path="/getOutbox.do")
	public void getOutbox(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		long sender = Long.parseLong(request.getParameter("sender"));
		EmailServiceImpl esi = new EmailServiceImpl();
		List<Email> emails = esi.outbox(sender, true);
		Object json = JSONArray.toJSON(idToString(emails));
		String jsonStr = json.toString();
		out.println(jsonStr);
		out.close();
	}
	/**
	 * 发件箱和草稿箱搜索
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void outboxSearch(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String keyWords = request.getParameter("keyWords");//搜索关键字
		String condition = request.getParameter("condition");//根据什么搜索
		long sender = Long.parseLong(request.getParameter("sender"));
		EmailServiceImpl esi = new EmailServiceImpl();
		List<Email> emails = null;
		if("sender".equals(condition)){
			emails = esi.outboxByReceiver(keyWords, sender, true);
			System.out.println("sender");
		}else if("theme".equals(condition)){
			emails = esi.outboxTheme(keyWords, sender, true);
		}else if("content".equals(condition)){
			emails = esi.outboxContent(keyWords, sender, true);
		}
		System.out.println(emails);
		Object json = JSONArray.toJSON(idToString(emails));
		String jsonStr = json.toString();
		//System.out.println(jsonStr);
		out.println(jsonStr);
		out.close();
		
	}
	
	/**
	 * 草稿箱
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestPath(path="/getDraftbox.do")
	public void getDraftbox(HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		long sender = Long.parseLong(request.getParameter("sender"));
		EmailServiceImpl esi = new EmailServiceImpl();
		List<Email> emails = esi.outbox(sender, false);
		Object json = JSONArray.toJSON(idToString(emails));
		String jsonStr = json.toString();
		out.print(jsonStr);
		out.close();
	}
	/**
	 * 发送草稿 -把状态修改为1
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestPath(path="/sendDraft.do")
	public void sendDraft(HttpServletRequest request, 
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		long emailId = Long.parseLong(request.getParameter("emailId"));
		EmailServiceImpl esi = new EmailServiceImpl();
		esi.sendDraft(emailId);
		String str = "发送成功";
		out.println(str);
		out.close();
	}
	
	
	/**
	 * 封装一个类：建立匿名内部类实现链表查询到发件人和收件人的姓名
	 * @param emails
	 * @return emailsTrans
	 * @throws Exception
	 */
	private List idToString(List<Email> emails) throws Exception{
		List<Temp> emailTrans = new ArrayList<Temp>();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(final Email e : emails){
			System.out.println(e);
			emailTrans.add(new Temp(){
				public Long id = e.getId();
				public String sender = new EmpServiceImpl().findById(e.getSender()).getName();
				public String receiver = new EmpServiceImpl().findById(e.getReceiver()).getName();
				public String theme = e.getTheme();
				public String content = e.getContent();
				//public Date time = e.getTime();
				public String time = (sdf.format(e.getTime())).toString();
				public Boolean status = e.getStatus();	
			});
		}
		return emailTrans;
	}
}
