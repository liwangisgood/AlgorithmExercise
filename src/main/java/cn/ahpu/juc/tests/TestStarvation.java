package cn.ahpu.juc.tests;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j(topic = "c.TestDeadLock")
public class TestStarvation {

    static final List<String> MENU = Arrays.asList("地三鲜", "宫保鸡丁", "辣子鸡丁", "烤鸡翅");
    static Random RANDOM = new Random();
    static String cooking() {
        return MENU.get(RANDOM.nextInt(MENU.size()));
    }
    public static void main(String[] args) {

        //newFixedThreadPool可能会发生线程数不同导致的程序无法继续进行下去 区别于死锁
        //不同的任务使用不同的线程池 避免饥饿发生
        ExecutorService waiterPool = Executors.newFixedThreadPool(1);
        ExecutorService cookPool = Executors.newFixedThreadPool(1);

        waiterPool.execute(() -> {//第一个线程处理点餐(无返回结果) 然后在线程池中找另一个线程去做菜
            log.debug("处理点餐...");
            Future<String> f = cookPool.submit(() -> {//第二个线程有返回结果
                log.debug("做菜");
                return cooking();
            });
            try {//点餐线程等待f.get() 直到线程返回 做菜线程 完成做菜工作
                log.debug("上菜: {}", f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        waiterPool.execute(() -> {
            log.debug("处理点餐...");
            Future<String> f = cookPool.submit(() -> {
                log.debug("做菜");
                return cooking();
            });
            try {
                log.debug("上菜: {}", f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }
}
