package cn.zx.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 解析注解
 * @author Administrator
 *
 */
public class OpenJack {
	
	
	public static void main(String[] args) throws ClassNotFoundException{
		//获取类上的注解
		Class<?> person = Class.forName("cn.zx.annotation.Person");
		//判断是否存在注解
		boolean istf = person.isAnnotationPresent(Jack.class);
		//获取查询注解的实例
		if(istf){
			Jack jack = person.getAnnotation(Jack.class);
			System.out.println("类上的注解:"+jack.name()+","+jack.age());
		}
		
		System.out.println("----------------------------------------");
		
		//获取方法上的注解
	    Method[] methods = person.getMethods();
	    for (Method method : methods) {
			boolean bl = method.isAnnotationPresent(Jack.class);
			if(bl){
				Jack jack = method.getAnnotation(Jack.class);
				System.out.println("方法上的注解:"+jack.name()+","+jack.age());
			}
		}
	    System.out.println("----------------------------------------");
	    //获取方法注解2(据我个人而言我不喜欢这个方法)
	    for (Method method : methods) {
			Annotation[] annos = method.getAnnotations();
			for (Annotation anno : annos) {
				if(anno instanceof Jack){
					Jack jack = (Jack) anno;
					System.out.println("方法上的注解:"+jack.name()+","+jack.age());
				}
			}
		}
	}

}
