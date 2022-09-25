package cn.ahpu.acm.java2022;

import java.util.Calendar;

//https://blog.csdn.net/kiwi_berrys/article/details/111461347

public class 第二题_纪念日 {
    public static void main(String[] args) {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(1921, 7, 24);


        Calendar cal2 = Calendar.getInstance();
        cal2.set(2020, 7, 2);
        long l = cal2.getTime().getTime() - cal1.getTime().getTime();
        System.out.println(l/1000/60);


    }
}
