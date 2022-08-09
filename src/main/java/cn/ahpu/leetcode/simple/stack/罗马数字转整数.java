package cn.ahpu.leetcode.simple.stack;

/**
 * @author:liwang
 * @date: 2022/2/21 14:06
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/roman-to-integer/solution/yong-shi-9993nei-cun-9873jian-dan-jie-fa-by-donesp/
 */
public class 罗马数字转整数 {
	public static void main(String[] args) {
		//无法从 static 上下文引用非 static 方法 'covertToNum(char)'
		String s="MCMXCIV";
		int sum=0;
		int n=covertToNum(s.charAt(0));
		int m=0;
		for (int i=1;i<s.length();i++){
			m=covertToNum(s.charAt(i));
			if(n>=m){
				sum+=n;
			}else {
				sum+=-n;
			}
			n=m;
		}
		sum+=n;
		System.out.println(sum);
	}

	public static int covertToNum(char c){
		switch(c){
			case 'I':return 1;
			case 'V':return 5;
			case 'X':return 10;
			case 'L':return 50;
			case 'C':return 100;
			case 'D':return 500;
			case 'M':return 1000;
		}
		return 0;
	}


}
