package cn.ahpu.acm.simple;

import java.util.Arrays;

/**
 * @author:liwang
 * @date: 2022/4/7 16:55
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 第六题_分类计数15 {

	public static void main(String[] args) {
		String str="1+a=Aab";
		char[] chars = str.toCharArray();
		int numCount=0,upperCaseCount=0,lowerCaseCount=0,other=0;
		for (int i = 0; i < chars.length; i++) {
			if (48<=chars[i]&&chars[i]<=57){
				numCount++;
			}else if (65<=chars[i]&&chars[i]<=90){
				upperCaseCount++;
			}else if (97<=chars[i]&&chars[i]<=122){
				lowerCaseCount++;
			}else {
				other++;
			}
		}
		System.out.println("numCount="+numCount);
		System.out.println("upperCaseCount="+upperCaseCount);
		System.out.println("lowerCaseCount"+lowerCaseCount);
		System.out.println("other="+other);

	}
}
