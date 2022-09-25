package cn.ahpu.java8.functionInterface;

import java.util.function.Predicate;

public class FunctionalInterface {

    public static void main(String[] args) {
        boolean b1 = checkString("A", (String s) -> {
            return s.equals("A");
        });

        System.out.println("b1：" + b1);

        boolean b2 = checkString("B", (String s) -> {
            return s.equals("A");
        });
        System.out.println("b2：" + b2);

    }
    // 逻辑非操作
    private static boolean checkString(String s, Predicate<String> pre) {
        // return pre.test(s);
        // return !pre.test(s);
        return pre.negate().test(s);//在函数式接口Predicate<T>方法test() 拓展其功能default negate()
    }
}
