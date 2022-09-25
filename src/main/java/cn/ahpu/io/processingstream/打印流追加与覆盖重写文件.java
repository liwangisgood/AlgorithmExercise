package cn.ahpu.io.processingstream;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;


//FileOutputStream 构造器实现文件追加写入或覆盖写入
//PrintStream实现了Appendable接口，实现对输出流的追加
@Component
public class 打印流追加与覆盖重写文件 {
    public static void main(String[] args) throws IOException {//FileNotFoundException父类IOException

        String filePath = "E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\processingstream\\追加或覆盖文件1.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file);//对目标文件写入，每次运行从覆盖开始
        PrintStream printStream = new PrintStream(fileOutputStream);//PrintStream实现Appendable了追加
        printStream.append("这里追加了一句").append("追加了第二句话");//首先覆盖了文件原先内容，对输出流追加：这里追加了一句追加了第二句话
        printStream.append("追加了第三句话");
        printStream.write("liwang is a HANDSOME 帅哥".getBytes(StandardCharsets.UTF_8));//打印流PrintStream append实现追加 write都可以在同一条流上运行
        printStream.write("xiaoji is a HANDSOME 美女".getBytes(StandardCharsets.UTF_8));//打印流PrintStream append实现追加 write都可以在同一条流上运行原先基础上追加

    }

    @Test
    public void test01() throws IOException {
        String filePath = "E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\processingstream\\追加或覆盖文件2.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);//对目标文件写入，字节将被写入文件的末尾而不是开头
        PrintStream printStream = new PrintStream(fileOutputStream);//PrintStream实现Appendable了追加
        printStream.append("这里追加了一句").append("追加了第二句话");//首先覆盖了文件原先内容，对输出流追加：这里追加了一句追加了第二句话
        printStream.append("追加了第三句话");
        printStream.write("liwang is a HANDSOME 帅哥".getBytes(StandardCharsets.UTF_8));//        无file.close()，java.io.File是文件对象 不是文件流(节点流)
    }

}
