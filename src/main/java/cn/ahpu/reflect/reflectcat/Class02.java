package cn.ahpu.reflect.reflectcat;

import cn.ahpu.reflect.reflectcat.entity.Car;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        String classAllPath = "cn.ahpu.reflect.reflectcat.entity.Car";
//        1 . 获取到 Car 类 对应的 Class 对象 //<?> 表示不确定的 Java 类型
        Class<?> cls = Class.forName(classAllPath); //2. 输出 cls System.out.println(cls); //显示 cls 对象, 是哪个类的 Class 对象 com.hspedu.Car
        System.out.println(cls.getClass());//输出 cls 运行类型 java.lang.Class //3. 得到包名
        System.out.println(cls.getPackage().getName());//包名 //4. 得到全类名
        System.out.println(cls.getName()); //5. 通过 cls 创建对象实例
        Car car = (Car) cls.newInstance();
        System.out.println(car);//car.toString() //6. 通过反射获取属性 brand
        Field brand = cls.getDeclaredField("brand");//获取该属性列 能否访问还是受下行代码决定
//        brand.setAccessible(true);//必须设置才能访问
        System.out.println(brand.get(car));//宝马 //7. 通过反射给属性赋值
        brand.set(car, "奔驰");
        System.out.println(brand.get(car));//奔驰 //8 我希望大家可以得到所有的属性(字段)
        System.out.println("=======所有的字段属性====");
        Field[] fields = cls.getDeclaredFields();//getFields 除了public访问其他不可访
        for (Field f : fields) {
            System.out.println(f.getName());//名称
        }
    }
}
