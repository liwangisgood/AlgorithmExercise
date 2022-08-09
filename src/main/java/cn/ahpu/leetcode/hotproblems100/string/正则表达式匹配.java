package cn.ahpu.leetcode.hotproblems100.string;

import org.junit.Test;

//所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//https://leetcode.cn/problems/regular-expression-matching/solution/shou-hui-tu-jie-wo-tai-nan-liao-by-hyj8/
public class 正则表达式匹配 {
    static String s = "aa", p = "a*";

    public static void main(String[] args) {

        boolean b = s.matches(p);
        System.out.println(b);
    }

    @Test
    public void test01(){
        System.out.println(isMatch(s, p));
    }

    /**
     * 局部变量都需要初始化
     */
    @Test
    public void test02(){
        String str;//不能直接
        String[] strs;
        char[] cs;//
        int i;
        System.out.println();
    }



    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        // dp[i][j]:表示s的前i个字符，p的前j个字符是否能够匹配
        boolean[][] dp = new boolean[cs.length + 1][cp.length + 1];

        // 初期值
        // s为空，p为空，能匹配上
        dp[0][0] = true;
        // p为空，s不为空，必为false(boolean数组默认值为false，无需处理)

        // s为空，p不为空，由于*可以匹配0个字符，所以有可能为true
        for (int j = 1; j <= cp.length; j++) {
            if (cp[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // 填格子
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 文本串和模式串末位字符能匹配上
                if (cs[i - 1] == cp[j - 1] || cp[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (cp[j - 1] == '*') { // 模式串末位是*
                    // 模式串*的前一个字符能够跟文本串的末位匹配上
                    if (cs[i - 1] == cp[j - 2] || cp[j - 2] == '.') {
                        dp[i][j] = dp[i][j - 2]      // *匹配0次的情况
                                || dp[i - 1][j];     // *匹配1次或多次的情况
                    } else { // 模式串*的前一个字符不能够跟文本串的末位匹配
                        dp[i][j] = dp[i][j - 2];     // *只能匹配0次
                    }
                }
            }
        }
        return dp[cs.length][cp.length];
    }

}
