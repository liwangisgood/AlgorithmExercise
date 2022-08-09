package cn.ahpu;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
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


    }
}
