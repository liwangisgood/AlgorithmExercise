package cn.ahpu.acm;

import lombok.*;

import java.util.HashMap;

@Data
public class R<T> extends HashMap<String, T> {

    private T data;

    public R() {
    }

    public R(T data) {
        this.data = data;
    }

}

class RTest {

    public static void main(String[] args) {
        R<String> r = new R<>();
        System.out.println(r);
        r.put("k1", "v1");
        System.out.println(r.get("k1"));
        System.out.println("--------------");
        r.setData("nihdwiehb");
        System.out.println(r.getData());


        System.out.println("--------------------");
        //实现类中定义可能无法解析
        HashMap<String, Object> hashMap = new HashMap<String, Object>() {
               private final Integer i=666;
               public Integer getI(){
                   return i;
               }


        };
        hashMap.put("k2", "v2");
        Object v2 = hashMap.get("k2");
        System.out.println(v2);
//        System.out.println(hashMap.getI());



    }


}
