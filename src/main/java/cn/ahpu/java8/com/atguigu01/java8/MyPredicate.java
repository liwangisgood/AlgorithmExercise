package cn.ahpu.java8.com.atguigu01.java8;

@FunctionalInterface
public interface MyPredicate<T> {

	public boolean test(T t);
	
}
