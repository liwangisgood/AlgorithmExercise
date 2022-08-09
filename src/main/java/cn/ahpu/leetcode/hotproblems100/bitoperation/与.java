package cn.ahpu.leetcode.hotproblems100.bitoperation;

import org.junit.Test;

//二进制的基本操作
//https://blog.csdn.net/somethingstill/article/details/103784319?ops_request_misc=&request_id=&biz_id=102&utm_term=%E4%BA%8C%E8%BF%9B%E5%88%B6%E6%9C%89%E5%93%AA%E4%BA%9B%E6%93%8D%E4%BD%9C&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-0-103784319.142^v10^control,157^v4^control&spm=1018.2226.3001.4187
public class 与 {



    @Test//位与&  应用：计算二进制整数1的数目 x &= (x - 1);  x分别在奇、偶数时不同
    //异或运算 应用：数组中去除重复的数x^x==0
    //整型数组中多个两个奇数个数的整数元素 其他都为偶数个数的整数元素
    public void test01() {
        int x = 0b01;
        int count = 0;
        while (x != 0) {
            x &= (x - 1);//x为奇数会x=x-1  x为偶数去除x对应二进制最后一个1；无论奇数还是偶数都会去除x二进制的最后一个1 变为0
            count++;
        }
        System.out.println(count);
    }

}
