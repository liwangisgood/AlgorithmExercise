package cn.ahpu.juc;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {

    }

}

/*
 * 使用ReentrantLock类实现同步
 * */
class MyReenrantLock implements Runnable{
    //向上转型
    private Lock lock = new ReentrantLock();
    public void run() {
        //上锁
        lock.lock();
        for(int i = 0; i < 5; i++) {
            System.out.println("当前线程名： "+ Thread.currentThread().getName()+" ,i = "+i);
        }
        //释放锁
        lock.unlock();
    }
}
class MyLock {
    public static void main(String[] args) {
        MyReenrantLock myReenrantLock =  new MyReenrantLock();
        Thread thread1 = new Thread(myReenrantLock);
        Thread thread2 = new Thread(myReenrantLock);
        Thread thread3 = new Thread(myReenrantLock);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

/*
 * 错误的使用Condition实现等待、通知
 * */
class MyCondition01 implements Runnable{
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void run() {
        try {
            //上锁
            lock.lock();
            System.out.println("当前线程名:"+Thread.currentThread().getName()+" 开始等待时间："+System.currentTimeMillis());
            //线程等待 我们必须在condition.await()方法调用前用lock.lock()代码获得同步监视器
            condition.await();
            System.out.println("我陷入了等待...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放锁
            lock.unlock();
            System.out.println("锁释放了!");
        }
    }
}
class MyLock01{
    public static void main(String[] args) {
        MyCondition01 myCondition = new MyCondition01();
        Thread thread1 = new Thread(myCondition,"线程1");
        thread1.start();
    }
}

/*
 * 使用Condition实现等待、通知
 * */
class MyCondition02 implements Runnable{
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public void run() {
        try {
            //上锁
            lock.lock();
            System.out.println(" 开始等待时间："+System.currentTimeMillis()+" "+"当前线程:"+ Thread.currentThread().getName());
            System.out.println("我陷入了等待...");
            //线程等待
            condition.await();
            //释放锁
            lock.unlock();
            System.out.println("锁释放了!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //通知方法
    public void signal(){
        try {
            lock.lock();
            System.out.println("结束等待时间："+System.currentTimeMillis()+" "+"当前线程:"+ Thread.currentThread().getName());
            //通知等待线程
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
class MyLock02{
    public static void main(String[] args) throws InterruptedException {
        MyCondition02 myCondition = new MyCondition02();
        Thread thread1 = new Thread(myCondition,"线程1");
        thread1.start();
        Thread.sleep(3000);
        myCondition.signal();
    }
}

//可重入就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁
class WhatReentrant {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}

// 演示可重入锁是什么意思
class WhatReentrant2 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("第1次获取锁，这个锁是：" + lock);
                    int index = 1;
                    while (true) {
                        try {
                            lock.lock();
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);
                            try {
                                Thread.sleep(new Random().nextInt(200));
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if (index == 10) {
                                break;
                            }
                        } finally {
                            lock.unlock();
                        }

                    }
                } finally {
                    lock.unlock();
                }

                lock.lock();
                System.out.println(lock);
                lock.unlock();
            }
        }).start();
    }
}

/*
 * 生产者、消费者模式
 * 一对一交替打印
 * */
class MyServer{
    private ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public Boolean flag = false;
    public void set() {
        try {
            lock.lock();
            while(flag) {
                condition.await();
            }
            System.out.println("当前生产者线程名："+Thread.currentThread().getName()+" hello");
            flag = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get() {
        try {
            lock.lock();
            while(!flag) {
                condition.await();
            }
            System.out.println("当前消费者线程名："+Thread.currentThread().getName()+" lemon");
            flag = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class MyCondition1 extends Thread{
    private MyServer myServer;
    public MyCondition1(MyServer myServer) {
        super();
        this.myServer = myServer;
    }
    public void run() {
        for(int i = 0 ;i < Integer.MAX_VALUE;i++) {
            myServer.set();
        }
    }
}
class MyCondition2 extends Thread{
    private MyServer myServer;
    public MyCondition2(MyServer myServer) {
        super();
        this.myServer = myServer;
    }
    public void run() {
        for(int i = 0 ;i < Integer.MAX_VALUE;i++) {
            myServer.get();
        }
    }
}
class MyLock03{
    public static void main(String[] args) throws InterruptedException {
        MyServer myServer = new MyServer();
        MyCondition1  myCondition1 = new MyCondition1(myServer);
        MyCondition2  myCondition2 = new MyCondition2(myServer);
        myCondition1.start();
        myCondition2.start();
    }
}

/*
 * 生产者、消费者模式
 * 多对多交替打印
 * */
class MyServer01{
    private ReentrantLock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();
    public Boolean flag = false;
    public void set() {
        try {
            lock.lock();
            while(flag) {
                System.out.println("可能会有连续的hello进行打印");
                condition.await();
            }
            System.out.println("当前线程名："+Thread.currentThread().getName()+" hello");
            flag = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void get() {
        try {
            lock.lock();
            while(!flag) {
                System.out.println("可能会有连续的lemon进行打印");
                condition.await();
            }
            System.out.println("当前线程名："+Thread.currentThread().getName()+" lemon");
            flag = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
class MyCondition11 extends Thread{
    private MyServer myServer;
    public MyCondition11(MyServer myServer) {
        super();
        this.myServer = myServer;
    }
    public void run() {
        for(int i = 0 ;i < Integer.MAX_VALUE;i++) {
            myServer.set();
        }
    }
}
class MyCondition22 extends Thread{
    private MyServer myServer;
    public MyCondition22(MyServer myServer) {
        super();
        this.myServer = myServer;
    }
    public void run() {
        for(int i = 0 ;i < Integer.MAX_VALUE;i++) {
            myServer.get();
        }
    }
}
class MyLock04{
    public static void main(String[] args) throws InterruptedException {
        MyServer myServer = new MyServer();
        MyCondition11[]  myCondition1 = new MyCondition11[10];
        MyCondition22[]  myCondition2 = new MyCondition22[10];
        for(int i = 0; i < 10; i++) {
            myCondition1[i] = new MyCondition11(myServer);
            myCondition2[i] = new MyCondition22(myServer);
            myCondition1[i].start();
            myCondition2[i].start();
        }
    }
}


