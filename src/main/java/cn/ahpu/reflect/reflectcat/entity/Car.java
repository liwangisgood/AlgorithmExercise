package cn.ahpu.reflect.reflectcat.entity;

public class Car {
     String brand="优酷品牌";

    public Car() {
        System.out.println("Car类无参构造器");
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
