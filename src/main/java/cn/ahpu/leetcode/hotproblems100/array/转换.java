package cn.ahpu.leetcode.hotproblems100.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 转换 {

    //初始化数组
    static int arr2[]=new int[]{1,2,3,4,5};
    static String[] array1={"马超","马云","关羽","刘备","张飞"};
    static String[] array2=new String[]{"黄渤","张艺兴","孙红雷","小猪","牙哥","黄磊"};
    static String[] array=new String[5];

    public static void main(String[] args) {
        //将数组转成set集合
        Set<String> set=new HashSet<String>(Arrays.asList(array2));
        System.out.println("set:"+set);//set:[小猪, 牙哥, 黄渤, 黄磊, 孙红雷, 张艺兴]
    }

    @Test
    public  void main(){
        //从array中创建arraylist
        ArrayList<String> arrayList=new ArrayList<String>(Arrays.asList(array1));
        System.out.println("arrayList:"+arrayList);//arrayList:[马超, 马云, 关羽, 刘备, 张飞]
    }

}
