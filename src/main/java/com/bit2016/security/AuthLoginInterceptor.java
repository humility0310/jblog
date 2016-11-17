package com.bit2016.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bit2016.jblog.service.MembersService;
import com.bit2016.jblog.vo.MembersVo;

public class AuthLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// Web Application Context 받아오기
		ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());

		// Container 안에 있는 UserService Bean(객체) 받아오기
		MembersService membersService = ac.getBean(MembersService.class);

		// 데이터베이스에서 해당 MembersVo 받아오기
		MembersVo membersVo = membersService.login(id, password);

		// 이메일과 패쓰워드가 일치하지 않는 경우
		if (membersVo == null) {
			response.sendRedirect(request.getContextPath() + "/login?result=fail");
			return false;
		}

		// 인증 처리
		HttpSession session = request.getSession(true);
		session.setAttribute("authUser", membersVo);
		response.sendRedirect(request.getContextPath());

		return false;
	}

}
