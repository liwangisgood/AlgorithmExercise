package cn.ahpu;

import cn.ahpu.java8.entity.Student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("myTest")
public class MyTest {

    private static ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
    private static MyTest myTest = (MyTest) ac.getBean("myTest");

    public static void main(String[] args) throws IOException {
        myTest.test01();

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

        System.out.println((-2) >> 30);//负数有符号位 缺位补1
        System.out.println((-2) >>> 30);//无符号为 缺位补0
        System.out.println(new Integer(4 << 3) instanceof Integer);//32   4二进制左移3位 4*8
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    //字符串默认值在数值上等于0
    @Test
    public void test02() {
        System.out.println('\u0000' == ' ');//
        System.out.println('\u0000' == '0');//
        System.out.println('\u0000' == 0);//true
        System.out.println('\0' == 0);//true

        System.gc();
        Runtime.getRuntime().gc();

        //codePointBefore()可越界
        System.out.println("Aa123".codePointBefore(5));//'1'49 'a'97 'A'65

        String s = "123";//添加 final String表示不能被重新赋值,没有添加,可以重新赋值
        s = "890";//

        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("123") == sb);//true

        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.append("456") == sb1);//true
    }

    @Test
    public void test03() {
        Student student = new Student();
        System.out.println(student);
    }

    @Test
    public void test04() {
        int i = 0;
        int j = i++;//
        System.out.println(i + " " + j);

        byte a = 1;
        byte b = 7;
        //b = a + b; //编译时发生异常 error : cannot convert from int to byte
        b += a; // ok

    }

    @Test
    public void test05() throws IOException {

        String regex = "[a-zA-Z]+";//匹配非数字、数字、任意字符
        String input = null;

        Pattern pattern = Pattern.compile(regex);
        int rowNum = 0;
        //输入流读取文件 当没有文件时候 不会创建会抛出异常
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\X10ti-S\\Desktop\\SpringTest01.java"));
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


}
