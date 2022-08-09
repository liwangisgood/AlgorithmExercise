package cn.ahpu.acm.java2019;


import java.math.BigInteger;

public class 第三题_数列求值 {


    public static void main(String[] args) {
        int[] array=new int[20190324];
        array[0]=1;
        array[1]=1;
        array[2]=1;
        for (int i = 3; i < array.length; i++) {
            array[i]=array[i-1]+array[i-2]+array[i-3];
            array[i]%=10000;
        }
        System.out.printf(""+array[20190323]);
    }

/*    public static void main(String[] args) {
        BigInteger[] bg=new BigInteger[20190324];
        bg[0]=BigInteger.ONE;
        bg[1]=BigInteger.ONE;
        bg[2]=BigInteger.ONE;
        for (int i=3;i<20190324;i++){
            bg[i]=bg[i-1].add(bg[i-2]).add(bg[i-3]);
            bg[i].mod(new BigInteger("10000"));
        }
        System.out.printf(""+bg[20190323]);

    }*/

/*    static int f(int n) {//Exception in thread "main" java.lang.StackOverflowError
        if (n == 1 || n == 2 || n == 3) {
            return 1;
        } else {
            return f(n - 1) + f(n - 2) + f(n - 3);
        }
    }

        public static void main (String[]args){
            int a = f(20190324) % 10000;
            System.out.println(a);
        }*/

}


