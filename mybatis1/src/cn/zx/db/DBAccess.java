package cn.zx.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import sun.misc.Resource;

/**
 * 与数据进行交互
 * @author Administrator
 *
 */
public class DBAccess {
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws IOException 
	 */
	public SqlSession getSqlSession() throws IOException{
		//通过配置文件获得信息
		Reader reader = Resources.getResourceAsReader("config/Configuration.xml");
		//通过配置的信息构建一个sqlSession
		SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
		//打开数据库连接
		SqlSession sqlSession = build.openSession();
		return sqlSession;
	}

}
