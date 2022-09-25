package cn.ahpu.acm.simple;

import org.junit.Test;

/**
 * @author:liwang
 * @date: 2022/3/20 19:11
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 落单的数 {

	public static void main(String[] args) {

	}

	//该数组数 必须都是成对出现的整数对，有且只有一个单着的
	@Test
	public void test01(){
		int[] a={1,2,3,4,1,2,3,4,5};
		int len=a.length;
		int x=0;
		for (int i : a) {
			x=x^i;
		}
		System.out.println(x);//5
	}

	@Test
	public void test02(){
		String string = Integer.toBinaryString(12);
		System.out.println(string);
		int count=0;
		for (int i = 0; i < string.length(); i++) {
//			(int)string.charAt(i)    'A' 转为 65   和Integer.parseInt(String.valueOf(string.charAt(i))) ==1 是不一样的  '1'转为1
			if (Integer.parseInt(String.valueOf(string.charAt(i))) ==1){
				count++;
			}
		}
		System.out.println(count);
	}



}
