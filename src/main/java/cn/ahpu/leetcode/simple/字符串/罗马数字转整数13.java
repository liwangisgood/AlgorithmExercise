package cn.ahpu.leetcode.simple.字符串;

/**
 * @author:liwang
 * @date: 2022/3/12 1:43
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 罗马数字转整数13 {

	public static void main(String[] args) {

		System.out.println(romanToInt("MCMXCIV"));

	}

	private static int romanToInt(String s) {

		int len = s.length(),m=0,n=0,sum=0;
		if (s == null || len == 0) {
			System.out.println("1");
			return -1;
		} else if (len == 1) {
			return toInt(s.charAt(len - 1));
		} else if (len >= 2) {
			for (int i = 0, j = 1; j < len; i++, j++) {
				 m = toInt(s.charAt(i));
				 n = toInt(s.charAt(j));
				if (m >= n) {
					sum += m;
				} else {
					sum -= m;
				}
			}
		}
		return sum += n;
	}



	private static int toInt(char c) {
		switch(c){
			case 'I':return 1;
			case 'V':return 5;
			case 'X':return 10 ;
			case 'L':return 50 ;
			case 'C':return 100;
			case 'D':return 500;
			case 'M':return 1000;
		}
		return -1;
	}
}
