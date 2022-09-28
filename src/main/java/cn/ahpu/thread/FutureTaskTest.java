package cn.ahpu.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(300);
                System.out.println("calld01方法执行了");
                return "call方法返回值01";
            }
        });

        futureTask.run();
        FutureTask futureTask1 = new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                Thread.sleep(300);
                System.out.println("calld02方法执行了");
                return "call方法返回值02";
            }
        });

        futureTask1.run();
        System.out.println("获取返回值: " + futureTask.get() );
        System.out.println("获取返回值1: " + futureTask1.get());
    }

    @Test
    public void test01() {

    }

}
