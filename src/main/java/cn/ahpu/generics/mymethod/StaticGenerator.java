package cn.ahpu.generics.mymethod;

import org.springframework.stereotype.Component;

@Component
public class StaticGenerator<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <E> void show(E t){//静态方法中要使用泛型与类声明的泛型不是同一个
        System.out.println(t);
    }

    //静态泛型类不能被直接对象使用 只能被不带泛型的类名使用(使用的泛型为Object)
    public static void main(String[] args) {
        StaticGenerator<String> staticGenerator = new StaticGenerator<>();
        staticGenerator.setT("李旺");
        StaticGenerator.show("123");//"123"被转化为Object类型

        System.out.println(staticGenerator.getT());//String类型
        System.out.println(staticGenerator.getT() instanceof String);
    }
}