package cn.ahpu.leetcode.hotproblems100.bitoperation;


import org.junit.Test;

//>>> n 无符号右移n位 左边补0
public class 无符号右移动 {

    @Test
    public void test01() {
        System.out.println(-4 >>> 1);//2147483646 不要对负数使用无符号右移
    }
}
