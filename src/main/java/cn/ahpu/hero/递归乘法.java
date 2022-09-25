package cn.ahpu.hero;

import org.springframework.stereotype.Component;

/**
 * @author:liwang
 * @date: 2022/3/2 22:02
 * @Description:TODO
 * @Algorithm Design：TODO
 *
 * 俄罗斯农夫算法
 * https://blog.csdn.net/CQ8587/article/details/489190
 */
@Component
public class 递归乘法 {

	public static void main(String[] args) {

		int a = 86, b = 39;
		System.out.println(multiply(a, b));

	}

	public static int multiply(int a, int b) {

		if (a < 1 || b <= 0) {
			return -1;
		}

		int m = 0;

		while (a != 1) {
			if(a%2==0){
				m=a/2*2*b;
			}else {
				m=(a-1)/2*2*b+b;
			}
			a/=2;
			b*=2;
		}
		return m;
	}
}
