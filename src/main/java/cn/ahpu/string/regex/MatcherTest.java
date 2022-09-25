package cn.ahpu.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherTest {
    public static void main(String[] args) {

        String str1="liwang 12 liwang";
        String regex="liwang";
        String regex1="liwang";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);

        //start() start(int i) start(String name)
        //end() end(int i) end(String name)
/*        while (matcher.find()){
            System.out.println("-----------");
            System.out.println(matcher.start());
            System.out.println(matcher.end());//最后匹配索引值+1 即不包括的索引，如同[start,end)
            System.out.println(str1.substring(matcher.start(), matcher.end()));
            System.out.println(str1.subSequence(matcher.start(), matcher.end()));

        }*/

        //底层利用的是匹配器替换
        String str2 = str1.replaceAll(regex, "迪迦");
        System.out.println(str2);
        String str3=matcher.replaceAll("塞罗");
        System.out.println(str3);


    }
}
