package cn.ahpu.java8.entity;

import lombok.NonNull;
import lombok.Value;

//toString equals hashcode getXxx 一个全参构造器 成员属性前private final
//静态成员属性不参与
@Value
public class Person {
    @NonNull
    String name;
    static Integer age;
    Class aClass;

    public static void main(String[] args) {
        Person person = new Person("李旺", new Class(193, "计算机"));
        System.out.println(person);
    }
}
