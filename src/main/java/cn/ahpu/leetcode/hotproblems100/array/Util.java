package cn.ahpu.leetcode.hotproblems100.array;

import java.util.Random;

//定义一个数组工具类
public class Util {

    //返回一个随机数组 参数：数组元素个数 数组范围[min,max]，这部等价于[min,max+1)
    public static int[] generateRandomIntArray(int length, int min, int max) {

        //Creates a new random number generator
        Random random = new Random();

        //random.nextInt(max) % (max - min+1) ,核心思想：random.nextInt(max)最大值max-1 小于 后面的(max-min+1)
        //min>0,max>max-min+1,上行式子范围：[0,max-min]
        //min=0,max>max+1,上上行式子范围：[0,max]
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(max) % (max - min + 1) + min;
        }
        return array;
    }

    //遍历数组,用一行表示数组输出
    public static void traversalArray(int[] array) {
        for (int i : array) {
            System.out.print( i+" " );
        }
        System.out.println();
    }

 /*   //排序数组
    public static int[] sortArray(int[] array){

    }*/
}
