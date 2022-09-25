package cn.ahpu.juc;

import org.junit.Test;

public class VolatileTest {

    private volatile int inc=0;

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        for (int i=0;i<10;i++){
            new Thread(){
               @Override
               public void run(){
                   for (int j=0;j<1000;j++){
                       volatileTest.increase();
                   }
               }
            }.start();
        }

        //保证前面线程都执行完
//        while (Thread.activeCount()>0){
//            Thread.yield();
//        }
        Thread.sleep(1000);

        //1.解决方法用synchronized   2.采用Lock   3.CAS循环的方式来保证其原子性
        System.out.println(volatileTest.inc);//结果不是10000

    }

    private void increase(){
        this.inc++;
    }



    @Test
    public void test01(){

    }


}
