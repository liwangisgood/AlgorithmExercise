package cn.ahpu.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class StringTest {
    public static void main(String[] args) {
        String str = "abc";//表示在常量池中创建了一个长度是3的char数组
        String str2 = "abc";//优先从常量池中找到上面创建的3个长度char数组，当找不到的时候，会重新再常量池创建新的char数组
        String str6="abcd";
        System.out.println(str==str2);//判断两个对象地址是否相等
        System.out.println(str.equals(str2));//判断两个对象值是否相等

        String str3 = new String("abc");
        String str4 = new String("abc");
        System.out.println(str3==str4);
        System.out.println(str3.equals(str4));
        String str5 = "abc" + "d";//优先从常量池查找有没有 "abcd"，有就直接用，没有就在常量池创建
        str += "d";//字符串拼接，表示在常量池中创建了一个新的char数组，长度是4个，并且将原来数组中的abc复制到了新数组
        System.out.println(str);
        System.out.println(str == str5);//有变量 应该是创建了堆对象
        System.out.println(str6 == str);//false 字符串常量池 abcd 与堆中str abcd比较false
    }

    @Test
    public void test01() throws UnsupportedEncodingException {
        String str = "爱编程";
        String strIso = new String(str.getBytes("GBK"), "utf-8");
        System.out.println(strIso);
    }



}

