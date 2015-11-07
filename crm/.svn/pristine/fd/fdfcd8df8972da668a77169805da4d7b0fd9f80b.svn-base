package com.tarena.crm.action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComtentFilter implements Filter{
	private FilterConfig config;
	@Override
	public void destroy() {
		System.out.println("销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		String username=(String)session.getAttribute("username");
		String path=request.getRequestURI();
		System.out.println("1"+path);
		if(path.indexOf("/login.do")>-1 ){
			arg2.doFilter(request, response);
		}else{
			if(username!=null){
				arg2.doFilter(request, response);
			}else{
				response.sendRedirect("/crm/login.do");
			}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("初始化");
		this.config=arg0;
	}
}
