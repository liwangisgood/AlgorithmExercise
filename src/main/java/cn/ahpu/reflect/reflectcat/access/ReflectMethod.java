package cn.ahpu.reflect.reflectcat.access;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectMethod {
    public static void main(String[] args) throws Exception {
        Class<Person> clazz = (Class<Person>) Class.forName("cn.ahpu.reflect.reflectcat.access.Person");
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        int length = clazz.getInterfaces().length;
        System.out.println(length);
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface);
        }
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getClassLoader());


        Object o = clazz.newInstance();//会调用Person的构造器方法 创建的是一个new Person()
        System.out.println(o);

        //属性
        Field[] fields1 = clazz.getFields();//数组长度为1 仅能public
        Field[] fields2 = clazz.getDeclaredFields();//数组长度为4 private protected 默认 public
        System.out.println(fields2.length);
        for (Field field : fields2) {
            System.out.println(field);
        }

        Field ageField = clazz.getDeclaredField("age");//getField(仅能访问public)与getDeclaredField(除了private都能直接访问)区别:
//        ageField.setAccessible(true);
        Integer  age = (Integer) ageField.get(o);
        System.out.println("age="+age);//23

        Field nameField = clazz.getDeclaredField("name");
        String name = (String) nameField.get(o);
        System.out.println("name=" + name);//liwang

        Field sexField = clazz.getDeclaredField("sex");
        char sex = (char) sexField.get(o);
        System.out.println("sex=" + sex);

        Field addressField = clazz.getDeclaredField("address");
        addressField.setAccessible(true);
        String address= (String) addressField.get(o);//无法访问private
        System.out.println("address=" + address);

        System.out.println("----------------------");

        //构造器
        Constructor<?>[] constructors1 = clazz.getConstructors();
        System.out.println(constructors1.length);//1
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        System.out.println(constructors.length);//4
        for (Constructor<?> constructor : constructors) {//可直接取得 private 默认 protected public
            System.out.println(constructor);
        }

        System.out.println("----------------------");

        //方法
        Method[] methods1 = clazz.getMethods();
        System.out.println(methods1.length);//9 包含构造器 private 默认 protected public
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);//4 不包含构造器 private 默认 protected public
        for (Method m : methods) {
            System.out.println(m);
        }

        System.out.println("----------------------");

        //创建对象
        Person p = clazz.newInstance();
        System.out.println("对象p" + p);
        Method method = null;
        try {
            method = clazz.getMethod("show");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        System.out.println(method);
        System.out.println("结尾最后........");//有异常捕获try catch会正常运行后续代码, 不捕获抛给虚拟机不会运行后续代码
    }
}

