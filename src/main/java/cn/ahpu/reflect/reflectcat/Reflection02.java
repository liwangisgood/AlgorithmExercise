package cn.ahpu.reflect.reflectcat;

import cn.ahpu.reflect.reflectcat.entity.Cat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection02 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        //Field //Method //Constructor
//        m1();//传统 39 2391
//        m2();//反射 34 2376
        m3();//反射优化 61 2517
    }

    //传统方法来调用 hi
    public static void m1() {
        Cat cat = new Cat();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            cat.hi();
        }
        long end = System.currentTimeMillis();
        System.out.println("m1() 耗时=" + (end - start));
    }

    //反射机制调用方法 hi
    public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("cn.ahpu.reflect.reflectcat.entity.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 900000; i++) {
            hi.invoke(o);//反射调用方法
        }
        long end = System.currentTimeMillis();
        System.out.println("m2() 耗时=" + (end - start));
    }

    //反射调用优化 + 关闭访问检查
    public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls = Class.forName("cn.ahpu.reflect.reflectcat.entity.Cat");
        Object o = cls.newInstance();
        Method hi = cls.getMethod("hi");
        hi.setAccessible(true);//在反射调用方法时，取消访问检查
        long start = System.currentTimeMillis();
        long end = 0;
        for (int i = 0; i < 900000; i++) {
            hi.invoke(o);//反射调用方法 }
            end = System.currentTimeMillis();

        }
        System.out.println("m3() 耗时=" + (end - start));
    }

}
