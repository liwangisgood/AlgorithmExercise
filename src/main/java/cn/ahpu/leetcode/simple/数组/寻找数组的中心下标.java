package cn.ahpu.leetcode.simple.数组;



/**
 * @author:liwang
 * @date: 2022/2/28 13:18
 * @Description:TODO
 * @Algorithm 索引0，1，2，3……对应的数组元素依次进行，假设为数组的中心元素(左边元素之和等于右边元素之和）然后进行验证
 * https://www.bilibili.com/video/BV1a54y1b74k?p=6
 */
public class 寻找数组的中心下标 {

	public static void main(String[] args) {
		System.out.println(findIndex(new int[]{45,54,2, 1, 3, 4, 1, 2, 3,99}));

	}


	private static int findIndex(int[] ints) {
		int sum = 0,total=0;
		for (int i = 0; i < ints.length; i++) {
			sum += ints[i];
		}
		for (int i = 0; i < ints.length; i++) {
			total+=ints[i];
			if (sum==total){
				return i;
			}
			sum-=ints[i];
		}
		return -1;
	}
}
