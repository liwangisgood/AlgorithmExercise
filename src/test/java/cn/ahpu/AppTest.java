package cn.ahpu;

import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */

public class AppTest {
    /**
     * Rigorous Test :-)
     */

   @Resource
    private MyTest myTest;

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }


    @Test
    public void test01(){
        System.out.println((String) null);//null

        String str=null;
        System.out.println(str);//null
        System.out.println(str instanceof String);//false
        System.out.println(str instanceof Object);//false

    }
    
    
    @Test
    public void test02(){
        Date date = new Date();

        System.out.println(date.getTime());//1650730098987
        //spring:session:expirations:        1650731280000
        System.out.println("------------------");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("application.xml");
//        MyTest myTest =(MyTest) ac.getBean("myTest");
        myTest.test01();
    }
}
