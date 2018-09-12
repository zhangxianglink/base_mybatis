package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.service.ListService;

/**
 * Servlet implementation class DeleteAll
 */
public class DeleteAll extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ListService service = new ListService();
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
		request.setCharacterEncoding("utf-8");
		//获取请求的参数
		String[] ids = request.getParameterValues("id");
		service.deleteByList(ids);
		//跳转到页面
		request.getRequestDispatcher("/list.action").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
