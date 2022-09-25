package cn.ahpu.reflect.reflect.entity;


public class Cat {

    public Integer age = 6;

    public Cat() {

    }

    public Cat(String name) {
        System.out.println("小猫:" + name);
    }

    public void hi() {//不设置public 反射不行
        System.out.println("我是一只猫,喵");
    }

}

