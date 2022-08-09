package cn.ahpu.acm.a;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author:liwang
 * @date: 2022/3/25 14:21
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 黄金连分数 {
	public static void main(String[] args) {

	}

	@Test
	public void test01(){
		int count=0;
		BigDecimal bg = new BigDecimal("1");
		//System.out.println(bg.toPlainString().substring(0, 103)); // [0, 102] 共103个字符 字符串分割（截取）
		String str="0.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911375";//102
		for (int i = 0; i < str.length(); i++) {
			count++;
		}
		System.out.println(count);
		System.out.println(str.length());
	}

	@Test
	public void test02(){//@Test不可以经过键盘输入数据
//		BigDecimal bd = new BigDecimal("1");
//		System.out.println(bd);//1
//		BigDecimal bd1 = new BigDecimal(BigInteger.ONE,100);
//		System.out.println(bd1);//1E-100

		BigDecimal bg2 = new BigDecimal("1.23456789");
		System.out.println(bg2);
		//System.out.println(bg2.doubleValue());//byteValue shortValue 6中转换为整数与浮点数
		System.out.println(bg2.setScale(2));

	}

	@Test
	public void test03(){
		BigDecimal bd = new BigDecimal(BigInteger.TEN,10);
		System.out.println(bd);//1E-10

		BigDecimal num1 = new BigDecimal("1");

        //System.out.println("坑点写法1："+num1.divide(new BigDecimal("3")));// java.lang.ArithmeticException 非终止小数扩展；没有精确可表示的十进制结果
//        System.out.println("坑点写法2："+num1.divide(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_DOWN));// java.lang.ArithmeticException 非终止小数扩展；没有精确可表示的十进制结果

		//准确除法运算
		System.out.println("正确写法："+num1.divide(new BigDecimal("3"), 2, BigDecimal.ROUND_HALF_DOWN));//0.33
	}



}
