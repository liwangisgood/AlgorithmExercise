package cn.ahpu.acm.java2022;

public class A的个数 {
    public static void main(String[] args) {
        String str = "AAAAAAABABBAABABABAAAAAAA\n" +
                "ABBBBBABBAABBBBBABABBBBBA\n" +
                "ABAAABABBBABAABBBBABAAABA\n" +
                "ABAAABABBBBBAABAABABAAABA\n" +
                "ABAAABABBABABBABABABAAABA\n" +
                "ABBBBBABBBABAABBBBABBBBBA\n" +
                "AAAAAAABABABABABABAAAAAAA\n" +
                "BBBBBBBBABAABABBBBBBBBBBB\n" +
                "AABAABABBAAABBAAABABBBBBA\n" +
                "ABBABABBBABBAAAABBBBAAAAB\n" +
                "BBBBAAABABAABABAABBBAABBA\n" +
                "BBAABABABAAAABBBAABBAAAAA\n" +
                "ABABBBABAABAABABABABBBBBA\n" +
                "AAAABBBBBABBBBAAABBBABBAB\n" +
                "AABAABAAABAAABAABABABAAAA\n" +
                "ABBBBBBBBABABBBBABAABBABA\n" +
                "ABBBAAABAAABBBAAAAAAABAAB\n" +
                "BBBBBBBBABBAAABAABBBABBAB\n" +
                "AAAAAAABBAAABBBBABABAABBA\n" +
                "ABBBBBABBAABABAAABBBABBAA\n" +
                "ABAAABABABBBAAAAAAAAAABAA\n" +
                "ABAAABABABABBBABBAABBABAA\n" +
                "ABAAABABBABBABABAABAABAAA\n" +
                "ABBBBBABABBBBBABBAAAABAAA\n" +
                "AAAAAAABAABBBAABABABBABBA";
        int length = str.length();
        int count=0;
        for (int i = 0; i < length; i++) {
            if ('A'==str.charAt(i)){
                count++;
            }
        }
        System.out.println(count);


    }
}
