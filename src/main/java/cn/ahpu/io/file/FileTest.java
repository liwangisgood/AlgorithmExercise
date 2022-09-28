package cn.ahpu.io.file;


import lombok.Cleanup;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;

@Component
public class FileTest {
    public static void main(String[] args) {

    }

    /**
     * 文件或目录的创建 删除
     * createNewFile() mkdir()同时只有一个返回true创建成功
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        File file = new File("123");
        System.out.println(file);//磁盘中该文件还未存在
        System.out.println(file.delete());
        System.out.println(file.createNewFile());//返回true创建文件成功 在项目目录下
        System.out.println(file.delete());
        System.out.println(file.mkdir());//返回true 创建目录成功 在项目目录下
//        System.out.println(file.delete());
    }

    //文件或目录的重命名移动 将123目录以及目录所有内容完全被new123所取代
    @Test
    public void test02() {
        long l = System.currentTimeMillis();
        LocalTime now = LocalTime.now();
        File dir1 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\123");
        File dir2 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\file\\new123");
        System.out.println(dir1.renameTo(dir2) + " 耗时ms：" + (System.currentTimeMillis() - l) + " 耗时ns:" + Duration.between(now, LocalTime.now()).getNano());

    }

    static String readFirstLineFromFileWithFinallyBlock(String path) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader(path));
//        try {
//            return br.readLine();
//        } catch (IOException e) {
//            System.out.println("这里是try块的异常");
//        } finally {
//            if (br != null) br.close();
//        }
//        return "默认返回";

//        System.out.println("-------------------------------");
//        //try-with-resources语句能够帮你自动调用资源的close()函数关闭资源不用到finally块。
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
//            return br.readLine();
//        } catch (IOException e) {
//            System.out.println("这里是try块的异常");
//        }
//        return "默认返回";

        System.out.println("-------------------------------");
        @Cleanup BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } catch (IOException e) {
            System.out.println("这里是try块的异常");
        }

        return "默认返回";
    }
    //获取
    @Test
    public void test03() throws IOException {
        System.out.println(readFirstLineFromFileWithFinallyBlock("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\javaRegex.txt"));
    }
}
