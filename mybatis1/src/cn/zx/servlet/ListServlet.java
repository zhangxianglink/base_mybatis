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

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydemo", "root", "123");
			PreparedStatement statement = conn.prepareStatement("SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM message");
			ResultSet resultSet = statement.executeQuery();
			//自定义一个集合
			List<Article> list = new ArrayList<Article>();
			while(resultSet.next()){
				Article article = new Article();
				String id = resultSet.getString("ID");
				int aid = Integer.parseInt(id);
				article.setId(aid);
				article.setCommand(resultSet.getString("COMMAND"));
				article.setDescription(resultSet.getString("DESCRIPTION"));
				article.setContent(resultSet.getString("CONTENT"));
				System.out.println(article.toString());
				list.add(article);
			}
			request.setAttribute("messageList", list);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
