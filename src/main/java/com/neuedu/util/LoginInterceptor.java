package com.neuedu.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//ÒÑµÇÂ¼
		HttpSession session = request.getSession();
		if(session.getAttribute("customer2") != null){
			return true;
		}else{
			//Î´µÇÂ¼
			String path = request.getRequestURI();
			if(path.indexOf("login") >= 0){
				//Î´µÇÂ¼ÏëµÇÂ¼
				return true;
			}else{
				request.getRequestDispatcher("/user/login").forward(request, response);
				return false;
			}
		}
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView,HandlerInterceptor handlerInterceptor) throws Exception {
		// TODO Auto-generated method stub
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		handlerInterceptor.postHandle(request, response, handlerInterceptor, modelAndView);
	}
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex,HandlerInterceptor handlerInterceptor)
			throws Exception {
		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		handlerInterceptor.afterCompletion(request, response,handler, ex);
	}

}
