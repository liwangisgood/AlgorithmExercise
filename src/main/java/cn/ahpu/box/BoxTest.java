package cn.ahpu.box;



import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
public class BoxTest {
    public static void main(String[] args) {
        //JDK1.5之前是不支持自动装箱和自动拆箱的，定义Integer对象，必须
        Integer i = new Integer(8);

        //JDK1.5开始，提供了自动装箱的功能，定义Integer对象可以这样
        Integer j = 8;//自动装箱底层 Integer j = Integer.valueOf(8);

        int n = j;//自动拆箱底层 j.intValue()
    }

    @Test
    public void test01(){
        //JDK1.5之前是不支持自动装箱和自动拆箱的，定义Integer对象，必须
        Integer i = new Integer(8);

        //JDK1.5开始，提供了自动装箱的功能，定义Integer对象可以这样
        Integer j = 8;

        int n = j;//自动拆箱
    }


}
