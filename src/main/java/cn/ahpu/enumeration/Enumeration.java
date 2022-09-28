package cn.ahpu.enumeration;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
public class Enumeration {
    public static void main(String[] args) {

    }

    //枚举元素的遍历 枚举元素的访问
    @Test
    public void test01() {
        System.out.println(Color.BLUE) ;//返回为枚举类型 非字符串
        Color[] values = Color.values();
        for (Color value : values) {
            System.out.println(value.name() + " "+value.toString()+" "+value.ordinal()+" "+value.hashCode()+" "+value.getClass()+" "+value.getDeclaringClass());
        }
        System.out.println(Color.valueOf("RED"));//不是会抛出异常
    }

    //枚举类中设置静态方法 根据输入索引获取对应枚举名称或索引
    @Test
    public void test02() {
        System.out.println(Shape.Triangle.getShapeName());
        System.out.println(Shape.getShapeName(2));
    }

    @Test
    public void test03() {
        System.out.println(Food.Coffee.BLACK_COFFEE);
        for (Food.Coffee value : Food.Coffee.values()) {

            System.out.print(value.ordinal()+"="+value.toString()+" ");
        }
    }

}

//接口中有抽象方法，则实现接口的枚举也必须要实现接口抽象方法
interface Food {
    enum Coffee {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO;
    }

    enum Drink implements Food{
        TEA,JUICE,MILK,COCA;

        @Override
        public void print(String name) {

        }
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO;

        @Override
        public void print(String name) {

        }
    }

    public void print(String name);
}



enum Color {
    RED, BLUE, GREEN;
}

enum Shape {
    Triangle("三角形", 1),
    Rectangle("矩形", 2),
    Circular("圆形", 3);

    private String shapeName;
    private int index;

    private Shape(String shapeName, int index) {
        this.shapeName = shapeName;
        this.index = index;
    }


    public static String getShapeName(int index) {
        for (Shape shape : Shape.values()) {
            if (shape.getIndex() == index) {
                return shape.getShapeName();
            }
        }
        return null;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}






