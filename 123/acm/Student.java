package cn.ahpu.acm;

import lombok.Data;
import lombok.NoArgsConstructor;

//protected不修饰类
//https://blog.csdn.net/weixin_39638014/article/details/115765525
@Data
@NoArgsConstructor
 public class Student {

    private String name;
    private Integer age;

    protected Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }


}
