package cn.ahpu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ExceptionTest {
    public static void main(String[] args) {

        //finally未执行的可能条件
        //test1();
        //test2();
        //test3();

        //try finally都有return会以finally的return作为返回值
        //try中return finally会改变其引用内容的值？ 会
        System.out.println(getStudent());//ExceptionTest.Student(id=2, name=镁铝)
    }

    public static Student getStudent() {
//        String str = "A";
//        try {
//            str = "B";
//            return str;
//        } finally {
//            System.out.println("finally change return string to C");
//            str = "C";
//        }
        Student student = new Student(1,"镁铝");
        try {
            return student;
        }finally {
            student.setId(2);
        }
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class Student{
        private Integer id;
        private String name;
    }

    //直接返回未执行到 try-finally 语句块
    public static String test1() {
        String str = null;
        int i = 0;
        if (i == 0) {
            return str;//直接返回未执行到finally语句块
        }
        try {
            System.out.println("try...");
            return str;
        } finally {
            System.out.println("finally...");
        }
    }

    //抛出异常未执行到 try-finally 语句块
    public static String test2() {
        String str = null;
        int i = 0;
        i = i / 0;//抛出异常未执行到finally语句块
        try {
            System.out.println("try...");
            return str;
        } finally {
            System.out.println("finally...");
        }
    }

    //系统退出未执行到 finally 语句块
    public static String test3() {
        String str = null;
        try {
            System.out.println("try...");
            System.exit(0);//系统退出未执行到finally语句块
            return str;
        } finally {
            System.out.println("finally...");
        }
    }

}
