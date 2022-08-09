package cn.ahpu.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolTest {
    private static final int threads = 100;
    private CountDownLatch countDownLatch = new CountDownLatch(threads);

    /**
     * singleThreadPool execute
     *
     * @throws InterruptedException
     */
    @Test
    public void test1() throws InterruptedException {
        System.out.println("---- begin ----");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < threads; i++) {
            singleThreadExecutor.execute(() -> {//SingleThreadPoolExecutor 的execute()实现的 Executor实现的execute方法
                printThreadInfo();
            });
        }
        countDownLatch.await();
        System.out.println("---- end ----");
    }


    /**
     * singleThreadPool submit
     *
     * @throws InterruptedException
     */
    @Test
    public void test2() throws InterruptedException {
        System.out.println("---- begin ----");
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < threads; i++) {
            singleThreadExecutor.submit(new Thread(() -> {
                printThreadInfo();
            }));
        }
        countDownLatch.await();
        System.out.println("---- end ----");
    }


    /**
     * 打印线程信息
     */
    private void printThreadInfo() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(50);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            countDownLatch.countDown();
        }
    }
}
