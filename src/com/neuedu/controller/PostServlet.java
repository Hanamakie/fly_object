package com.neuedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.neuedu.model.domain.TabFlyKiss;
import com.neuedu.model.domain.TabPost;
import com.neuedu.model.domain.TabSpecialColumn;
import com.neuedu.model.domain.TabUser;
import com.neuedu.model.domain.pagedomain;
import com.neuedu.model.domain.postlistdomain;
import com.neuedu.model.service.PostService;
import com.neuedu.model.service.PostServiceImpl;

/**
 * Servlet implementation class PostServlet
 */
@WebServlet("/postServlet")
public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PostService postService = new PostServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("addpost".equals(action)){
			addpost(request,response);
		}else if("getpostlist".equals(action)){
			getpostlist(request,response);
		}else if("detailpost".equals(action)){
			detailpost(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void addpost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		int special_column = Integer.parseInt(request.getParameter("special_column"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int fly_kiss = Integer.parseInt(request.getParameter("fly_kiss"));
		HttpSession session = request.getSession();
		TabUser user = (TabUser)session.getAttribute("user");
		TabPost post = new TabPost();
		TabSpecialColumn s = new TabSpecialColumn();
		s.setId(special_column);
		post.setSpecial_column(s);
		post.setTitle(title);
		post.setContent(content);
		post.setUser(user);
		TabFlyKiss f = new TabFlyKiss();
		f.setId(fly_kiss);
		post.setFly_kiss(f);
		postService.addPost(post);
		response.sendRedirect(request.getContextPath()+"/html/index.jsp");
	}
	private void getpostlist(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String selectcondition = request.getParameter("selectcondition");
		System.out.println(selectcondition);
		int index = Integer.parseInt(request.getParameter("index"));
		int size = Integer.parseInt(request.getParameter("size"));
		pagedomain pagedomain = new pagedomain();
		pagedomain.setIndex(index);
		pagedomain.setSize(size);
		List<TabPost> list = postService.getpostlist(selectcondition,pagedomain);
		postlistdomain pld = new postlistdomain();
		pld.setList(list);
		String postlist = JSON.toJSONString(pld);
		PrintWriter pw = response.getWriter();
		pw.print(postlist);
	}
	private void detailpost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		TabPost post = postService.detailpost(id);
		request.setAttribute("post", post);
		request.getRequestDispatcher("/html/jie/detail.jsp").forward(request, response);
	}

}
