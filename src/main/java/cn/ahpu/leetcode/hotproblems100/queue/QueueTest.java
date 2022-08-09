package cn.ahpu.leetcode.hotproblems100.queue;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class QueueTest {

    public static void main(String[] args){
        PriorityQueue<People> queue = new PriorityQueue<People>(11,
                new Comparator<People>() {
                    public int compare(People p1, People p2) {
                        return p2.age - p1.age;
                    }
                });

        for (int i = 1; i <= 10; i++) {
            queue.add(new People("张"+ i, (new Random().nextInt(100))));
        }
        while (!queue.isEmpty()) {
            System.out.println(queue.poll().toString());
        }
    }
}

class People {
    String name;
    int age;
    public People(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String toString() {
        return "姓名："+name + " 年龄：" + age;
    }

    @Test
    public void testPriorityQueue(){
        //默认采用的是最小堆实现的
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10,new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a-b; //if a>b 则交换，so这是递增序列
            }
        });
        queue.offer(13);
        queue.offer(9);
        int len = queue.size();
        for(int i=0;i<len;i++){
            System.out.println(queue.poll());//插入进去会排序
        }
        //输出 9  13
        //默认采用的是最小堆实现的
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(10);
        queue2.offer(11);
        queue2.offer(9);
        len = queue2.size();
        for(int i=0;i<len;i++){
            System.out.println(queue2.poll());
        }
        //输出 9， 11
    }


}
