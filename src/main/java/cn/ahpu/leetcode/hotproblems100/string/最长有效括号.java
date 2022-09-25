package cn.ahpu.leetcode.hotproblems100.string;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

//https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
public class 最长有效括号 {

    static String s = ")()())";

    public static void main(String[] args) {
        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    @Test
    public void longestValidParentheses01() {
        String s = "";
        StringBuilder sb1 = new StringBuilder(s);
        StringBuilder sb2 = new StringBuilder();
        HashMap<Integer, Character> map = new HashMap<>();
        while (true) {
            for (int i = 0; i < sb1.length() - 1; i++) {
                if ((sb1.charAt(i) == '(') && (sb1.charAt(i + 1) == ')')) {
                    sb1.delete(i, i + 2);

                    i--;
                }
            }
        }
    }

    //StringBuilder对象遍历时可以修改 影响遍历结果
    @Test
    public void test01() {
        StringBuilder sb = new StringBuilder("12334");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '3') {
                sb.deleteCharAt(i);
                i--;
            }
            System.out.println((i + 1) + "次,长度" + sb.length());
        }
        System.out.println(sb);
    }

}
