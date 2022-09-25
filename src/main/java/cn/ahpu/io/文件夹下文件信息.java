package cn.ahpu.io;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.File;
import java.util.Date;
import java.util.Objects;

@Component
public class 文件夹下文件信息 {
    public static void main(String[] args) {
        String folderPath="E:\\";
        System.out.println(folderPath+"中的文件：");
        System.out.println("名称                          大小(字节)                     最后修改时间");
        System.out.println("-------------------------------------------------------------------------");
        File folder = new File(folderPath);
        int fileCount=0;
        int folderCount=0;
        int hiddenCount=0;
        int other=0;
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isFile()){
                fileCount++;
            }else if (file.isHidden()){
                hiddenCount++;
            }else if(file.isDirectory()){
                folderCount++;
            } else {
                other++;
            }
            System.out.printf("%-30s%-30d%-30s",file.getName(),file.length(),new Date(file.lastModified()));//不能直接求出文件夹的字节容量，需要使用到递归
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------");

        System.out.println("共有"+fileCount+"个文件，"+folderCount+"个文件夹,"+hiddenCount+"个隐藏，"+other+"个其他");//隐藏中包含文件夹，不好区分

    }

    @Test
    public void test01(){
        System.out.printf("%-30s%-16d%-16s","liwang",2019,"大厂迸发");
        String str1="liwang                        ";
        String str2="2019            ";
        String str3="大厂迸发            ";
        System.out.println(str1.length()+" "+str2.length()+" "+str3.length());
    }
}
