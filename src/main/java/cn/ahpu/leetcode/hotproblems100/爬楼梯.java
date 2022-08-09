package cn.ahpu.leetcode.hotproblems100;

public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs01(5));
        System.out.println(climbStairs02(6));

    }

    private static int climbStairs02(int n) {
        int dp[] =new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    private static int climbStairs01(int i) {
        if (i == 1 || i == 0) {
            return 1;
        } else if (i < 0) {
            return 0;
        }
        return climbStairs01(i - 1) + climbStairs01(i - 2);
    }
}
