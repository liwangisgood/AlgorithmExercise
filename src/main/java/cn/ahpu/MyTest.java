package cn.ahpu;

import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import sun.net.idn.Punycode;

import javax.print.DocFlavor;
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {

    public static void main(String[] args) throws IOException {

        String regex = "[a-zA-Z]+";//匹配非数字、数字、任意字符
        String input = null;

        Pattern pattern = Pattern.compile(regex);
        int rowNum = 0;
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\X10ti-S\\Desktop\\新建文本文档.txt"));
        while ((input = br.readLine()) != null) {
            Matcher matcher = pattern.matcher(input);
            System.out.print("行" + (++rowNum) + "单词：");
            while (matcher.find()) {
                System.out.print(matcher.group(0) + " ");
            }
            System.out.println();
        }


       /* String text = "John writes about this, and John Doe writes about that,"
                + " and John Wayne writes about everything.";
        String patternString1 = "(John) (.+?) ";
        Pattern pattern = Pattern.compile(patternString1);
        Matcher matcher = pattern.matcher(text);
        matcher.find();//匹配字符串,匹配到的字符串可以在任何位置
        int start = matcher.start();//返回当前匹配到的字符串在原目标字符串中的位置
        int end = matcher.end();//返回当前匹配的字符串的最后一个字符在原目标字符串中的索引位置
        System.out.println(start + " " + end + " " + matcher.groupCount());
        System.out.println("found group: group(0) is '" + matcher.group(0));
        System.out.println("found group: group(1) is '" + matcher.group(1) + "',group(2) is '" + matcher.group(2) + "'");*/


    }

/*    @Test
    public void test04(){
        Pattern.compile();//不能使用
    }*/


    @Test
    public void test01() {
        int x = Integer.MAX_VALUE - 3;
        String s = Integer.toBinaryString(x);
        System.out.println(s + "长度:" + s.length());

        System.out.println(Integer.toString(100, 8));
        System.out.println(Integer.toString(100, 2));
        System.out.println(Integer.toString(100, 16));

        System.out.println((-2)>>30);//负数有符号位 缺位补1
        System.out.println((-2)>>>30);//无符号为 缺位补0
        System.out.println(new Integer(4<<3) instanceof Integer);//32   4二进制左移3位 4*8
        System.out.println(Runtime.getRuntime().availableProcessors());
    }



}
