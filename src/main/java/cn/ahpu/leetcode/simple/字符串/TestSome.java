package cn.ahpu.leetcode.simple.字符串;

import org.junit.Test;

/**
 * @author:liwang
 * @date: 2022/3/13 0:54
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class TestSome {

	static int count=0;

	public static void main(String[] args) {
		System.out.println("main");

		//TestSome.main(args);栈溢出错误

	}

	@Test
	public void test01() {
		System.out.println("----------test04--------------");
		System.out.println((int) (sqrts(990, 21029293)));
		System.out.println(count);

	}

	public static double sqrts(double i, int x) {
		count++;
		double res = (i + x / i) / 2;
		if (res == i) {
			return i;
		} else {
			return sqrts(res, x);
		}
	}

}


