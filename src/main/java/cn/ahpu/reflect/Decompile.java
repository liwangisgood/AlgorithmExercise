package cn.ahpu.reflect;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;

/**
 * @author:liwang
 * @date: 2022/4/2 14:52
 * @Description:TODO
 * @Algorithm 进行反编译：利用java.lang.reflect.* java.lang.Class 利用反射访问字节码 操作字节码 得到java源码字符串
 */
public class Decompile {

	public static void main(String[] args) throws IOException,ClassNotFoundException {

		//1.获取a.txt类路径下文件内容   IO流+.properties
		String path = Thread.currentThread().getContextClassLoader().getResource("a.txt").getPath();//获取类加载的根路径
		FileReader fr = new FileReader(path);//  /E:/JAVA/likouProjects/SimpleExercise/target/classes/a.txt
		Properties p = new Properties();
		p.load(fr);
		String className = p.getProperty("class");
		fr.close();

		//2.直接以流的形式返回 这些种方式可以跨平台访问相对路径资源 IO流+.properties 加入反射中使用字节码
		/*ResourceBundle b = ResourceBundle.getBundle("b");
		InputStream is= Thread.currentThread().getContextClassLoader().getResourceAsStream("a.txt");//直接以字节流的形式返回
		Properties p = new Properties();
		p.load(is);
		String className = p.getProperty("class");
		is.close();*/

		//3.ResourceBundle.getBundle("文件名不要加后缀.properties") 只针对配置文件 使用*.properties
		/*ResourceBundle b1 = ResourceBundle.getBundle("b");
		String className = b1.getString("class");*/


		System.out.println(className);
		java.lang.Class<?> aClass = java.lang.Class.forName(className);//java.lang.Class<Student> aClass = Student.class;

		StringBuilder sb = new StringBuilder();
		Field[] fs =aClass.getDeclaredFields();
		sb.append(Modifier.toString(aClass.getModifiers())+" class "+aClass.getSimpleName()+" {\n");
		for (Field f : fs) {
			sb.append("\t"+Modifier.toString(f.getModifiers())+" "+f.getType().getSimpleName()+" "+f.getName()+";\n");
		}

		sb.append("\n");
		Method[] methods = aClass.getMethods();

		for (Method method : methods) {
			sb.append("\t"+Modifier.toString(method.getModifiers())+" "+method.getReturnType().getSimpleName()+" "+method.getName()+"(");
			java.lang.Class<?>[] parameterTypes = method.getParameterTypes();
			int length=parameterTypes.length;
			for (java.lang.Class<?> parameterType : parameterTypes) {
					sb.append(parameterType.getSimpleName());
					sb.append(",");
			}
			if (length!=0){
				sb.deleteCharAt(sb.length()-1);
			}

			sb.append("){}\n");
		}

		sb.append("}\n");

		System.out.println(sb.toString());

	}
}
