package cn.ahpu.string.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 反向引用 {
    public static void main(String[] args) {

        //替换……为""空字符串,去掉单独的.....容易直接替换
        String str1="我我......要要要......学java";
        String regex="\\.";//一个.表示所有的可以匹配所有的字符,需要转义字符\\.表示.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);
        str1 = matcher.replaceAll("");
        System.out.println(str1);

        //反向引用替换，叠词(.)\\1+，找叠词去重复
        String regex1="(.)\\1+";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(str1);
        int count=0;
        while (matcher1.find()){
            System.out.println("row "+(++count)+":"+matcher1.group(0));
        }
        str1=matcher1.replaceAll("$1");//反向引用替换匹配到的内容
        System.out.println(str1);

    }
}
