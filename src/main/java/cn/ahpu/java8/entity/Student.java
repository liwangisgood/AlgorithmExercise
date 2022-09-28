package cn.ahpu.java8.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public static void main(String[] args) {
        Student student = new Student("李旺", 23);
    }

    private  String name;
    private  Integer age;
    private  Double salary;
    private  Status status;

    public Student(String name, Integer age) {
        this.name=name;
        this.age=age;
    }

    public Student(String name, Integer age,Double salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    public enum Status {
        FREE,BUSY,VOCATION;
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Class{
    private Integer id;//基本类型会默认初始化为0
    private String name;

    public static void main(String[] args) {

        Class aClass = new Class();
        System.out.println(aClass);

    }

}
