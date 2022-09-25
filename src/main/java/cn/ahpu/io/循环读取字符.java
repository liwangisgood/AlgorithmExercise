package cn.ahpu.io;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//键盘输入连续字符串，回车逐个字符输出。可以不断循环重复直到输出字符包含s时
@Component
public class 循环读取字符 {
    public static void main(String[] args) throws IOException {

        //InputStreamReader是转换流，在此基础上又添加了，缓冲流BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c = '\0';
        int count = 0;
        while (true) {
            c = (char) bufferedReader.read();//bufferedReader.readLine()
            if (c!='\n'){//当有回车键时候，回车键字符(换行符)会被读取，输出时控制台会换行
                System.out.println(++count + "行：" + c);
            }
            if (c == 's') {
                System.out.println("结束！！！");
                break;
            }
        }
    }
}
