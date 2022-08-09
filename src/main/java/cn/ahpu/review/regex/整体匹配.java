package cn.ahpu.review.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

//整体匹配，字符串与正则表达式完全匹配,加不加^ $定位符 效果一样
public class 整体匹配 {
    public static void main(String[] args) {

        //方式1：整体匹配regex加不加^ $都是整体匹配，方式1，2底层一样 方式1对方式2做了一个封装
        String str1="123abc";
        String regex="^\\w+$";;//\w+
        System.out.println(Pattern.matches(regex, str1));

        //方式2：整体匹配regex加^ $ 定位符，不加^ $一旦有多余未匹配字符，返回false
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);
        System.out.println(matcher.matches());
    }
}
