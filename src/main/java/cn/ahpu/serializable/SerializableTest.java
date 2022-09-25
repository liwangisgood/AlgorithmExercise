package cn.ahpu.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.*;

public class SerializableTest implements Serializable {

    private static final long serialVersionUID = 5887391604554532906L;
    private int id;
    private String name;

    //序列化时候 无无参构造器 java.lang.Exception: Test class should have exactly one public zero-argument constructor
//    public SerializableTest() {
//    }

    public SerializableTest(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestSerializable [id=" + id + ", name=" + name + "]";
    }


    //对象序列化与反序列化
    @Test
    public void test01() throws IOException, ClassNotFoundException {

    }


    public static void main(String[] args) throws Exception {
//        User user = new User("李旺哥哥", 23);
//        System.out.println(user);
//        SerializableTest.writeObject(user);
//        Object object =  SerializableTest.readObject();
//        System.out.println(object);
//        User user1 = (User) SerializableTest.readObject();// 不要在序列化文件添加多于内容 否则会无法转换成指定对象java.lang.String cannot be cast to cn.ahpu.serializable.User
//        writeObject(user1);
//        System.out.println(user1.equals(object));
//        System.out.println(user.equals(user1));
//        System.out.println(user.equals(object));


        //在单元测试方法中序列化对象出现异常 序列化的内容 对象类型，对像属性类型，对象属性值
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("TestSerializable.obj"));
        oos.writeObject("测试序列化");
        oos.writeObject(618);
        SerializableTest test = new SerializableTest(1, "ConstXiong");
        oos.writeObject(test);
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TestSerializable.obj"));
        System.out.println((String)ois.readObject());
        System.out.println((Integer)ois.readObject());
        System.out.println((SerializableTest)ois.readObject());

    }

    //IO与序列化整合
    public static void writeObject(Object object) throws Exception {
        ObjectOutputStream out = null;
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\serializable\\resoreObject.txt");
            out = new ObjectOutputStream(fout);
            out.writeObject(object);
        } finally {
            if (fout != null) {
                fout.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    // 读取对象，反序列化
    public static Object readObject() throws Exception {
        ObjectInputStream in = null;
        FileInputStream fin = null;
        try {
            fin = new FileInputStream("E:\\SoftWare\\dev\\ideaIU-2021.2.win\\myIdeaProjects\\AlgorithmExercise\\src\\main\\java\\cn\\ahpu\\serializable\\resoreObject.txt");
            in = new ObjectInputStream(fin);
            Object object = in.readObject();
            return object;
        } finally {
            if (fin != null) {
                fin.close();
            }
            if (in != null) {
                in.close();
            }
        }
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User extends Person {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Serializable {
    String sex;
}

