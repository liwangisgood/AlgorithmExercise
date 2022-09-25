package cn.ahpu.io.processingstream;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.*;

@Component
public class 数据流读写 {

    long[] ids = {100001, 100002, 100003};
    String[] names = {"LED电视", "电冰箱", "iPhones"};
    float[] prices = {5999, 3200, 5800};
    int[] counts = {16, 10, 50};

    public static void main(String[] args) throws IOException {
        long[] ids = {100001, 100002, 100003};
        String[] names = {"LED电视", "电冰箱", "iPhones"};
        float[] prices = {5999, 3200, 5800};
        int[] counts = {16, 10, 50};

        String filePath = "E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\processingstream\\test.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);//对目标文件写入，每次运行从覆盖开始
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
//        dataOutputStream.writeUTF("\r\n");
        for (int i = 0; i < ids.length; i++) {
            dataOutputStream.writeLong(ids[i]);
            dataOutputStream.writeUTF(names[i]);
            dataOutputStream.writeFloat(prices[i]);
            dataOutputStream.writeInt(counts[i]);
//            dataOutputStream.writeUTF("\r\n");
        }

    }


    @Test
    public void test01() throws IOException {
        String filePath = "E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\review\\io\\processingstream\\test.txt";
        File file = new File(filePath);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        for (int i = 0; i < ids.length; i++) {//数据流写和读顺序需要完全一致才能正确读取
            System.out.println("----------------------------");
            System.out.println("编号："+dataInputStream.readLong());
            System.out.println("名称："+dataInputStream.readUTF());
            System.out.println("单价："+dataInputStream.readFloat());
            System.out.println("库存："+dataInputStream.readInt());
        }
    }
}
