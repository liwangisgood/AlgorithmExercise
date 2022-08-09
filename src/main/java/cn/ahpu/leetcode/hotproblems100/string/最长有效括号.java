package cn.ahpu.leetcode.hotproblems100.string;

//https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
public class 最长有效括号 {
    static String s = ")()())";

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        int open = 0, close = 0, maxNum = 0, temp = 0;
        int start = 0;
        for (int i = 0; i < len; i++) {
            if (charArray[i] == '(') {
                open++;
            } else if (charArray[i] == ')') {
                close++;
            }

            if (open < close) {
                if (maxNum < open * 2) {
                    maxNum = open * 2;
                }
                open = 0;
                close = 0;
                start = i + 1;
            } else if (open >= close) {
                if (maxNum < close * 2) {
                    maxNum = close * 2;
                }
            }
        }
        return maxNum;
    }
}
