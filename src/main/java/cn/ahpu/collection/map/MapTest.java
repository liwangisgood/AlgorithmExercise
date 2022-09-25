package cn.ahpu.collection.map;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Hashtable;
@Component
public class MapTest {
    public static void main(String[] args) {

    }

    /**
     * HashMap可以存储key-value null-null
     * Hashtable 的key或value都不能存储null值
     */
    @Test
    public void test01(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null,null);
        System.out.println(hashMap);//{null=null}

        Hashtable<String, String> hashtable= new Hashtable<>();
        hashtable.put("null","null");//
        System.out.println(hashtable);//java.lang.NullPointerException
    }
}
