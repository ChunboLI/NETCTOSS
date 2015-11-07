package com.tarena.crm.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tarena.crm.service.impl.UserServiceImpl;

import com.tarena.minispringmvc.servlet.Action;

import com.tarena.minispringmvc.servlet.RequestPath;

@Action
public class UserAction {
	@RequestPath(path = "/user/login.do")
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();	
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String password2= new UserServiceImpl().login(username);
			
			HttpSession session=request.getSession();
			if(!password.equals(password2)){
				out.print("fail");
				return;
			}else{
				if("checked".equals(request.getParameter("remember"))){
					Cookie c2=new Cookie("password",password);
					Cookie c=new Cookie("username",username);
					c.setMaxAge(30*24*60*600000);
					c2.setMaxAge(30*24*60*600000);
					c.setPath("/crm/login.do");
					c2.setPath("/crm/login.do");
					response.addCookie(c);
					response.addCookie(c2);
				}
				session.setAttribute("username", username);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

