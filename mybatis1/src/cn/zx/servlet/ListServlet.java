package cn.zx.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.pojo.Article;
import cn.zx.service.ListService;

/**
 * 处理List.jsp页面的请求
 */
public class ListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ListService service = new ListService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取请求的参数
		String command = request.getParameter("command");
		String des = request.getParameter("description");
        //给页面传值
		request.setAttribute("command", command);
		request.setAttribute("des", des);
		//查询后传值
		List<Article> list = service.getArticleList(command, des);
		request.setAttribute("articleList", list);
		//跳转到页面
		request.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
