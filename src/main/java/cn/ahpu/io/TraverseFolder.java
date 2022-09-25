package cn.ahpu.io;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.Arrays;

//应用计算文件夹字节大小等，文件数目 文件夹数目
@Component
public class TraverseFolder {
    public static void main(String[] args) {
        String sourcePath="E:\\GoLink\\GoLink\\log";

        /*if (pathname == null) {
            throw new NullPointerException();
        }*/
        File file = new File(sourcePath);
        long bytes = getDirectoryTotalSize(file);
        double byteMb=1.0*bytes/1024/1024;
        System.out.println(byteMb);//格式控制输出 我还有欠缺
    }

    private static long getDirectoryTotalSize(File file) {
        //sourcePath为"" file会自动抛出空指针异常
        if (file.isFile()){
            return file.length();
        }
        File[] files = file.listFiles();
        if (files.length==0){
            return 0;
        }
        int total=0;
        for (File file1 : files) {
            total+=getDirectoryTotalSize(file1);//深度优先遍历
        }
        return total;
    }

    @Test
    public void test01(){
        File file = new File("cn/ahpu/io/TraverseFolder.java");
        System.out.println(file.isDirectory());
        File[] files = file.listFiles();
        System.out.println(files.length);//判断一个目录有没有文件夹或目录 需要用file.listFiles().length
        System.out.println(Arrays.toString(file.listFiles()));
    }
    
    @Test
    public void test02(){
        long l = System.currentTimeMillis();//返回毫秒
        long l1 = System.nanoTime();
        System.out.println(Double.valueOf(1.0e9));

    }
}
