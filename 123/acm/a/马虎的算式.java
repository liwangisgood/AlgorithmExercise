package cn.ahpu.acm.a;

import org.junit.Test;

/**
 * @author:liwang
 * @date: 2022/3/24 0:51
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 马虎的算式 {
	public static void main(String[] args) {
		int count = 0;
		for (int a = 1; a < 10; a++) {
			for (int b = 1; b < 10 && a != b; b++) {//经过调试 这种方式是错误的 当b=1时候 a==b==1会跳出b的循环 a变为2
				for (int c = 1; c < 10 && a != c && b != c; c++) {
					for (int d = 1; d < 10 && a != d && b != d && c != d; d++) {
						for (int e = 1; e < 10 && a != e && b != e && c != e && d != e; e++) {
//							int ab = Integer.parseInt("" + a + b);
//							int cde = Integer.parseInt("" + c + d + e);
//							int adb = Integer.parseInt("" + a + d + b);
//							int ce=Integer.parseInt(""+c+e);

							int ab = a * 10 + b;
							int cde = c * 100 + d * 10 + e;
							int adb = a * 100 + d * 10 + b;
							int ce = c * 10 + e;

							if (ab * cde == adb * ce) {
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println("count:" + count);
	}


	@Test
	public void test01() {
		int a = 12, b = 13;
		System.out.println("" + 1 + 2 + 34);//1234
		System.out.println(1 + 2 + 34 + "");//37
		System.out.println("" + a + b);//1213
		System.out.println(a + b + "");//25
	}

	@Test
	public void test02() {
		int sum = 0, count = 0;
		int ab = 0, cde = 0, adb = 0, ce = 0;
		for (int a = 1; a < 10; a++)
			for (int b = 1; b < 10; b++)
				for (int c = 1; c < 10; c++)
					for (int d = 1; d < 10; d++)
						for (int e = 1; e < 10; e++)
							if (a != b && a != c && a != d && a != e && b != c && b != d && b != e && c != d && c != e && d != e) {
								ab = a * 10 + b;
								cde = c * 100 + d * 10 + e;
								adb = a * 100 + d * 10 + b;
								ce = c * 10 + e;

								if (ab * cde == adb * ce) {
									count++;
								}
							}
//								if ((a * 10 + b) * (c * 100 + d * 10 + e) == (a * 100 + d * 10 + b) * (c * 10 + e)){
//
//								}
//									sum++;
//
		System.out.println(count);

	}

}



