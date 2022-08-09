package cn.ahpu.leetcode.simple.字符串;

/**
 * @author:liwang
 * @date: 2022/2/23 15:40
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/longest-common-prefix/solution/zui-chang-gong-gong-qian-zhui-by-leetcode-solution/
 */
public class 最长公共前缀 {
	public static void main(String[] args) {
		String[] stringArray = {"dog","racecar","car"};
		int arrayLen = stringArray.length;

		//获取数组中字符串最小长度的索引
		int minIndex = 0;
		for (int i = 1; i < arrayLen; i++) {
			if (stringArray[minIndex].length() > stringArray[i].length()) {
				minIndex = i;
			}
		}

		//最短字符串
		int minStringLength=stringArray[minIndex].length();

		//字符串指向为空或长度为零所得公共前缀字符串为空
		if (minStringLength==0||stringArray==null){
			System.out.println("数组公共前缀字符串："+"");
			return;
		}
		String minString=stringArray[minIndex];
		int count=0;

		//存储公共前缀
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < minStringLength; i++) {
			char c=minString.charAt(i);
			for (int j=0;j<arrayLen;j++){
				String str=stringArray[j];
				if(str.charAt(i)==c){
					count+=1;
					count%=arrayLen;
				}
			}
			if(count==0){
				sb.append(c);
			}else {
				break;
			}
		}
		System.out.println("数组公共前缀字符串："+sb);
	}
}
