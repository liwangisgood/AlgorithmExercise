package cn.ahpu.array;

public class ArrayUtil {
    public static <T> void traverse(T[] array){
        for (T t : array) {
            System.out.println(t+" ");
        }
        System.out.println();
    }
}
