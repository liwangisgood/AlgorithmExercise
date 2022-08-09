package cn.ahpu.reflect;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Properties;

/**
 * @author:liwang
 * @date: 2022/4/1 16:14
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class Class {
	public static void main(String[] args) {

		//1.反射获取类字节码
		java.lang.Class<?> student=null;
		try {
			student = java.lang.Class.forName("reflect.Student");//会执行静态代码块
			System.out.println("1._____________________");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//2.反射获取类字节码
		java.lang.Class<Student> studentClass = Student.class;//不会执行静态代码块
		//System.out.println(studentClass==student);//true
		System.out.println("2._____________________");

		//3.反射获取类字节码
		Student student1 = new Student("liwang", 23, "male");//new 对象会执行静态代码块
		System.out.println(student1);
		//System.out.println(student1.getClass() == student);

//		4.获取文件绝对路径,需要在主线程main获取文件的绝对路径 要添加具体的文件名（在src类路径下）
		String path = Thread.currentThread().getContextClassLoader().getResource("a.txt").getPath();//获取类加载的根路径
		System.out.println(path);///E:/JAVA/likouProjects/SimpleExercise/target/classes/a.txt

		String path01 = Thread.currentThread().getContextClassLoader().getResource("").getPath();//获取类加载的根路径
		System.out.println(path01);///E:/JAVA/likouProjects/SimpleExercise/target/classes/

//		String path02 = Thread.currentThread().getContextClassLoader().getResource("/").getPath();//获取类加载的根路径
//		System.out.println(path02);//异常：Exception in thread "main" java.lang.NullPointerException

		final String path03 = Thread.currentThread().getContextClassLoader().getResource("reflect/b.properties").getPath();
		System.out.println(path03);

	}


	//Properties类
	@Test
	public void test01() throws IOException {

		/*
		Properties类继承Hashtable 线程安全的
		* new Properties()既可以 读取的文件 可以是多种格式的 .txt .properties  ,获取元素的方法.getProperties("name") .get("name")
		* .getProperties("name")参数与返回值都是字符串 .get(Object o) 参数与返回值都是Object对象
		* */

		//FileNotFoundException b.properties reflect/b.properties
		//FileReader fr = new FileReader("E:\\JAVA\\likouProjects\\SimpleExercise\\src\\main\\java\\reflect\\b.properties");
		String path = Thread.currentThread().getContextClassLoader().getResource("a.txt").getPath();//获取类加载的根路径
		System.out.println(path);//路径：/E:/JAVA/likouProjects/SimpleExercise/target/classes/a.txt

		FileReader fr = new FileReader(path);

		Properties p = new Properties();

		p.load(fr);
		String name = p.getProperty("name");//
		//Object name = p.get("name");
		//String age = p.getProperty("age");
		final Object age = p.get("age");
		System.out.println(name+" "+age);//liwang 23
	}

	//java中获取文件绝对路径通用方式
	@Test
	public void test02(){
		String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();//获取类加载的根路径
		System.out.println(path);///E:/JAVA/likouProjects/SimpleExercise/target/classes/
		String path01 = this.getClass().getClassLoader().getResource("").getPath();
		System.out.println(path01);///E:/JAVA/likouProjects/SimpleExercise/target/classes/

		String path02 = this.getClass().getResource("/a.txt").getPath();///E:/JAVA/likouProjects/SimpleExercise/target/classes/a.txt
		System.out.println(path02);///不加 /  E:/JAVA/likouProjects/SimpleExercise/target/classes/
		//System.out.println(path02);///加 /  E:/JAVA/likouProjects/SimpleExercise/target/classes/reflect/
	}

	@Test//反射打破 封装 可以在其他类访问其内部私有属性
	public void test03() throws InstantiationException, IllegalAccessException,NullPointerException {//在外面访问私有属性 导致非法访问异常
		java.lang.Class<Student> studentClass = Student.class;
		Student student = studentClass.newInstance();

		Field name = null;
		try {
			name = studentClass.getDeclaredField("name");
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		name.setAccessible(true);//打破封装 可以访问private属性数据
		//java.lang.IllegalAccessException: Class reflect.Class can not access a member of class reflect.Student with modifiers "private"
		name.set(student,"liwang");
		System.out.println(student);


	}

	@Test
	public void test04(){
		String str=String.class.getSimpleName();
		String str1=String.class.getName();
		System.out.println(str+" "+str1);//String java.lang.String
	}

	@Test
	public void test05(){
		Object obj="";
		//没有new 字符串存储在常量池中 obj 与空字符串 位置不同调用的函数不同
		System.out.println(obj.equals(""));//
		System.out.println(obj=="");//比较的是值 也可以是对象的地址(如果有对象的话)
	}

	@Test
	public void test06(){

	}
	@Test
	public void test07(){

	}
	@Test
	public void test08(){

	}
	@Test
	public void test09(){

	}


}

