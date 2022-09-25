package cn.ahpu.generics;

import org.springframework.stereotype.Component;

/**
 * author : northcastle
 * createTime:2021/10/18
 * 自定义泛型类 泛型涵盖 类名 属性类型 构造器参数类型 方法返回值类型 方法参数类型
 * 使用注意:1.泛型类型为引用类型 2.泛型未指定类型则为Object类型 3.同一个泛型类的运行时类型都是同一个
 */
@Component
public class MyGenerics<T> {
    //1.有一个普通的属性
    private int num;
    //2.有一个泛型类型的属性
    private T t;

    //3.正常的构造方法
    public MyGenerics() {
    }

    public MyGenerics(int num, T t) {
        this.num = num;
        this.t = t;
    }

    public static void main(String[] args) {
        //1.创建一个自定义泛型类的对象
        MyGenerics<String> stringMyGenerics = new MyGenerics<>();
        //2.调用setter方法设置值
        stringMyGenerics.setNum(100);
        stringMyGenerics.setT("hello world"); // 也是正常的调用
        //3.调用toString方法查看对象属性的值
        System.out.println(stringMyGenerics);
    }

    //4.正常的getter/setter 方法
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //5.正常的toString 方法

    @Override
    public String toString() {
        return "MyGenerics{" +
                "num=" + num +
                ", t=" + t +
                '}';
    }
}


