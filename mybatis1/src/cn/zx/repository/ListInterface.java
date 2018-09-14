package cn.zx.repository;

import java.util.List;

import cn.zx.pojo.Article;

/**
 * 采用接口式编程解决交互
 * @author Administrator
 *
 */
public interface ListInterface {

	public List<Article> queryArticleList(Article article);
	
	public void insertArticle(Article article);
	
	public Article selectOne(Integer id);
	
	public void updateArticleByID(Article article);
	
}
