package cn.ahpu.reflect.reflectcat.access;

public class Person {
    public String name = "liwang";
    protected int age = 23;//可直接反射访问
    char sex = '男';
    private String address = "安徽省";

    public Person() {
        System.out.println("空参的构造方法");
    }

    Person(String name) {
        System.out.println("一个参数的构造方法");
        this.name = name;
    }

    protected Person(int age, char sex) {
        System.out.println("两个参数的构造器");
        this.age = age;
        this.sex = sex;
    }

    private Person(String name, int age, char sex, String address) {
        System.out.println("四个参数的构造方法");
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
    }

    private void show1(Object obj) {
        System.out.println(obj);
    }

    protected void show2(Object obj) {
        System.out.println(obj);
    }

    void show3(Object obj) {
        System.out.println(obj);
    }

    private void show4(Object obj) {
        System.out.println(obj);
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", address=" + address + "]";
    }
}

