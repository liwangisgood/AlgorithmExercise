package cn.ahpu.enumeration;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.Enumeration;
import java.util.Vector;
@Component
public class TestEnumeration{
    public static void main(String[] args){
        Vector v = new Vector();
        v.addElement("Lisa");
        v.addElement("Billy");
        v.addElement("Mr Brown");
        Enumeration e = v.elements();//返回Enumeration对象
        while(e.hasMoreElements()){
            String value = (String)e.nextElement();//调用nextElement方法获得元素
            System.out.print(value);
        }
    }

    @Test
    public void test01(){

    }

}
