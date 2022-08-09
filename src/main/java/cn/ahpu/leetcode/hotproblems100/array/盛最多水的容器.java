package cn.ahpu.leetcode.hotproblems100.array;

//https://leetcode.cn/problems/container-with-most-water/solution/sheng-zui-duo-shui-de-rong-qi-by-leetcode-solution/
public class 盛最多水的容器 {
    static int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

    public static void main(String[] args) {
//        System.out.println(maxArea01(height));
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }

    //超时
    public static int maxArea01(int[] height) {
        int max=0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                int i1 = Math.min(height[i], height[j]) * (j - i);
                if (max<i1){
                    max=i1;
                }
            }
        }
        return max;
    }

}
