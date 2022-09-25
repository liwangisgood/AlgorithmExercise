package cn.ahpu.enumeration;

import org.springframework.stereotype.Component;

@Component
public class Eum01 {


    public static void main(String[] args) {
        //给他一个索引
        Season spring = Season.SPRING;
        //给他一个索引，觉得
        System.out.println(spring.name());
        System.out.println("次序  " + spring.ordinal());
        System.out.println("######");

        final Season[] values = Season.values();
        //遍历枚举类中的信息
        for (Season i : values) {
            System.out.println(i);
        }
        //增强for循环
        final Season spring1 = Season.valueOf("SPRING");

        System.out.println(Season.SPRING.compareTo(Season.SUMMER));
        //Season.SPRING   换成上面的spring也是可以的，其实还是最底层的东西啊。
        //做减法
    }
}

enum Season {
    SPRING("春天", "我爱你春天"), SUMMER("夏天", "夏天的风吹动");

    private String name;
    private String dsc;

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", dsc='" + dsc + '\'' +
                '}';
    }

    Season(String name, String dsc) {
        this.name = name;
        this.dsc = dsc;
    }
}