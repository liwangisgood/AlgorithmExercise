package cn.ahpu.leetcode.hotproblems100.number;

import org.junit.Test;

//https://leetcode.cn/problems/reverse-integer/solution/tu-jie-7-zheng-shu-fan-zhuan-by-wang_ni_ma/
public class 整数反转 {

    static int x = -2147483648;

    public static void main(String[] args) {

//        System.out.println(reverse01(x));


    }

    public static int reverse(int x) {
        int res = 0;
        int maxValue = Integer.MAX_VALUE / 10;
        int minValue = Integer.MIN_VALUE / 10;

        while (x != 0) {
            int temp = x % 10;

            if (res > maxValue || (res == maxValue && temp > 7)) {
                return 0;
            }
            if (res<minValue||(res==minValue&&temp<-8)){
                return 0;
            }
            res=res*10+temp;
            x/=10;
        }
        return res;
    }

    //不满足条件
    public static int reverse01(int x) {
        long x1 = x;
        if (x < 0) x1 = -x1;
        StringBuilder sb = new StringBuilder(x1 + "").reverse();
        x1 = Long.parseLong(String.valueOf(sb));
        if (x < 0) x1 = -x1;
        if (x1 > Integer.MAX_VALUE || x1 < Integer.MIN_VALUE) return 0;
        return (int) x1;
    }

    @Test
    public void test01() {
        StringBuilder sb = new StringBuilder("200");
        sb.reverse();
        Integer i = Integer.valueOf(sb.toString());
        System.out.println(i);
    }

    @Test
    public void test02() {
//        System.out.println(-x);
//        System.out.println(111111111111111111111111111111111111111);
        System.out.println(Integer.MAX_VALUE);// 2147483647
        System.out.println(Integer.MIN_VALUE);//-2147483648
    }

}
