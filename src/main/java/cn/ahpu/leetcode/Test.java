package cn.ahpu.leetcode;

/**
 * @author:liwang
 * @date: 2022/2/27 21:54
 * @Description:TODO
 * @Algorithm 1.方法内部的局部变量 java也会自动给他初始化为0 0.0 false
 * 2.寻找数组中3个以内的最大值 最小值 时候 可以不用去排序 用线性扫描时间复杂度n
 * Array.sort(int[] array) 时间复杂度nlogn
 */
public class Test {

	public static void main(String[] args) {
		int max1 = 0, max2 = 0, max3 = 0;
		int min1 = 0, min2 = 0, min3 = 0;

		int[] array = {1, 2, 3, 44, 5, 6, 7, 8, 9,};
		for (int x : array) {
			//保证max1找到最大值
			if (x > max1) {
				max2 = max1;//max2为max1找到最大值的第二大值，遍历还未结束
				max1 = x;
			}
			//保证max2找到第二大值
			else if (x > max2) {
				max2=x;
			}
		}
		System.out.println(max1 + " " + max2);
	}
}
