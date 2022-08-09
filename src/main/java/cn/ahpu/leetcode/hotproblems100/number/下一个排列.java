package cn.ahpu.leetcode.hotproblems100.number;

import java.util.Arrays;

//https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
public class 下一个排列 {

    static int[] nums = {1, 2, 3};

    public static void main(String[] args) {
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return;
        }
        int i = len - 2, j = len - 1, k = len - 1;
        //找到nums[i]<nums[j]的元素
        for (;i>=0&&nums[i]>=nums[j];){
            i--;
            j--;
        }
        if (i>=0){
            while (nums[i]>=nums[k]){
                k--;
            }
            swap(nums,i,k);
        }
        Arrays.sort(nums,i+1,len);
    }

    private static void swap(int[] nums, int i, int i1) {
        int temp = nums[i];
        nums[i] = nums[i1];
        nums[i1] = temp;
    }
}
