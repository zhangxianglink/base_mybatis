package cn.zx.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.pojo.Article;
import cn.zx.service.ListService;


public class DeleteOne extends HttpServlet {
	private static final long serialVersionUID = 1L;



	private ListService service = new ListService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       //设置编码
				request.setCharacterEncoding("utf-8");
				//获取请求的参数
				String id = request.getParameter("id");
				service.deleteById(id);
				//跳转到页面
				request.getRequestDispatcher("/list.action").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
