package cn.zx.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.zx.db.DBAccess;
import cn.zx.pojo.Article;
import cn.zx.utils.JdbcUtils;

/**
 * 负责数据库的交互,message表
 * @author Administrator
 */
public class ListDao {
	
	public List<Article> getArticleList(String command, String des)  {
		List<Article> list = new ArrayList<Article>();
		SqlSession sqlSession = null;
		try {
			DBAccess ab = new DBAccess();
			sqlSession = ab.getSqlSession();
			Article article = new Article();
			article.setCommand(command);
			article.setDescription(des);
			list = sqlSession.selectList("Article.queryArticleList",article);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return list;
	}
	
	@SuppressWarnings({ "unused" })
	public void deleteById(Integer id)  {
		SqlSession sqlSession = null;
		try {
			DBAccess ab = new DBAccess();
			sqlSession = ab.getSqlSession();
			sqlSession.delete("Article.deleteById",id);
			sqlSession.commit();
		} catch (IOException e) {
			if(sqlSession != null){
				sqlSession.rollback();
			}
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	public void deleteBylist(ArrayList<Integer> ids)  {
		SqlSession sqlSession = null;
		try {
			DBAccess ab = new DBAccess();
			sqlSession = ab.getSqlSession();
			sqlSession.delete("Article.deleteByList",ids);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	public static void main(String[] args) {
		ListDao listDao = new ListDao();
		listDao.getArticleList2("", "");
//		java.sql.Types.和数据库对应的数据类型
		List<Object> list = new ArrayList<>();
		
	}

	/**
	 * jdbc原始版本
	 * @param command
	 * @param des
	 * @return
	 */
	public List<Article> getArticleList2(String command, String des) {
		// 自定义一个集合
		List<Article> list = new ArrayList<Article>();
		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydemo", "root", "123");
			Connection conn = new JdbcUtils().getConn();
			StringBuilder builder = new StringBuilder("SELECT ID,COMMAND,DESCRIPTION,CONTENT FROM message where 1=1");
			ArrayList<String> arr = new ArrayList<>();
			if (command != null && !"".equals(command.trim())) {
				arr.add(command);
				builder.append(" and COMMAND = ?");
			}
			if (des != null && !"".equals(des.trim())) {
				arr.add(des);
				builder.append(" and DESCRIPTION like concat('%',?,'%')");
			}
			//输出sql语句原型
			System.out.println(builder.toString());
			PreparedStatement statement = conn.prepareStatement(builder.toString());
			for (int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i));
				statement.setString(i + 1, arr.get(i));
			}
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Article article = new Article();
				String id = resultSet.getString("ID");
				int aid = Integer.parseInt(id);
				article.setId(aid);
				article.setCommand(resultSet.getString("COMMAND"));
				article.setDescription(resultSet.getString("DESCRIPTION"));
				article.setContent(resultSet.getString("CONTENT"));
				// System.out.println(article.toString());
				list.add(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
