package cn.ahpu.string.normal;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Locale;

public class NormalTest {

    static final String str=" 优秀abc123A ";

    public static void main(String[] args) {
        NormalTest normalTest = new NormalTest();//带有abstract不能直接new
    }

    //内部类修饰符public


    //获取
    @Test
    public void test01(){
        System.out.println(str.length());
        System.out.println(str.charAt(0));
        System.out.println(str.indexOf("优秀"));
        System.out.println(str.indexOf(65));
        System.out.println(str.substring(5));
    }

    //判断
    @Test
    public void test02(){
        System.out.println(str.startsWith("优秀"));
        System.out.println(str.endsWith("A"));
        System.out.println(str.contains("秀"));
        System.out.println(!str.isEmpty());
        System.out.println(!str.equals("别急他"));
    }

    /**
     * 转换
     * 字符数组<->字符串 Arrays.toString() toCharArray()
     * 字节数组<->字符串 getBytes() new String()
     *
     *  字符串<->字符串数组 split()
     */
    @Test
    public void test03(){
        System.out.println(str.getBytes(StandardCharsets.UTF_8));
        char[] array = str.toCharArray();
        System.out.println(Arrays.toString(array));
        System.out.println(String.valueOf(str.toCharArray()));
        System.out.println(str.toUpperCase(Locale.ROOT));
        System.out.println(str.toLowerCase());
        System.out.println(str.concat("666"));
        System.out.println("-------------------------");

        /**
         * 字符串的split
         *  "_900"被分割为"" "900" 长度为2
         *  "900_"被分割为"900" 长度为1
         *  "300_900"被分割为"300" "900" 长度2
         *  ""将字符串分割为一个个字符
         */
        String[] strs = "300_900".split("_");
        for (String str : strs) {
            System.out.println(str+" ");
        }
        System.out.println("长度:"+strs.length);
        System.out.println("-------------------------");
        strs = "300_900".split("&");
        //strs 输出为 [Ljava.lang.String;@4dc63996
        System.out.println(Arrays.toString(strs)+" 长度:"+strs.length);
        /**
         * 不能跨包直接访问非public修饰的类 如:java.lang.AbstractStringBuilder
         * 以StringBuilder类形式直接使用其内容,来间接使用java.lang.AbstractStringBuilder的内
         */

        //'java.lang.AbstractStringBuilder' is not public in 'java.lang'. Cannot be accessed from outside package
        //new AbstractStringBuilder()//
    }

    //替换
    @Test
    public void test04(){
        System.out.println(str.replaceAll("优秀", "新宝岛"));
        System.out.println(str.replace('优', '西'));
        System.out.println(str.trim());
    }

}
