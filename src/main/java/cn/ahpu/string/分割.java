package cn.ahpu.string;

import org.junit.Test;

public class 分割 {

    public static void main(String[] args) {

        /**
         * 字符串的split
         *  "_900"被分割为"" "900" 长度为2
         *  "900_"被分割为"900" 长度为1
         *  "300_900"被分割为"300" "900" 长度2
         */
        String[] strs = "300_900".split("_");
        for (String str : strs) {
            System.out.println(str+" ");
        }
        System.out.println("长度:"+strs.length);
    }

    @Test
    public void test01(){
        System.out.println(Byte.parseByte(""));//空字符串转数字,会报出java.lang.NumberFormatException: For input string: ""

    }

    @Test
    public void test02(){
        String str="hello,world!";
        System.out.println(str.indexOf("d!ed32"));
    }





}
