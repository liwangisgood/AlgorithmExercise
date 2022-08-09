package cn.ahpu.leetcode.hotproblems100.bitoperation;

import cn.ahpu.leetcode.hotproblems100.array.Util;
import org.junit.Test;

public class 异或 {


    //各进制常量表示：https://blog.csdn.net/mqdxiaoxiao/article/details/89290694?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522165318719616781432910379%2522%252C%2522scm%2522%253A%252220140713.130102334..%2522%257D&request_id=165318719616781432910379&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~baidu_landing_v2~default-1-89290694-null-null.142^v10^control,157^v4^control&utm_term=%E4%BA%8C%E8%BF%9B%E5%88%B6%E5%B8%B8%E9%87%8F%E8%A1%A8%E7%A4%BA&spm=1018.2226.3001.4187
    //0b11、-0B10  0xA、-0XB  077、-067 标识2、8、16进制 大小写一样
/*
    System.out.println(012);//10
    System.out.println(-012);//-10

    System.out.println(0b11);//3
    System.out.println(-0B10);//-2

    System.out.println(0xA);//10
    System.out.println(-0XB);//-11
    */




    @Test
    //一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数
    public void test02() {
        int[] arr = Util.generateRandomIntArray(7, 2, 9);

        int eO = 0, eOhasOne = 0;
        for (int curNum : arr) {
            eO ^= curNum;
        }
        int rightOne = eO & (~eO + 1);//得到e0的二进制最右边为1的(且该二进制只含有一个1，如e0=1100  rightOne=0100
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {//
                eOhasOne ^= cur;
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

}
