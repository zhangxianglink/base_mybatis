package cn.zx.service;

import java.util.List;



import cn.zx.dao.ListDao;
import cn.zx.pojo.Article;
import cn.zx.pojo.Iconst;

/**
 * 查询相关的业务功能
 */
public class QueryService {
	public List<Article> queryMessageList(String command,String description) {
		ListDao dao = new ListDao();
		return dao.getArticleList(command, description);
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		ListDao dao = new ListDao();
		List<Article> messageList;
		if(Iconst.HELP_COMMAND.equals(command)) {
			messageList = dao.getArticleList(null, null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < messageList.size(); i++) {
				if(i != 0) {
					result.append("<br/>");
				}
				result.append("回复[" + messageList.get(i).getCommand() + "]可以查看" + messageList.get(i).getDescription());
			}
			return result.toString();
		}
		messageList = dao.getArticleList(command, null);
		if(messageList.size() > 0) {
			return messageList.get(0).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
