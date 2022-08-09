package cn.ahpu.review.io.processingstream;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class 缓冲流文件复制器 {
    public static void main(String[] args) throws IOException {

        String sourcePath="C:\\Users\\X10ti-S\\Desktop\\java正则表达式大全(参考).java";
        String destPath="E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\java正则表达式大全(参考) - 副本.txt";
        copyFileOrDirectory(sourcePath,destPath);
//        write(new byte[3], 0,3);//throw不需要在方法上抛出上抛出异常

    }

    //文件或目录复制器
    private static void copyFileOrDirectory(String sourcePath, String destPath) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourcePath));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPath));

        byte[] bytes = new byte[1024];
        /*while (bufferedInputStream.read(bytes)!=-1){
            *//*调用write(bytes),最后写入文件时候 可能会多写入
            * 解决：*//*
            bufferedOutputStream.write(bytes);
        }*/


        //
        int len=0;
        while ((len=bufferedInputStream.read(bytes))!=-1){
            /*调用write(bytes),最后写入文件时候 可能会多写入
             * 解决：1、上面最后1024字节读入时候乱码，2、部分未正确写入到文件中，3、多写入字节造成复制文件过大*/
            bufferedOutputStream.write(bytes,0,len);
        }

        //强制将任何缓冲的输出字节写出到底层输出流
        bufferedOutputStream.flush();//不加该方法，无法将内容刷新到文件中
    }

    @Test
    public void test01(){
        byte[] bytes = new byte[10];
        Arrays.fill(bytes,0,5,(byte) 1);
        System.out.println(Arrays.toString(bytes));//[1, 1, 1, 1, 1, 0, 0, 0, 0, 0]
    }





}
