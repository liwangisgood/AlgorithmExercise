package cn.ahpu.acm.match.ten;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author:liwang
 * @date: 2022/3/19 14:32
 * @Description:TODO
 * @Algorithm Design：TODO
 */

public class MyTest {

	public static void main(String[] args) {

	}

	@Test//测试局部变量数组未初始化 元素值
	public void test01(){//测试方法 'test04()' 不应为 'static'
		int[] sum = new int[20];
		System.out.println(sum);//[I@17d10166
		for (int i : sum) {
			System.out.print(i+" ");//0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
		}
	}

	@Test//测试map.get(unknownKey)返回值
	public void test02(){
		HashMap<Integer, Integer> map = new HashMap<>();
		System.out.println(map.get(12));//null
		System.out.println(map.remove(23));//null 返回移除的数据null
	}

}
