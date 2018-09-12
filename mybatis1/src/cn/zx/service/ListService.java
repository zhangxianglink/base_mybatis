package cn.zx.service;

import java.util.ArrayList;
import java.util.List;

import cn.zx.dao.ListDao;
import cn.zx.pojo.Article;

public class ListService {
	
	private ListDao dao = new ListDao();
	
	public List<Article> getArticleList(String command, String des) {
		return dao.getArticleList(command, des);
	}

	public void deleteById(String id)  {
		dao.deleteById(Integer.valueOf(id));
	}
	
	public void deleteByList(String[] ids)  {
		ArrayList<Integer> list = new ArrayList<>();
		for (String string : ids) {
			Integer valueOf = Integer.valueOf(string);
			list.add(valueOf);
		}
		dao.deleteBylist(list);
	}
}
