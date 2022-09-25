package cn.ahpu.clone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

@Component
public class CLoneTest {
    public static void main(String[] args) {

    }

    //理解浅克隆(直接使用clone()方法) 深克隆
    @Test
    public void test01() throws CloneNotSupportedException {
        Person p1 = new Person(23, "zhang");

        Person p2 = p1.clone();
        p1.setName("花鼓量");

        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));

        System.out.println(p1);
        System.out.println(p2);
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person implements Cloneable{
    private Integer age;
    private String name;

    //本质上就是clone内引用成员引用类型不一样 而各自引用的数据是一样的 从而实现深克隆
    @Override
    public Person clone() throws CloneNotSupportedException {
        Person p1= (Person)super.clone();
        String str=this.getName()+"";
        p1.setName(str);
        return p1;

    }
}
