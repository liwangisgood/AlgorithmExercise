package cn.ahpu.juc.tests;


import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;


//处理线程池异常 手动捕获处理 或 submit Callable加返回值???
@Slf4j(topic = "c.TestTimer")
public class TestTimer {

    //定时器任务缺陷: 任务串行执行 前面任务出现异常那程序不会向下运行(即使进行异常捕获)
    //任务1执行时间过长,可能会延后任务2开始执行(超过之前的定时时间开始执行)
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Executors.newScheduledThreadPool(1) 可以代替TimeTask的效果线程串行执行 也可以多线程并行执行
        /*ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        pool.schedule(() -> {
            try {
                log.debug("task1");
                int i = 1 / 0;
            } catch (Exception e) {
                log.error("error:", e);
            }
        }, 1, TimeUnit.SECONDS);*/

        ExecutorService pool = Executors.newFixedThreadPool(1);
        pool.submit(() -> {
            try {
                log.debug("task1");
                int i = 1 / 0;
            } catch (Exception e) {
//                log.error("error:", e);
                e.printStackTrace();//效果一样

            }
        });
    }

    private static void method3() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(1);
        log.debug("start...");
        pool.scheduleAtFixedRate(() -> {
            log.debug("running...");
        }, 1, 1, TimeUnit.SECONDS);
    }


    private static void method2(ScheduledExecutorService pool) {
        pool.schedule(() -> {
            log.debug("task1");
            int i = 1 / 0;
        }, 1, TimeUnit.SECONDS);

        pool.schedule(() -> {
            log.debug("task2");
        }, 1, TimeUnit.SECONDS);
    }

    private static void method1() {
        Timer timer = new Timer();
        TimerTask task1 = new TimerTask() {
            @SneakyThrows
            @Override
            public void run() {
                log.debug("task 1");
                Thread.sleep(2000);
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                log.debug("task 2");
            }
        };

        log.debug("start...");
        timer.schedule(task1, 1000);
        timer.schedule(task2, 1000);
    }
}

