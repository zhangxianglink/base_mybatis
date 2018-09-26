package cn.zx.annotation;

/**
 * 使用自定义注解
 * @author Administrator
 *
 */
@Jack()
public class Person {
	
	@Jack(age=22,name="zx")
	public void boy(){
		
	}
	@Jack(age=23,name="lx")
	public void girl(){
		
	}

}
