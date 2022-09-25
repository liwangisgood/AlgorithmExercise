package cn.ahpu.java8.util;

import cn.ahpu.java8.entity.Student;

import java.util.ArrayList;

class Util {
    static ArrayList<Student>  MyListStudents(){
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("1", 23, 500.0, Student.Status.BUSY));
        list.add(new Student("2", 21, 600.0, Student.Status.BUSY));
        list.add(new Student("2", 22, 700.0,Student.Status.FREE));
        list.add(new Student("Tom", 22, 800.0, Student.Status.BUSY));
        list.add(new Student("Andy", 21, 900.0,Student.Status.FREE));
        list.add(new Student("Amy", 23, 1000.0,Student.Status.FREE));
        list.add(new Student("Amy", 22, 1100.0,Student.Status.VOCATION));
        list.add(new Student("李旺", 23, 1200.0,Student.Status.FREE));
        list.add(new Student("祁仪", 21, 1300.0,Student.Status.VOCATION));
        list.add(new Student("杜华森", 21, 1400.0,Student.Status.VOCATION));
        return list;
    }

}
