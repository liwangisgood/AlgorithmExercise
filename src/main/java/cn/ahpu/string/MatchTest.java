package cn.ahpu.string;

import org.junit.Test;

public abstract class MatchTest {

    static String str="你哈哦";

    public static void main(String[] args) {
        say();
        System.out.println(MatchTest.str);
    }

    private static void say( ){
        System.out.println("你好");
    }

    //抽象方法不能被final static private中任何一个关键字所修饰
     abstract void say1();

    @Test
    public void test01(){
        String str="小孩";
        System.out.println(str.matches(""));

        //匹配任意字符串
        System.out.println(str.matches(".*?"));//true
    }



}
