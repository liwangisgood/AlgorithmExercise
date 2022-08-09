package cn.ahpu.acm.a;

import cn.ahpu.acm.Student;
import org.junit.Test;

import java.util.Calendar;

/**
 * @author:liwang
 * @date: 2022/3/22 8:53
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 世纪末的星期 {

	int age;

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		//使用限制在1970年
		//获取当前年、月、日、时、分、毫秒、秒
		System.out.println(calendar.get(Calendar.YEAR));//2022 当前年
		System.out.println(calendar.get(Calendar.MONTH));//2 表示3月
		System.out.println(calendar.get(Calendar.DATE));//22 获取当前22号
		System.out.println(calendar.get(Calendar.HOUR));//22
		System.out.println(calendar.get(Calendar.MINUTE));//22  获取当前22号
		System.out.println(calendar.get(Calendar.MILLISECOND));//22  获取当前22号
		System.out.println(calendar.get(Calendar.SECOND));//22  获取当前22号

		for (int year = 1999; year < 10000; year += 100) {
			calendar.set(year,11,31);
			if (calendar.get(Calendar.DAY_OF_WEEK)==1){
				System.out.println("year:"+year);


			}
		}
	}

	//星期几都有对应的数值，如周日对应1、周一对应2
	@Test
	public void test01(){
		Calendar calendar = Calendar.getInstance();
		for (int year = 1999; year < 10000; year+=100) {
			calendar.set(year,11,31);
			if (calendar.get(Calendar.DAY_OF_WEEK)==1){
				System.out.println(year);
			}
		}
	}

	//验证protected的功能
	@Test
	public void test02(){
		Student student = new Student();
		student.setAge(23);;
		student.setName("liwang");
		System.out.println(student);
		Student stu1 = new StuTest("qiyi", 22);
		System.out.println(stu1);

		/*Student(name=liwang, age=23)
		Student(name=qiyi, age=22)*/
	}

	@Test
	public void test03(){
		Calendar cal = Calendar.getInstance();
		//                                   1                5                                 5
		System.out.println(cal.get(Calendar.YEAR)+" "+cal.get(Calendar.DATE)+" "+cal.get(Calendar.DAY_OF_MONTH));//2022 19 19
		//System.out.println(cal.get(1)+" "+cal.get(5)+" "+cal.get(5));//运行异常：虽然接受的是常量值 但应该是Calendar类表示的常量

		System.out.println(cal.get(Calendar.AM_PM));//0
	}

}
