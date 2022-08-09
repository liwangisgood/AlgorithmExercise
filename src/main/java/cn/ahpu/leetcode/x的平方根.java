package cn.ahpu.leetcode;

/**
 * @author:liwang
 * @date: 2022/2/28 13:39
 * @Description:TODO
 * @Algorithm 暴力解决算法复杂度：O(根号x)   二分查找算法复杂度：O(logN)
 * https://www.bilibili.com/video/BV1a54y1b74k?p=7
 */
public class x的平方根 {
	public static void main(String[] args) {

		//二分查找求x的平方根
		//System.out.println(binarySearch(25));

		//牛顿迭代法求x的平方根:x的两个因子 的平均数更加趋近于均值
		System.out.println();

	}

	private static int binarySearch(int x) {
		int index = -1, l = 0, r = x;
		if (x < 0) {
			return index;
		}

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (mid * mid <= x) {
				index = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return index;
	}
}
