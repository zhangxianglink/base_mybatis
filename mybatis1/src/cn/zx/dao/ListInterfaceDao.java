package cn.zx.dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import cn.zx.db.DBAccess;
import cn.zx.pojo.Article;
import cn.zx.repository.ListInterface;

public class ListInterfaceDao {
	
	public void save(Article article){
		SqlSession sqlSession =null;
		try {
			//获取链接
			DBAccess db = new DBAccess();
			sqlSession = db.getSqlSession();
			//调用接口
			ListInterface mapper = sqlSession.getMapper(ListInterface.class);
			mapper.insertArticle(article);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}
	
	public Article selectOne(String id){
		SqlSession sqlSession =null;
		Article article = null;
		try {
			//获取链接
			DBAccess db = new DBAccess();
			sqlSession = db.getSqlSession();
			//调用接口
			ListInterface mapper = sqlSession.getMapper(ListInterface.class);
			article = mapper.selectOne(Integer.parseInt(id));
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
		return article;
	}
	
	public void updateArticleByID(Article article){
		SqlSession sqlSession =null;
		try {
			//获取链接
			DBAccess db = new DBAccess();
			sqlSession = db.getSqlSession();
			//调用接口
			ListInterface mapper = sqlSession.getMapper(ListInterface.class);
			mapper.updateArticleByID(article);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null){
				sqlSession.close();
			}
		}
	}

}
