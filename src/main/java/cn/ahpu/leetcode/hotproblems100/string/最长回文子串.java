package cn.ahpu.leetcode.hotproblems100.string;

import org.junit.Test;

import java.util.*;

//https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
public class 最长回文子串 {

//    boolean[][] b = new boolean[3][3];//默认被赋值初始化false

    public static void main(String[] args) {
        String s = "babad";
        String str = longestPalindrome(s);

    }

    private static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                int j = L + i - 1;
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {

                }
            }
        }
        return null;
    }

    @Test
    public void test01() {
        StringBuilder sb = new StringBuilder(null);
        System.out.println(sb instanceof StringBuilder);
    }

    @Test
    public void test02() {
        String s = "abc".substring(0, 3);
        System.out.println(s);
    }

    @Test
    public void test03() {
/*        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.println(b[i][j]);
            }
        }*/
//        String s; int i;
//        System.out.println(i);
        System.out.println("--------------------");
        boolean[][] b1 = new boolean[3][3];//该局部变量也进行了初始化
        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1.length; j++) {
                System.out.println(b1[i][j]);
            }
        }
        System.out.println("--------------------");
        int[][] b2 = new int[3][3];//该局部变量也进行了初始化
        for (int i = 0; i < b2.length; i++) {
            for (int j = 0; j < b2.length; j++) {
                System.out.println(b2[i][j]);
            }
        }
        System.out.println("--------------------");
        int[] b3 = new int[3];//该局部变量也进行了初始化
        for (int i = 0; i < b3.length; i++) {
                System.out.println(b3[i]);
        }
    }

}

//超时
class Solution {
    public String longestPalindrome(String str) {
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String s = str.substring(i, j);
                if (iSLongestPalindrome(s)) {
                    map.put(s.length(), s);
                }
            }
        }
        Set<Integer> set = map.keySet();
        Integer max = 0;
        for (Integer s : set) {
            if (max < s) {
                max = s;
            }
        }
        String s = map.get(max);
        return s;
    }

    private static boolean iSLongestPalindrome(String s) {
        if (s != null) {
            String s1 = new StringBuilder(s).reverse().toString();
            if (s.equals(s1)) {
                return true;
            }
        }
        return false;
    }

}
