package cn.ahpu.generics;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


public class MyTest {

    @Test
    public void test01(){
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();

        System.out.println(l1.getClass() == l2.getClass());


    }
}
