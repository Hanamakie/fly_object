package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.neuedu.model.domain.TabArea;
import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.service.PostService;
import com.neuedu.model.service.PostServiceImpl;
import com.neuedu.model.service.UserService;
import com.neuedu.model.service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();
	private PostService postService = new PostServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("login".equals(action)){
			login(request,response);
		}else if("logout".equals(action)){
			logout(request,response);
		}else if("testemail".equals(action)){
			testemail(request,response);
		}else if("regist".equals(action)){
			regist(request,response);
		}else if("getpost".equals(action)){
			getpost(request,response);
		}else if("getcollpost".equals(action)){
			getcollpost(request,response);
		}else if("getarea".equals(action)){
			getarea(request,response);
		}else if("updateinfo".equals(action)){
			updateinfo(request,response);
		}else if("testpassword".equals(action)){
			testpassword(request,response);
		}else if("updatepassword".equals(action)){
			updatepassword(request,response);
		}else if("testlogin".equals(action)){
			testlogin(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String s = "";
		TabUser user = new TabUser();
		user.setEmail(email);
		user.setPassword(password);
		TabUser user2 = userService.findUser(user);
		if(user2 != null){
			int postCount = postService.getPostCount(user2);
			int collPostCount = postService.getCollPostCount(user2);
			List<TabPost> list = postService.getpost(user2);
			s = "successlogin";
			HttpSession session = request.getSession();
			session.setAttribute("user", user2);
			session.setAttribute("postCount", postCount);
			session.setAttribute("collPostCount", collPostCount);
			session.setAttribute("list", list);
			session.setAttribute("action", "index");
		}else{
			s = "errorlogin";
		}
		PrintWriter pw = response.getWriter();
		pw.print(s);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath()+"/html/index.jsp");
	}
	private void testemail(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		TabUser user = userService.findUser(email);
		String msg = "";
		if(user == null){
			msg = "usable";
		}else{
			msg = "used";
		}
		PrintWriter pw = response.getWriter();
		pw.print(msg);
	}
	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("password");
		TabUser user = new TabUser();
		user.setEmail(email);
		user.setNickname(nickname);
		user.setPassword(password);
		userService.regist(user);
		response.sendRedirect(request.getContextPath()+"/html/user/login.jsp");
	}
	private void getpost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		TabUser user = (TabUser)session.getAttribute("user");
		List<TabPost> list = postService.getpost(user);
		list.size();
		request.setAttribute("list", list);
		request.setAttribute("action", "index");
		request.getRequestDispatcher("/html/user/index.jsp?navigation=index").forward(request, response);
	}
	private void getcollpost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		TabUser user = (TabUser)session.getAttribute("user");
		List<TabPost> list = postService.getcollpost(user);
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("action", "collection");
		request.getRequestDispatcher("/html/user/index.jsp?navigation=index").forward(request, response);
	}
	private void getarea(HttpServletRequest request, HttpServletResponse response) throws IOException{
		List<TabArea> list = userService.getarea();
		response.setContentType("text/html;charset=utf-8");
		String jsonlist = JSON.toJSONString(list);
		System.out.println(jsonlist);
		PrintWriter pw = response.getWriter();
		pw.print(jsonlist);
	}
	private void updateinfo(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		int sex_id = Integer.parseInt(request.getParameter("sex"));
		int area_id = Integer.parseInt(request.getParameter("area"));
		String sign = request.getParameter("sign");	
		TabUser user = new TabUser();
		HttpSession session = request.getSession();
		user.setId(((TabUser)session.getAttribute("user")).getId());
		user.setEmail(email);
		user.setNickname(nickname);
		user.setSex_id(sex_id);
		TabArea area = new TabArea();
		area.setId(area_id);
		user.setArea(area);
		user.setSign(sign);
		userService.updateinfo(user);
		response.sendRedirect(request.getContextPath()+"/html/user/index.jsp?navigation=index");
	}
	private void testpassword(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		TabUser user = (TabUser)session.getAttribute("user");
		user.setPassword(password);
		TabUser user2 = userService.findUser(user);
		String msg = "";
		if(user2 == null){
			msg = "errorpassword";
		}else{
			msg = "rightpassword";
		}
		PrintWriter pw = response.getWriter();
		pw.print(msg);
	}
	private void updatepassword(HttpServletRequest request, HttpServletResponse response){
		System.out.println("===");
	}
	private void testlogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			response.sendRedirect(request.getContextPath()+"/html/user/login.jsp");
		}else{
			List<TabSpecialColumn> list = postService.getSpecialColumn();
			List<TabFlyKiss> list2 = postService.getFlyKiss();
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.getRequestDispatcher("/html/jie/add.jsp").forward(request, response);
		}
	}
	

}
