package cn.ahpu.acm.simple;

import org.junit.Test;

import java.util.HashSet;

/**
 * @author:liwang
 * @date: 2022/3/20 15:42
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 唯一成对的数 {

	public static void main(String[] args) {

	}


	//	找出重复数组中 重复元素 利用HashSet()
	@Test
	public void test01() {
		int[] a = {1, 2, 3, 2, 9};
		int len=a.length;
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < len; i++) {
			if (set.add(a[i])) {
			}else {
				System.out.println("重复的元素索引："+i);//重复的元素索引：3
			}
		}
	}


	//异或找出数组中重复值 A^A^A=A利用 两次循环   异或重复值最重被保留下来 不重复值经历了两次异或
	//下面测试失败 该方法针对确定数
	@Test
	public void quchongTest() {
		int[] a = {1, 2, 3, 2, 9};
		int len = a.length, x = 0;
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < len; i++) {
			x = x ^ a[i];
		}
		for (int i = 0; i < len; i++) {
			x = x ^ a[i];
		}
		System.out.println("x=" + x);

		long end1 = System.currentTimeMillis();
		System.out.println(" " + (end1 - start1));

//		long start2 = System.currentTimeMillis();
//		for (int i : a) {
//			x=x^i;
//		}
//		long end2 = System.currentTimeMillis();
//		System.out.println(" "+(end2-start2));//毫秒数0
	}

	//位运算 ^异或实现整数 a,b两数互换
	@Test
	public void swap01() {
		int a = 12, b = 80;
		a ^= b; // a 中存放两数互异的点位
		b ^= a; // 取反 b 中不同于 a 的点位，也就是实现了 b = a
		a ^= b; // 取反 a 中不同于 b 的点位，也就是实现了 a = b
		System.out.println(a + " " + b);
	}

	@Test
	public void myTest01() {
		int m = 2, n = 21;
		m = m ^ n;//m中存放m n 不同的位数，通过m异或 n可以得到m
		n = n ^ m;
		m = m ^ n;
		System.out.println(m + " " + n);
	}

	@Test
	public void swap02() {
		int a = 12, b = 80;
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a + " " + b);
	}

}





