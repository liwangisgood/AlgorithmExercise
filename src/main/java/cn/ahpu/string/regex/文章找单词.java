package cn.ahpu.string.regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


//正则表达式体现找相应内容
//没用小括号() 分组  matcher.group(0)表示
//找数字如：[0-9]+ m   matcher.group(0)
//找单词：[a-zA-Z]+   matcher.group(0)
//找数字和英文单词：([0-9]+)|([a-zA-Z]+)   matcher.group(0)
//找ip地址：\\d+\\.\\d+\\.\\d+\\.\\d+
//找四个连续的数字：\\d\\d\\d\\d   如：2022 2018


//网页中找热点内容：("<a target=\"_blank\" title=\"(\\S*)\"")   matcher.group(1)

//


public class 文章找单词 {

    public static void main(String[] args) throws IOException {

        String regex = "</a><!----></div></li><li class=\"tag\"><!----><div><a href=\"(\\S*)\" target=\"_blank\" class=\"tag-link\">";
        String input = null;

        Pattern pattern = Pattern.compile(regex);
        int rowNum = 0;
        BufferedReader br = new BufferedReader(new FileReader("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\regex\\文章找单词.txt"));
        while ((input = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(input);
            System.out.print("行" +matcher.matches()+ (++rowNum) + "单词：");
            while (matcher.find()) {
                System.out.print(matcher.group(0) + " ");//表示与正则式匹配的所有字串，分组、不分组都可以，//组0代表匹配到子字符串
            }
            System.out.println();
        }

    }
}
