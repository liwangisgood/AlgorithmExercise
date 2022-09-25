package cn.ahpu.bilibili;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author:liwang
 * @date: 2022/4/11 8:11
 * @Description:TODO
 * @Algorithm Design：TODO
 */

//https://www.bilibili.com/video/BV1Dq4y1C7Ar/?spm_id_from=pageDriver
@Component
public class Test01 {
	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<>();
		list.add(new Student("li12", 23));
		list.add(new Student("ai1", 22));
		list.add(new Student("bi1234", 19));
		list.add(new Student("", 19));
		list.add(new Student("i", 19));

		list.add(new Student("", 20));
		Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				int a = o2.getAge() - o1.getAge();
				Integer b=o1.getName().length();
				Integer c=o2.getName().length();
				return a == 0 ? b.compareTo(c) : a;//是比较对象的Integer String
			}
		});
		System.out.println(list);
	}


	@Test
	public void test01(){
		String str=null;
		System.out.println(str.length());//NullPointerException
	}

	@Test
	public void test02(){
		String str=null;
		ArrayList<Student> list = new ArrayList<>();
		System.out.println(list.size());//初始容量为10 但没存放元素 .size()为0
	}

}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Student implements Comparable<Student> {

	private String name;
	private Integer age;


	@Override
	public int compareTo(Student o) {
		int a = this.age - o.age;
		Integer b=this.getName().length();
		Integer c=o.getName().length();

		return a == 0 ? b.compareTo(c) : a;//是比较对象的Integer String
	}
}
