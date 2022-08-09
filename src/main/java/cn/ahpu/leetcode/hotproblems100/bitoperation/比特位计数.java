package cn.ahpu.leetcode.hotproblems100.bitoperation;

import cn.ahpu.leetcode.hotproblems100.array.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

//https://leetcode.cn/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/
public class 比特位计数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arrayLists = new ArrayList<>();//按照题目优化一下 改为固定数组 int[] array = new int[n+1]
        for (int i = 0; i <= n; i++) {
            arrayLists.add(countBinaryNumBits(i));//array[countBinaryNumBits(i)]
        }

        System.out.println(arrayLists);

    }

    private static int countBinaryNumBits(int i) {
        int count = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (i != 0) {
            int temp = i % 2;
            i /= 2;
            arrayList.add(temp);
        }
        for (Integer integer : arrayList) {
            if (integer == 1) {
                count++;
            }
        }
        return count;

    }


}

