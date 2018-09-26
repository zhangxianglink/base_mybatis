package cn.zx.annotation.test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotation {
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Filter f1 = new Filter();
		f1.setId(12); //查询id为12的选手
		
		Filter f2 = new Filter();
		f2.setName("jack"); //模糊查询名字为jack的嫌疑人
		
		Filter f3 = new Filter();
		f3.setNickname("aka.kk,103@qq.com,104@126.com");//查询网名为其中之一的用户
		
		String sql1 = query(f1);
		System.out.println(sql1);
		String sql2 = query(f2);
		System.out.println(sql2);
		String sql3 = query(f3);
		System.out.println(sql3);
		
	}

	private static String query(Filter f) throws NoSuchMethodException, SecurityException {
	//拼接的字符串
      StringBuilder sb = new StringBuilder();
    //获取class对象
      Class<? extends Filter> c = f.getClass();
    //获取table的名字
      boolean b = c.isAnnotationPresent(Table.class);
      if(!b){
    	  return "无表可查";
      }
      Table table = c.getAnnotation(Table.class);
      String tableName = table.value();
      sb.append("SELECT * FROM ").append(tableName).append(" WHERE 1=1 ");
      //遍历所有的字段,有值就进行添加
      	Field[] fields = c.getDeclaredFields();
      	for (Field field : fields) {
			//获取字段名
      		boolean d = field.isAnnotationPresent(Column.class);
      		if(!d){
      			continue;
      		}
      		Column column = field.getAnnotation(Column.class);
      		String columnName = column.value();
      		//获取传入的字段值
      		Object columnValue = null;
      		String MethodName = "get"+columnName.substring(0,1).toUpperCase()+columnName.substring(1);
      		Method method = c.getMethod(MethodName);
      		try {
				 columnValue =  method.invoke(f);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      		//添加字符串
      		if(columnValue == null || (columnValue instanceof Integer && (Integer)columnValue == 0)){
      			continue;
      		}
      		sb.append("and").append(columnName);
      		if(columnValue instanceof String){
      		sb.append("=").append("'").append(columnValue).append("'");
      		}else{
      		sb.append("=").append(columnValue);
      		}
      		}
		return sb.toString();
	}

}
