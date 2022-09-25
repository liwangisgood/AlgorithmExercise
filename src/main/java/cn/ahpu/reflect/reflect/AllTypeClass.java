package cn.ahpu.reflect.reflect;

import java.io.Serializable;

public class AllTypeClass {
    public static void main(String[] args) {
        Class<String> cls1 = String.class;//外部类
        System.out.println("cls1:"+cls1);
        Class<Serializable> cls2 = Serializable.class;//接口
        System.out.println("cls2:"+cls2);
        Class<Integer[]> cls3 = Integer[].class;//数组
        System.out.println("cls3:"+cls3);
        Class<float[][]> cls4 = float[][].class;//二维数组
        System.out.println("cls4:"+cls4);
        Class<Deprecated> cls5 = Deprecated.class;//注解 //枚举
        System.out.println("cls5:"+cls5);
        Class<Thread.State> cls6 = Thread.State.class;
        System.out.println("cls6:"+cls6);
        Class<Long> cls7 = long.class;//基本数据类型
        System.out.println("cls7:"+cls7);
        Class<Void> cls8 = void.class;//void 数据类型
        System.out.println("cls8:"+cls8);
        Class<Class> cls9 = Class.class;//
        System.out.println("cls9:"+cls9);
    }
}

