package cn.ahpu.leetcode.simple.字符串;

/**
 * @author:liwang
 * @date: 2022/3/29 13:21
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class 实现strStr {
	public static void main(String[] args) {

		String haystack =  "", needle = "";
		int result=strStr(haystack,needle);
		System.out.println(result);

	}

	private static int strStr(String a, String b) {

		int n=a.length(),m=b.length();
		for (int i=0;i+m<=n;i++){
			 boolean flag=true;
			 for (int j=0;j<m;j++){
			 	if (a.charAt(i+j)!=b.charAt(j)){
			 		flag=false;
			 		break;
				}
			 }
			 if (flag){
			 	return i;
			 }
		}
		return -1;
	}

}
