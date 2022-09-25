package cn.ahpu.io.file;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;

@Component
public class FileTest {
    public static void main(String[] args) {

    }

    /**
     * 文件或目录的创建 删除
     * createNewFile() mkdir()同时只有一个返回true创建成功
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
    public void test02(){
        File dir1 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\123");
        File dir2 = new File("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\io\\file\\new123");
        System.out.println(dir1.renameTo(dir2));
    }

    //获取
    @Test
    public void test03(){

    }
}
