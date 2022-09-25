package cn.ahpu.acm.simple;

import java.math.BigInteger;

/**
 * @author:liwang
 * @date: 2022/4/7 13:41
 * @Description:TODO
 * @Algorithm Design：TODO
 */

//辗转相除法详细思路
//https://blog.csdn.net/weixin_43886797/article/details/85569998?ops_request_misc=%257B%2522request%255Fid%2522%253A%2522164931970216782248516638%2522%252C%2522scm%2522%253A%252220140713.130102334.pc%255Fall.%2522%257D&request_id=164931970216782248516638&biz_id=0&utm_medium=distribute.pc_search_result.none-task-blog-2~all~first_rank_ecpm_v1~rank_v31_ecpm-2-85569998.142^v6^pc_search_result_cache,157^v4^new_style&utm_term=%E8%BE%97%E8%BD%AC%E7%9B%B8%E9%99%A4%E6%B3%95&spm=1018.2226.3001.4187
public class 第五题_斐波那契数列最大公约数 {

	public static void main(String[] args) {

		BigInteger a=new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger[] fib=new BigInteger[2030];
		fib[1]=a;
		fib[2]=b;
		for (int i=3;i<fib.length;i++){
			fib[i]=fib[i-2].add(fib[i-1]);
		}
		a=fib[2020];
		b=fib[520];
		BigInteger temp=null;
		int count=0;
		while (!b.equals(BigInteger.ZERO)){
			count++;
			temp=a;
			a=b;
			b=temp.mod(a);
		}
		System.out.println("count:"+count);
		System.out.println(a.toString());
	}
}
