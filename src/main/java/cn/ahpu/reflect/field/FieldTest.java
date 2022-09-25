package cn.ahpu.reflect.field;

import org.junit.Test;

import java.lang.reflect.Field;

public class FieldTest {

    public static void main(String[] args) {

    }


    //通过反射 改变字符串不可变特性
    @Test
    public void test01() throws NoSuchFieldException, IllegalAccessException {
        //创建字符串"Hello World"， 并赋给引用s
        String s = "Hello World";

        System.out.println("s = " + s);	//Hello World

        //获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");

        //改变value属性的访问权限 不添加会异常:java.lang.IllegalAccessException: Class cn.ahpu.reflect.field.FieldTest can not access a member of class java.lang.String with modifiers "private final"
        valueFieldOfString.setAccessible(true);

        //获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);

        //改变value所引用的数组中的第5个字符
        value[5] = '_';

        System.out.println("s = " + s);  //Hello_World
    }

}
