package cn.ahpu.io;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class FileOperation {
    public static void main(String[] args) {

    }

    //文件创建
    @Test
    public void test01() throws IOException {
        File file = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\java正则表达式大全(参考) - 副本.txt");

//        System.out.println(file.mkdir());
//        System.out.println("file:"+file);//文件已存在 不可创建相同名称目录

        File file1 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\javaRegex.txt");
        System.out.println(file.createNewFile());//文件已存在

//        File file2 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io", "jdk8文档中文版1.url");
//        System.out.println(file2.delete());

        //可以移动文件file(文件磁盘存在)到其他文件(文件磁盘不存在) 可重名;不在同一目录不可重名
//        System.out.println(file.renameTo(file1));
//        System.out.println("file:"+file);

        System.out.println(file1.length());
        System.out.println(new File("C:\\Users\\X10ti-S\\Desktop\\MyBatis").length());

        //文件重命名移动其他目录,只有对象 没有磁盘存储
        System.out.println(file.getAbsolutePath());
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile.getAbsolutePath());
        System.out.println("file1:"+file1.getAbsolutePath());

        //文件重命名移动其他目录，(如果文件不存在或发生 IO 错误，则为 0L)
        System.out.println(file.getFreeSpace());//返回文件或目录所在磁盘分区中剩余未使用容量大小，字节为单位
        System.out.println(file.getUsableSpace());//返回此抽象路径名命名的分区上此虚拟机可用的字节数
        System.out.println(file.getTotalSpace());//返回由此抽象路径名命名的分区的大小
        System.out.println(file.length());//返回文件或目录字节大小
        System.out.println("最后修改还时间："+new Date(file.lastModified()));

    }



    /* 0
     0
     0
     0
    最后修改还时间：Thu Jan 01 08:00:00 CST 1970*/
    @Test//文件实体不存在
    public void test02(){
        File file = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\Scanner循环输入输出.java");

        //若文件或目录在磁盘中不存在 则下列均会返回0
        System.out.println(file.getFreeSpace());//返回文件或目录所在磁盘分区中剩余未使用容量大小，字节为单位
        System.out.println(file.getUsableSpace());//返回此抽象路径名命名的分区上此虚拟机可用的字节数
        System.out.println(file.getTotalSpace());//返回由此抽象路径名命名的分区的大小
        System.out.println(file.length());
        System.out.println("最后修改还时间："+new Date(file.lastModified()));
        LocalDateTime.now();

    }

    @Test
    public void test03(){
        File file = new File("E:\\GoLink\\GoLink1");
        System.out.println(file.canExecute());//false
        System.out.println(file.canRead());   //false
        System.out.println(file.canWrite());  //false
        System.out.println(file.isDirectory());//false 目录磁盘不存在false

        System.out.println("-------------------------");
        File file1 = new File("C:\\Windows\\Cursors\\helpsel.svg");
        System.out.println(file1.canExecute());//true
        System.out.println(file1.canRead());//true
        System.out.println(file1.canWrite());//true
        System.out.println(file1.isFile());//true目录磁盘存在

    }

    @Test
    public void test04(){
        File file = new File("C:\\Users\\X10ti-S\\Desktop\\java正则表达式大全(参考) - 副本.java");
        File file1 = new File("C:\\Users\\X10ti-S\\Desktop\\java.java");
        System.out.println(file.renameTo(file1));//true同一目录下重命名文件成功

    }

    @Test
    public void test05(){
        File file = new File("C:\\Users\\X10ti-S\\Desktop\\java.java");//磁盘存在文件java.java被移动到下面网站目录下成为java.txt数据内容没变
        File file1 = new File("C:\\Users\\X10ti-S\\Desktop\\网站\\java.txt");//虚拟抽象文件
        System.out.println(file.renameTo(file1));//true不同目录下移动文件 并修改文件后缀

    }

}
