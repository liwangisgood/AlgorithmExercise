package cn.ahpu.acm.simple.字符串;

/**
 * @author:liwang
 * @date: 2022/4/7 0:23
 * @Description:TODO
 * @Algorithm Design：TODO
 * 简单的加密与解密只是循环往复的一一对照
 */
public class 试题B解密 {
	public static void main(String[] args) {
		//优化可以简化为一个字符串 奇数 偶数分别对应原字符 加密字符
		String str ="abcdefghi";
		String str1="123456789";

		String s0="aei";
		StringBuilder s1=new StringBuilder();

		for(int i=0;i<s0.length();i++){
			int index=str.indexOf(s0.charAt(i));
			s1.append(str1.charAt(index));
		}
		System.out.println(s1.toString());//159
	}
}


