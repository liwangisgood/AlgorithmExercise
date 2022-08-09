package cn.ahpu.java8;

import org.junit.Test;
import sun.management.counter.perf.PerfInstrumentation;

import java.lang.reflect.Array;
import java.text.Collator;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 一个接口 一个抽象方法 lambda表达式的多种实现
 * lambda表达式定义方法类型接口
 * lambda方法定义在方法外,作为独立的类方法(可以避免修改lambda方法的外层方法中局部变量的修改编译醋无) 方法名可以作为参数
 * lambda方法内使用成员变量 无法修改否则编译错误 建议lambda使用final类型成员变量
 *
 */
public class Lambda {

    private static String name="liwang";
    private static Integer age=23;

    public static void main(String[] args) {

        int money=0;
        System.out.println(operate(age, 6, subtraction));//-3
        System.out.println(subtraction.operation(age, 6));

        System.out.println(operate(3, 6, divide));//0
        System.out.println("addition:"+operate(money, 7, addition));

        System.out.println("age:"+age);

    }

    private static final MathOperation subtraction = (a, b) -> a - b;

    private static final MathOperation multiply = (a, b) -> a * b;

    private static final MathOperation addition = (a, b) -> {
        int x = a + b;
        System.out.println("x:"+x);
//        age=666;

        return x;
    };

    private static MathOperation divide = (a, b) -> a / b;
    MathOperation mod = (a, b) -> a % b;


    private static int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    /**
     * 有泛型接口 也可以不使用 即,Raw use of parameterized class 'MathOperation'
     * @param <T>
     */
    interface MathOperation<T> {
        int operation(int a, int b);

        //类实现接口 然后创建对象才能调用默认方法
        default  int addition(int a, int b){
            return a+b;
        }

        default int subtration(int a,int b){
            return a-b;
        }
    }

    @Test
    public void test01(){
        List<String> asList = Arrays.asList("谷歌", "腾讯", "百度", "淘宝");
        Collator collator = Collator.getInstance(Locale.CHINA);
        asList.sort((s1,s2)->collator.compare(s1,s2));
        for (String s : asList) {
            System.out.print(s+" ");
        }
    }


}



