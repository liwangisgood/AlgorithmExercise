package cn.ahpu.leetcode.hotproblems100.array;


import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

//https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
public class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {

        System.out.println(findMedianSortedArrays(new int[]{5, 4, 3, 2,}, new int[]{9, 8, 7, 6}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int len1 = nums1.length;
        int len2 = nums2.length;
        int min = Math.min(len1, len2);
        int[] ints = new int[len1 + len2];
        int index=0;
        int i = 0, j = 0;
        for (; i < len1 &&j < len2;) {
            if (nums1[i] < nums2[j]) {
                ints[index++]=nums1[i++];
            }else {
                ints[index++]=nums2[j++];
            }
        }

        while (j<len2){
            ints[index++]=nums2[j];
            j++;
        }
        while (i<len1){
            ints[index++]=nums1[i];
            i++;
        }

        for (int k:ints){
            System.out.print(" "+k);
        }
        System.out.println(ints);
        int m=len1+len2;
        if (m%2==0){
            return (ints[m/2]+ints[m/2-1])/2.0;
        }else {
            return ints[m/2];
        }

    }
}
