package cn.ahpu.acm;


import org.junit.jupiter.api.Test;//显示方法单独测试 有的不行

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;

class TestSome {
    public static void main(String[] args) {

    }

    @Test
    public void test01() {
        int i = 1;
        System.out.println(i << 30);
        System.out.println();
        System.out.println(7 ^ 100);
    }


    //关键字instanceof 前面是实例 后面是当前类 父类 接口均可以
    //满足条件左边可以转换为右边类型
    //需要用到对象的强制类型转换时，需要使用instanceof进行判断。``
    @Test
    public void test02() {
        System.out.println("" instanceof String);//true
        System.out.println("" instanceof Object);//true

        System.out.println(new Integer(12) instanceof Number);//true
        Collection<String> arrayList = new ArrayList<>();


        arrayList.add("liwang");//父类引用 使用的是子类的方法（子类实现的）
        System.out.println(arrayList instanceof Collection);//true

    }

    @Test
    public void test03() {
        System.out.println("Start:Hello World!");
        System.out.println(test2() + ":Hello World!");
        System.out.println("End:Hello World!");
    }

    /**
     *test2无论是静态方法还是实例方法 结果都是一样的
     */
    //有异常 返回值均为常量 返回"finally"
    //有异常 返回值均为变量 返回"finally"
    //有异常 catch返回变量 finally返回常量 返回"finally"
    //有异常 catch返回常量 finally返回变量 返回"finally"
    public static String test2() {
        try {
            System.out.println("try block");

            /**
             * {}代码块内 return执行或抛出异常 该语句下代码块都不可执行
             */
//            return "try";//无异常捕获,该返回值被finally{}内返回值覆盖
            throw new Exception();//try代码{}内,改行代码下都不可到达,如:return;
        } catch (Exception e) {
            System.out.println("catch block");
            String s2="catch";
//            return s2;//返回值被finally{}内返回值覆盖
        } finally {
            System.out.println("finally block");
            String s3="finally";
//            return "finally";
        }
        System.out.println("不可到达的");//上面有返回值该行语句不可到达;上面有异常抛出被try捕获catch处理finally后的语句块还是可以执行的(前提是没有相应return执行)
        return null;

    }


    //无异常 返回值均为常量 返回"finally"
    //无异常 返回值均为变量 返回"finally"
    //无异常 try返回变量 finally返回常量 返回"finally"
    //无异常 try返回常量 finally返回变量 返回"finally"
    public static String test1() {
        try {
            System.out.println("try block");
            String s1 = "try";
            return s1;
        } finally {
            System.out.println("finally block");
            String s2 = "finally";
            return s2;
        }
    }

}
