package cn.ahpu.leetcode.hotproblems100.number;


import java.util.Arrays;

//https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
public class 多数元素 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 2, 1, 1, 1, 1, 4, 5, 6}));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }

}
