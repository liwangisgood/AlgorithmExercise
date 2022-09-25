package cn.ahpu.thread;

import org.junit.Test;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }

    //Thread中实例方法run()可以被重写
    @Test
    public void test01(){
        new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
                System.out.println("你好");
            }
        }.start();

        System.out.println("-----------------------");

//        System.out.println("Runnable() run()方法运行");与下面代码等价
        new Runnable(){
            @Override
            public void run(){
                System.out.println("Runnable() run()方法运行");
            }
        }.run();

    }
}
