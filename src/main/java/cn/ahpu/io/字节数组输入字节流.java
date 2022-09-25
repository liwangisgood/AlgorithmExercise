package cn.ahpu.io;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class 字节数组输入字节流 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (byteArrayOutputStream.size()!=10){
            byteArrayOutputStream.write(System.in.read());
        }

        for (byte b : byteArrayOutputStream.toByteArray()) {
            System.out.println((char)b);
        }
    }

    @Test
    public void test01(){
        byte[] bytes = new byte[10];
        System.out.println(bytes.length);//10  数组容量为它的length
        String str1 = "10";
        System.out.println(str1.length());//2
        short s1=10;
        char c1=99;
        byte b1=123;

    }
}
