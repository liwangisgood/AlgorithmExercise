package cn.ahpu.leetcode.hotproblems100.array;

public class 最大子数组和 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,-9};
        System.out.println(getSum(nums));
    }

    private static int getSum(int[] nums) {

        if (nums.length == 0 || nums == null) {
            return 0;
        }

        if (nums.length==1){
            return nums[0];
        }
        /*for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < len + i && j < nums.length; j++) {
                    subSum += nums[j];
                }
                if (subSum > sum) {
                    sum = subSum;
                }
                subSum = 0;
            }
        }*/
        int sum = Integer.MIN_VALUE, subSum = 0;
        for (int i=0;i<nums.length;i++){
            subSum=0;
            for (int j=i;j<nums.length;j++){
                subSum+=nums[j];
                if (subSum>sum){
                    sum=subSum;
                }
            }
        }

        return sum;
    }
}
