package cn.zx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.zx.dao.ListInterfaceDao;
import cn.zx.pojo.Article;


public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取要查询的对象
    	ListInterfaceDao dao = new ListInterfaceDao();
        String id = request.getParameter("id");
        System.out.println(id);
        Article article = null;
        if(id != null && !"".equals(id.trim())){
        	//根据id获得article
             article = dao.selectOne(id);
             System.out.println(article);
        }
        String command = request.getParameter("command");
        if(command != null){
        	article.setCommand(command);
        }
		String description = request.getParameter("description");
		if(description != null){
        	article.setDescription(description);
        }
		String content = request.getParameter("content");
		if(content != null){
        	article.setContent(content);
        }
		dao.updateArticleByID(article);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
