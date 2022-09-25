package cn.ahpu.io;

import org.springframework.stereotype.Component;

import java.util.Scanner;

//控制台输入 循环读出 以空格为边界
@Component
public class Scanner循环输入输出 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count=0;
        while (true){
            String str1 = sc.nextLine();//sc.nextLine()
            if ("over".equals(str1)){
                System.out.println("结束输入!!!");
                break;
            }
            System.out.println((++count)+"行："+str1);
        }
    }
}
