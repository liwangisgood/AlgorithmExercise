package cn.ahpu.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;
    private Double salary;
    private Status status;

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
