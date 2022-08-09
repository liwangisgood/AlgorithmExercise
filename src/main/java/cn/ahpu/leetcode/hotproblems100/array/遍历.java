package cn.ahpu.leetcode.hotproblems100.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//https://blog.csdn.net/qq_45696377/article/details/109553685
public class 遍历 {

    int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};

    public static void main(String[] args) {
        int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        for (int i = 0; i < Arr.length; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                System.out.print(Arr[i][j] + " ");
            }
        }
    }

    //foreach语句遍历
    @Test
    public void test01() {
        int Arr[][] = {{5, 7, 15}, {8, 4, 11}, {3, 6, 13}};
        for (int[] ints : Arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
        }
    }

    @Test
    public void test02() {

        for (int i = 0; i < Arr.length; i++) {
            for (int i1 = 0; i1 < Arr[i].length; i1++) {
                System.out.print(Arr[i][i1]+" ");
            }
        }
    }

    @Test
    public void test03(){
        int[] a={1,2,3,4};
        //源码考虑数组为 null 长度为0  长度非0，StringBuilder b = new StringBuilder();拼接
        String a1= Arrays.toString(a);
        System.out.println(a1);//[1, 2, 3, 4]

        String a2 = Arrays.deepToString(Arr);
        System.out.println(a2);//[[5, 7, 15], [8, 4, 11], [3, 6, 13]]

    }


}
