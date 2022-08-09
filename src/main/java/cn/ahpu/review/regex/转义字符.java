package cn.ahpu.review.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*文件路径名一样\\
* 正则表达式转义\\ ,. * + ( ) $ / \ ? [ ] ^ { }，如\\. 等价于[.]
* 元字符：如\\d   不能写成\d因为\后面的会被视作转义字符
* 限定符：如{}
* 边界符：
*
* */
public class 转义字符 {
    public static void main(String[] args) {

        String str1="liwa1111 ldfjn2222i  3333dniewfn  f4444newon";
        String regex="(\\d\\d)(\\d\\d)([a-z]?)";//非命名分组，匹配四个数字符串：(\d\d)(\d\d)

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str1);
        int count1 = matcher.groupCount();//表示正则式() 数目即组别，如：((\d\d)(\d\d)([a-z]?)) 结果：4
        System.out.println(count1);//无()分组  0
        System.out.println(matcher.matches());//true 当且仅当整个区域序列与此匹配器的模式匹配
        int count=0;

        while (matcher.find()){
            System.out.println(++count+"匹配:"+matcher.group(0));
            System.out.println(++count+"匹配:"+matcher.group(1));
            System.out.println(++count+"匹配:"+matcher.group(2));

        }
    }
}
