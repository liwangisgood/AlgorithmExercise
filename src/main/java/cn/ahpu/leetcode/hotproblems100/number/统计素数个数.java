package cn.ahpu.leetcode.hotproblems100.number;

/**
 * @author:liwang
 * @date: 2022/2/27 19:08
 * @Description:TODO
 * @Algorithm 暴力算法
 * https://www.bilibili.com/video/BV1a54y1b74k?p=4
 */
public class 统计素数个数 {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
		int[] primeNumberArray = new int[array.length];

		//素数数组添加索引
		int index = 0;

		//是否为素数状态 根据此结束状态
		boolean flag;

		for (int i = 0; i < array.length; i++) {

			//待验证数为2 素数 直接+1
			if (array[i] == 2||array[i] == 3) {
				primeNumberArray[index++] = array[i];
				continue;
			}

			if (array[i] < 2) {
				continue;
			}

			flag = false;
			for (int j = 2; j <=Math.sqrt(array[i]); j++) {
				if (array[i] % j == 0) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			primeNumberArray[index++] = array[i];
		}

		if (primeNumberArray == null) {
			System.out.println("primeNumberArray数组为空");
		}

		for (int i = 0; i < index; i++) {
			System.out.print(primeNumberArray[i] + " ");
		}
	}
}
