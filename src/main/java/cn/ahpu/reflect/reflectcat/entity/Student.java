package cn.ahpu.reflect.reflectcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:liwang
 * @date: 2022/4/1 16:21
 * @Description:TODO
 * @Algorithm Design：TODO
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private String name;
	private Integer age;
	private String sex;//构造方法不能加静态 在@Data注解中

	//实例代码块和静态代码块不一样

	//实例代码块 可以引用 含有与不含有static的属性 方法 cause:static优先于非static先加载 确保可以访问得到
	{
		name = "123";//.class文件内 变量赋值给成员变量
		sex="123";
		System.out.println("Student的非静态代码块执行……");//.class文件内 方法放在构造器首部
		System.out.println(getName());
	}

	//静态代码块 只能引用含有static的变量 方法 cause:static优先于非static先加载 确保可以访问得到
	static {
		//sex="男";//静态代码块中不加非静态代码块
		System.out.println("Student类静态代码块执行……");
		//getName();//异常
		//System.out.println(getSex());//异常
	}




}
