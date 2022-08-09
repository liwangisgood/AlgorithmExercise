package cn.ahpu.leetcode.hotproblems100.bitoperation;

import org.junit.Test;

//>> n 右移n位，左边补0
//二进制移位 要区别于正负数 ，负数要适时补全1 0位
public class 右移 {

    @Test
    public void test01() {
        //切记，不要从补码直接读取数值 补码实际参与数据运算，原码参与用户读取识别，如十进制

        System.out.println(-6 >> 1);//-3 原理： -6补码全体右移一位 左边补充符号位1
        System.out.println(-6 >> 2);//-2 同理类似 此式子不可整除

        System.out.println(-5 >> 1);//-3
        System.out.println(-5 >> 2);//-2
    }
}
