package cn.ahpu.acm.simple;

import java.util.Calendar;
import java.util.Scanner;

import static java.time.Year.isLeap;

/**
 * @author:liwang
 * @date: 2022/4/7 0:41
 * @Description:TODO
 * @Algorithm
 */
//https://blog.csdn.net/m0_52155263/article/details/121503772

public class 第二题_纪念日 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long sun = 0;
		long allDaysPerCommonYear = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31;
		sun = 9 + 31 + 30 + 31 + 30 + 31  +  31 + 29 + 31 + 30 + 31 + 30;
		for (int i = 1922; i <= 2019; i++) {
			sun += isLeap(i) ? allDaysPerCommonYear + 1 : allDaysPerCommonYear;
		}
		sun = sun * 24 * 60;
		System.out.println(sun);

	}


}
