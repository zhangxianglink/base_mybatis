package cn.zx.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.dao.ListInterfaceDao;
import cn.zx.pojo.Article;


public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command);
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		ListInterfaceDao dao = new ListInterfaceDao();
		Article article = new Article();
		article.setCommand(command);
		article.setContent(content);
		article.setDescription(description);
		dao.save(article);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
