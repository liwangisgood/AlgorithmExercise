package cn.ahpu.review.io.processingstream;


import org.junit.Test;

import java.io.*;

public class 字符字节转换及编码 {
    public static void main(String[] args) throws IOException {//都属于IOException

        String filePath = "E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\processingstream\\追加或覆盖文件1.txt";
        File file = new File(filePath);
        FileInputStream fileOutputStream = new FileInputStream(file);//对目标文件写入，每次运行从覆盖开始
        InputStreamReader inputStreamReader = new InputStreamReader(fileOutputStream,"UTF-8");//创建一个使用命名字符集的 InputStreamReader
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str="";
        while ((str=bufferedReader.readLine())!=null){//包含行内容的字符串，不包括任何行终止字符，如果已到达流的末尾，则返回 null
            System.out.println(str);//utf-8存储字节,GBK读取会出现乱码;utf-8读取不会出现乱码
        }
        String encoding = inputStreamReader.getEncoding();//inputStreamReader的套接缓冲流不能没有该方法使用
        System.out.println(encoding);//UTF8


    }

    @Test
    public void test01(){
        String str1=null;
        System.out.println(str1!=null);
    }
}
