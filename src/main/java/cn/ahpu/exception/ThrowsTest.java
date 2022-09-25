package cn.ahpu.exception;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ThrowsTest {

    public static void main(String[] args) {
        //throws抛出不处理程序会终止 后续代码不会被执行
//        testThrows();
//        System.out.println("11111111111111111");


        //throw抛出运行时异常 程序会终止 后续代码也不会执行
//        Integer i = null;
//        testThrow(i);
//        System.out.println("22222222222222222");

        String filePath = null;
        try {
            testThrow(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("throw抛出被try catch捕获程序不会终止，下面代码会继续执行");
    }

    /**
     * 测试 throws 关键字
     * @throws NullPointerException
     */
    public static void testThrows() throws NullPointerException {
        Integer i = null;
        System.out.println(i + 1);
    }

    /**
     * 测试 throw 关键字抛出 运行时异常
     * @param i
     */
    public static void testThrow(Integer i) {
        if (i == null) {
            throw new NullPointerException();//运行时异常不需要在方法上申明
        }
    }

    /**
     * 测试 throw 关键字抛出 非运行时异常，需要方法体需要加 throws 异常抛出申明
     * @param filePath
     */
    public static void testThrow(String filePath) throws IOException {
        if (filePath == null) {
            throw new IOException();//非运行时异常，需要方法体需要加 throws 异常抛出申明
        }
    }

}
