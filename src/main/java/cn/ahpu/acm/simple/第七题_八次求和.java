package cn.ahpu.acm.simple;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author:liwang
 * @date: 2022/4/7 18:43
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 第七题_八次求和 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger sum=BigInteger.ZERO;
		BigInteger i=BigInteger.ONE;
		BigInteger n1=new BigInteger(""+(n+1));
		for (;!i.equals(n1);i=i.add(BigInteger.ONE)){
			sum  = sum.add(i.pow(8));
		}
		System.out.println(sum.mod(new BigInteger("123456789")));
	}
}
