package cn.ahpu.nowcoder.basis1_1;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Sort {

    static int[] arr = {2, 1, 3, 4, 5, 7, 8, 9, 0, 6};
//    static int[] arr={3, 5, 3};

    public static void main(String[] args) {
        Instant start = Instant.now();

//        int[] bubbleSortResult = bubbleSort(arr);//普通版冒泡排序
//        int[] bubbleSortResult = bubbleSort01(arr);//不做无用功冒牌排序改进版
//        int[] bubbleSortResult = bubbleSort2(arr);//不理解
//        traverse(bubbleSortResult);

//        int[] insertSortResult = InsertSort(arr);//有序 无序 这方法还带有比较冒泡逐个交换 不是直接插入排序 31000000ns  31ms 0s
//        int[] insertSortResult = InsertSort01(arr);//直接插入排序 暂存元素temp 移动元素插入temp值 29000000ns  29ms 0s
//        int[] insertSortResult = InsertSort02(arr);//二分插入排序
//        traverse(insertSortResult);
//        int[] shellSortResult = shellSort(arr);//希尔排序,分组 直接插入排序 分组间隔减半

        int[] mergeSortResult = mergeSort(arr, 0, arr.length - 1);//归并排序

        traverse(mergeSortResult);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);//返回经历纳秒
        System.out.println("花费:" + duration.getNano() + "ns " + " " + duration.toMillis() + "ms" + " " + duration.getSeconds() + "s");

    }

    private static int[] mergeSort(int[] arr, int l, int r) {
        if (r == l) {
            return null;
        }
        int mid = l + ((r - l) >> 1);
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
        return arr;
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (int i1 = 0; i1 < help.length; i1++) {
            arr[l+i1]=help[i1];
        }


//        AtomicInteger index = new AtomicInteger(l);
//        Arrays.stream(help).forEach(x -> arr[index.getAndIncrement()] = x);

    }

    private static int[] shellSort(int[] arr) {//arr.length数目>1都可以进行希尔排序
        int gap = arr.length / 2;
        while (gap >= 1) {

            for (int a = 0; a < gap; a++) {
                for (int i = a + gap; i < arr.length; i += gap) {
                    int temp = arr[i], index = i;
                    for (int j = i - gap; j >= 0; j -= gap) {//这里的j应该每次都比i小 而且是插入排序紧邻小 进行比较
                        if (arr[j] > temp) {
                            index -= gap;
                        }
                    }
                    int n = (i - index) / gap, k;
                    for (k = 0; k < n; k++) {
                        arr[i - k * gap] = arr[i - (k + 1) * gap];
                    }
                    arr[i - k * gap] = temp;
                }
            }
            gap /= 2;
        }
        return arr;
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
                } else if (arr[mid] <= temp) {//最后导致arr[left]>temp 即将left及其之后索引向右移动
                    left = mid + 1;
                }
            }
            while (left < index) {
                arr[index] = arr[index - 1];
                index--;
            }
            arr[left] = temp;
        }
        return arr;
    }

    //无序区第一个元素与有序区排好 不再向有序区前面元素进行比较
    private static int[] InsertSort01(int[] arr) {
        int temp, j, i;
        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
        return arr;
    }

    //插入排序中有序区会和无序区第一个元素进行冒泡排序
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


    //普通冒泡排序的变种 还是普通冒泡排序
    private static int[] bubbleSort2(int[] ints) {
        int len = ints.length;
        int flag = len;//起始是索引不到的临界边界
        while (flag > 0) {//如果flag>0则排序结束
            flag = 0;
            for (int i = 1; i < len; i++) {
                if (ints[i - 1] > ints[i]) { //前面大于后面则交换数据
                    int temp = ints[i];
                    ints[i] = ints[i - 1];
                    ints[i - 1] = temp;
                    flag = i; //设置最新边界 最新边界之前均是未冒泡排序好的数组排序 flag表示该次循环冒泡 将数组中未排序的最大值放入整体有序正确位置
                }
            }
            len = flag;//记录遍历的边界
        }
        return ints;
    }


    private static int[] bubbleSort01(int[] arr) {
        boolean flag = true;
        for (int i = 0; flag && i < arr.length; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
//                    swap(arr, arr[j], arr[j + 1]);
                    swap(arr, j, j + 1);
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
//                    swap(arr, arr[j], arr[j + 1]);
                    swap(arr, j, j + 1);
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
