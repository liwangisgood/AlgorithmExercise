package cn.ahpu.leetcode.simple;

/**
 * @author:liwang
 * @date: 2022/4/5 13:22
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 爬楼梯 {
	public static void main(String[] args) {

		int n = 1;
		System.out.println(climbStairs(n));

	}

	private static int climbStairs(int n) {
		int p = 0, q = 0, r = 1;
		for (int i = 0; i <= n; i++) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}
}
