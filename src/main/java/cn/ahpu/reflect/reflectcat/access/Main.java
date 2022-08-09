package cn.ahpu.reflect.reflectcat.access;

import org.junit.Test;

import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("cn.ahpu.reflect.reflectcat.access.AccessibleTest");
        AccessibleTest at = new AccessibleTest();
        at.setId(1);
        at.setName("AT");
        for (Field f : clazz.getDeclaredFields()) {
            //在同一个java文件中也可以不适用下行代码
            f.setAccessible(true);//AccessibleTest类中的成员变量为private,故必须进行此操作
            System.out.println(f.get(at));//获取当前对象中当前Field的value
        }
    }

    @Test
    public void test01(){
        int[] a={1,2,3};
        for (int i : a) {
            System.out.println(i);
        }
    }



}