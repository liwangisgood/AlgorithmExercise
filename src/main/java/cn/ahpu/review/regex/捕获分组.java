package cn.ahpu.review.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


//捕获分组：命名分组、非命名分组
//()表示分组    <?>或序号分组内容保存出来表示捕获
public class 捕获分组 {
    public static void main(String[] args) {

        String str1="liwa1111 ldfjn2222i  3333dniewfn  f4444newon";
        /*分组?<分组名>*/
        String regex="(?<g1>\\d\\d)(?<g2>\\d\\d)(?<g3>[a-z]?)";//非命名分组，匹配四个数字符串：(\d\d)(\d\d)

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);
        int count1 = matcher.groupCount();//表示正则式() 数目即组别，如：((\d\d)(\d\d)([a-z]?)) 结果：4
        System.out.println(count1);//无()分组  0
        System.out.println(matcher.matches());//true 当且仅当整个区域序列与此匹配器的模式匹配
        int count=0;

        while (matcher.find()){
            System.out.println(++count+"匹配:"+matcher.group(0));
            System.out.println(++count+"1匹配:"+matcher.group(1));
            System.out.println(++count+"g1匹配:"+matcher.group("g1"));
            System.out.println(++count+"2匹配:"+matcher.group(2));
            System.out.println(++count+"g2匹配:"+matcher.group("g2"));
            System.out.println(++count+"3匹配:"+matcher.group(3));
            System.out.println(++count+"g3匹配:"+matcher.group("g3"));

        }
    }

}
