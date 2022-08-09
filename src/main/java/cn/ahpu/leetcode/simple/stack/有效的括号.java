package cn.ahpu.leetcode.simple.stack;

/**
 * @author:liwang
 * @date: 2022/2/25 8:12
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/valid-parentheses/solution/you-xiao-de-gua-hao-by-leetcode-solution/
 */
public class 有效的括号 {
	public static void main(String[] args) {
		long start=0,end=0;
		try{
			start=System.currentTimeMillis();
			System.out.println("纳秒start："+start);

			StringBuffer sb = new StringBuffer("({}){}([]{}()([]{}))");
			int len = sb.length();
			if (sb == null || len == 0 || len % 2 == 1) {
				System.out.println(false);
				return;
			}

			int index=-1,count=0;
			//sb.length()长度可能动态发生改变，i索引的值也需要发生改变 每次弹栈的时候 索引需要减去2
			for (int i = 0; i < sb.length(); i++) {
				char a = sb.charAt(i);

				if (a == '(' || a == '{' || a == '[') {
					index++;
					count++;
				}else if(a == ')' || a == '}' || a == ']'){
					char b=converse(sb.charAt(index));
					if (a==b){
						sb.delete(index,i+1);
						i-=2;
						index--;
						count--;
					}else {
						System.out.println(false);
						return;
					}
				}else {
					System.out.println(false);
					return;
				}
			}
			System.out.println(count == 0);

		}finally {
			end=System.currentTimeMillis();
			System.out.println("纳秒end："+end);
			System.out.println("耗时end-start："+(end-start));
		}
	}

	private static char converse(char b) {
		switch (b) {
			case '[':
				return ']';
			case '{':
				return '}';
			default:
				return ')';
		}
	}

}
