package com.approval.test.system.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("deprecation")
public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String empCode = (String)session.getAttribute("empCode");
		String userPw = (String)session.getAttribute("userPw");
		System.out.println(request.getRequestURI());
		if(empCode == null && userPw == null) {
			response.sendRedirect("/loginForm.html");
			System.out.println("로그인이 필요함");
			return false;
		}else {
			return true;
		}
	}
}
