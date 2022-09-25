package cn.ahpu.juc;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

//ReentrantLock 不同线程对同一把锁竞争,只有当前线程使用完后 另一个线程才能抢到锁 即,可重入性 不可中断性
public class NoReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(() -> {
            try {
                reentrantLock.lock();
                System.out.println("第1次获取这个锁，这个锁是:"+reentrantLock);
                int index = 1;
                while (true) {
                    try {
                        reentrantLock.lock();
                        System.out.println("第"+(++index)+"次获取这个锁，这个锁是:"+reentrantLock);
                        if (index == 100 ) {
                            break;
                        }
                    } finally {
//                        reentrantLock.unlock();
                    }
                }
                reentrantLock.unlock();//测试表明释放锁少释放了九把锁 当前线程无法释放锁 其他线程也无法获取

            } finally {
                reentrantLock.unlock();
            }
        }).start();

        /**
         * 构建第二个线程 看是否可以获取锁
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    for (int i = 0; i < 50; i++) {
                        System.out.println("threadName:" + Thread.currentThread().getName());
                        try {
                            Thread.sleep(new Random().nextInt(200));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } finally {
                    reentrantLock.unlock();
                }
            }
        }).start();
    }

}
