package cn.ahpu.util;

import org.junit.Test;

import java.util.Locale;

public class LocaleTest {


    @Test
    public void test01(){
        Locale locale = Locale.getDefault();
        System.out.println(locale.getLanguage());//zh ne us
        System.out.println(locale.getCountry());//CN
    }
}
