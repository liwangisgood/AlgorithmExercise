package cn.ahpu.string.regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

//非捕获匹配,() 形式上为分组 但不是分组，也不是捕获，只能matcher.group(0)
public class 特别分组 {
    public static void main(String[] args) {
        /*String str1="小石头213 大石头 43  中石头";
        String regex="(?:小|中|大)石头";//形式：(?:pattern),如：“hsp(?:edu|tea|stu)”*/

/*        String str1="windows104t4gwindows11";
        String regex="windows(?=10|11)";//形式：(?=pattern),匹配到的是：windows windows*/

        String str1="windows104t4gwindows11fn389windows7";
        String regex="windows(?!11|10)";//形式：(?!pattern),与(?=pattern)匹配相反,匹配到的是：windows7中windows

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);

        while (matcher.find()){
            System.out.println(matcher.group(0));
        }
    }
}
