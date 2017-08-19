package com.zhiyou100.wap.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.wap.model.User;
import com.zhiyou100.wap.service.user.UserService;

public class CustomInterceptor implements HandlerInterceptor{
	@Autowired
	UserService us;
	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse res, Object controler, Exception arg3)
			throws Exception {
		System.out.println(3);
		
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object controler, ModelAndView arg3)
			throws Exception {
		System.out.println(2);
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object controler) throws Exception {
		System.out.println(1);
		String name = req.getParameter("uName");
		String pwd = req.getParameter("uPwd");
				User user = (User)req.getSession().getAttribute("user");
				if(name != null && pwd != null){
					return true;
				}else if(user != null){
					us.selectlogin(user);
					return true;
				}
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				return false;
	}

}
