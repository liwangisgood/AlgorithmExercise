package cn.ahpu.leetcode.hotproblems100;

//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-by-leetcode-/

public class 买卖股票的最佳时机 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    public static int maxProfit(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {//保证一定是按照最低价格买入 才会执行
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {//保证一定是按照最大利润 才会执行
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

}
