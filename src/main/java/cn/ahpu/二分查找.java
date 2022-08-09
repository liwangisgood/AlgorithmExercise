package cn.ahpu;

import cn.ahpu.leetcode.hotproblems100.array.Util;

import java.util.Arrays;

public class 二分查找 {
    public static void main(String[] args) {
        int[] ints = Util.generateRandomIntArray(4, 3, 20);//[3,20]
        System.out.println(ints);
        Util.traversalArray(ints);
        Arrays.sort(ints);
        Util.traversalArray(ints);
//        int i = Arrays.binarySearch(ints, 5);//二分查找，未先排序结果则未定义
        int i1 = binarySearch(ints, 5);
        System.out.println(i1+" ");
    }

    /*
    * 版本1：找不到索引：会循环不停止
    * 版本2：通过对low high范围赋值mid+ - 1操作，核心：跳出循环
    *
    * */
    private static int binarySearch(int[] array,int key) {
        int low=0;
        int high=array.length-1;
        int mid=(low+high)/2;

//        for (int i=low;i<=high;i++){
        while (low<=high){
            if (array[mid]>key){
                high=mid;
            }else if(array[mid]<key) {
                low=mid;
            }else{
                return mid;
            }
            //调试经过的选中代码，左边的变量值是还未执行的，
            mid=(low+high)/2;

        }
        return -1;
    }


    // Like public version, but without range checks.
    private static int binarySearch0(int[] a, int fromIndex, int toIndex,
                                     int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }


}
