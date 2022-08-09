package cn.ahpu.nowcoder.basis1_1;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.FormatFlagsConversionMismatchException;

public class Sort {

    static int[] arr = {3, 5, 3};//{2, 1, 3, 4, 5, 7, 8, 9, 0, 6}

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
//        int[] bubbleSortResult = bubbleSort(arr);//普通版冒泡排序
        System.out.println(System.currentTimeMillis() - l);
//        int[] bubbleSortResult = bubbleSort01(arr);//不做无用功冒牌排序改进版
//        int[] bubbleSortResult = bubbleSort02(arr);
//        int[] bubbleSortResult = bubbleSort2(arr);//不理解
//        traverse(bubbleSortResult);

//        int[] insertSortResult = InsertSort(arr);//普通插入排序
//        int[] insertSortResult = InsertSort01(arr);//插入排序改进版 暂存元素 移动元素
        int[] insertSortResult = InsertSort02(arr);//二分插入排序
        traverse(insertSortResult);

    }

    private static int[] InsertSort02(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            int left = 0, right = i - 1, mid, index = i;
            //二分插入 有序个数奇数,偶数,确定后移从有序元素何处开始right
            while (left <= right) {
                mid = left + (right - left) / 2;
                if (arr[mid] > temp) {
                    right = mid - 1;
                } else if (arr[mid] <= temp) {
                    left = mid + 1;
                }
            }
            while (left < index) {
                arr[index - 1] = arr[index];
                index--;
            }
            arr[left] = temp;
        }
        return arr;
    }

    private static int[] InsertSort01(int[] arr) {
        int temp, j, i;
        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {//
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    private static int[] InsertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    private static int[] bubbleSort2(int[] ints) {
        int len = ints.length;
        int flag = len;
        while (flag > 0) {//如果flag>0则排序结束
            flag = 0;
            for (int i = 1; i < len; i++) {
                if (ints[i - 1] > ints[i]) { //前面大于后面则交换数据
                    int temp = ints[i];
                    ints[i] = ints[i - 1];
                    ints[i - 1] = temp;
                    flag = i; //设置最新边界
                }
            }
            len = flag;//记录遍历的边界
        }
        return ints;
    }

//    private static int[] bubbleSort02(int[] arr) {
//        int min = arr[0], max = arr[arr.length - 1];
//        boolean flag = true;
//        for (int i = 0; flag && i < arr.length - 1; i++) {
//            flag = false;
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    flag = true;
//                    swap(arr, arr[j], arr[j + 1]);
//                }
//            }
//            for (int k = arr.length - 1; k > i; k--) {
//                flag = false;
//                if (arr[k] < arr[k - 1]) {
//                    flag = true;
//                    swap(arr, arr[k], arr[k - 1]);
//                }
//            }
//        }
//        return arr;
//    }

    private static int[] bubbleSort01(int[] arr) {
        boolean flag = true;
        for (int i = 0; flag && i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    swap(arr, arr[j], arr[j + 1]);
                }
            }
        }
        return arr;
    }

    /**
     * 增强for 循环索引遍历
     * Arrays.stream()暂时不熟
     *
     * @param bubbleSortResult
     */
    private static void traverse(int[] bubbleSortResult) {
        //1.
//        for (int i : bubbleSortResult) {
//            System.out.print(i + " ");
//        }

        //3.
        Arrays.stream(bubbleSortResult).forEach(x -> {
            System.out.print(x + " ");
        });
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, arr[j], arr[j + 1]);
                }
            }
        }
        return arr;
    }

    /**
     * 交换数组两数
     *
     * @param arr
     * @param i
     * @param i1
     */
    private static void swap(int[] arr, int i, int i1) {
        //1.三个水杯 temp空杯子  arr[i]和arr[i1]两个交换
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
//        //2.西瓜芝麻混合一起,取出一样 剩下自然得
//        arr[i]=arr[i]+arr[i1];
//        arr[i1]=arr[i]-arr[i1];
//        arr[i]=arr[i]-arr[i1];
//        //3.西瓜芝麻混合在一起 类似效果
//        arr[i]=arr[i]^arr[i1];
//        arr[i1]=arr[i]^arr[i1];
//        arr[i]=arr[i]^arr[i1];

    }

}
