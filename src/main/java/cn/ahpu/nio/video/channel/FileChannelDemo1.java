package cn.ahpu.nio.video.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {
    //FileChannel读取数据到buffer中
    public static void main(String[] args) throws Exception {
        //创建FileChannel 没有该文件会创建
        RandomAccessFile aFile = new RandomAccessFile("F:\\nio_dir\\01.txt", "rw");
        FileChannel channel = aFile.getChannel();

        //创建Buffer
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //读取数据到buffer中 值为-1表示到了文件的末尾
        int bytesRead = channel.read(buf);
        while (bytesRead != -1) {
            System.out.println("读取了：" + bytesRead);
            buf.flip();
            while (buf.hasRemaining()) {
                //每次读去一个字节整数返回 汉字三个字节
                System.out.println((char) buf.get());
            }
            buf.clear();
            bytesRead = channel.read(buf);
        }
        aFile.close();
        System.out.println("结束了");
    }
}
