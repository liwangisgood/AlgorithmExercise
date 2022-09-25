package cn.ahpu.acm.simple;

/**
 * @author:liwang
 * @date: 2022/3/20 20:32
 * @Description:TODO
 * @Algorithm Design：TODO
 */

//利用二进制判断奇偶数  a&1=0 a为偶数   a&1=1 a为奇数
//判断一个整数是否为2的整数次方

public class 是否是2的整数次方 {
	public static void main(String[] args) {
		int a=0;

//		如果一个整数是2的整数次方，那么它在二进制表示下一定只包含一个“1”。
		if ((a&(a-1))==0){
			System.out.println("该数为的二进制为2的整数次方");
		}else {
			System.out.println("该数的二进制不为2的整数次方");
		}
	}
}
