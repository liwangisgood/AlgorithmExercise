package cn.ahpu.java8;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestB {

    public static void main(String[] args) {

    }

    @Test
    public void test01(){
        System.out.println("1:"+"你还打\rsb");
        System.out.println("2:"+"你还打\nsb");
        System.out.println("3:"+"你还打\r\nsb");
        System.out.println("4:"+"你还打\n\rsb");
        System.out.println("5:"+"韩顺平教育\r北京");
    }

    /**
     * Long类型存储空间存储时间戳是完全没问题的
     */
    @Test
    public void test02(){
        Date date = new Date(Long.MAX_VALUE);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(date));//292278994-08-17
    }

}

