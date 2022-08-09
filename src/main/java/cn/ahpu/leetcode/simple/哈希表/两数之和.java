package cn.ahpu.leetcode.simple.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:liwang
 * @date: 2022/4/3 11:04
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 两数之和 {
	public static void main(String[] args) {
		int[] a=twoSum(new int[]{2, 7,2,11, 15},4);//静态方法不可调用非静态方法
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			if (hashtable.containsKey(target - nums[i])) {
				return new int[]{hashtable.get(target - nums[i]), i};
			}
			hashtable.put(nums[i], i);
		}
		return new int[0];
	}

}
