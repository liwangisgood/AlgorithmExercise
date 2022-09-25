package cn.ahpu.collection.set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

@Component
public class SetTest {
    public static void main(String[] args) {

    }

    /**
     * HashSet的增删 都返回boolean值
     * 遍历 迭代器iterator() foreach
     */
    @Test
    public void test01(){
        HashSet<String> hs = new HashSet<>();
        //增加

        HashSet<String> s =new HashSet<>();
        s.add("雨");
        s.add("暴风");
        hs.add("剑雨");
        hs.add("冰");
        hs.addAll(s);
        hs.add("旱");
        System.out.println(hs);

        //删除
        hs.remove("旱");
        hs.removeAll(s);
        System.out.println(hs);

        //修改
        hs.add("han");
        System.out.println(hs);
        System.out.println("----------------------");
        for (String h : hs) {
            System.out.print(h+" ");
        }
        System.out.println("----------------------");
        Iterator<String> iterator = hs.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+" ");
        }

        System.out.println("-------------------------");
        /**
         * 添加引用类型的对象 会对这些对象进行hashCode() equals()进行判重
         */
        HashSet<Person> ps = new HashSet<>();
        ps.add(new Person("张三", 23));
        ps.add(new Person("张三", 23));
        ps.add(new Person("李四", 24));
        ps.add(new Person("李四", 24));
        ps.add(new Person("李四", 24));
        ps.add(new Person("李四", 24));
        System.out.println(ps);//Person重写了equals()方法和hashCode()方法，所以 hs 去除了重复的元素
    }

    /**
     * TreeSet的增删 都有boolean返回
     * 有序 不重
     * TreeSet：元素唯一，更重要的一个是给元素进行排序
     * 方式一：让元素所在的类实现Comparable接口，并重写CompareTo() 方法，并根据CompareTo()的返回值来进行添加元素
     *     返回正数：往二叉树的右边添加
     *     返回负数：往二叉树的左边添加
     *     返回 0 ： 说明重复，不添加
     *     优先使用Comparator<T>  备使用Comparable<T>
     */
    @Test
    public void test06(){
        //默认按自然排序进行 数字大小 字符串compareTo
        TreeSet<String> ts=new TreeSet<>();
        ts.add("3春");
        ts.add("1夏");
        ts.add("2秋");
        ts.add("4冬");
        System.out.println(ts);

        //显示第一个
        System.out.println(ts.first());

        //显示最后一个
        System.out.println(ts.last());

        System.out.println(ts.subSet("2夏","4冬"));

        //删除
        ts.remove("4冬");
        System.out.println(ts);
        System.out.println("----------------------");
        for (String h : ts) {
            System.out.print(h+" ");
        }
        System.out.println();
        System.out.println("----------------------");
        Iterator<String> iterator = ts.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();

        System.out.println("----------------------");
        TreeSet<Person> ts1 = new TreeSet<>();
        ts1.add(new Person("zhangsan", 23));
        ts1.add(new Person("lisi", 13));
        ts1.add(new Person("wangwu", 33));
        ts1.add(new Person("zhaoliu", 33));
        ts1.add(new Person("aaaa", 53));
        System.out.println(ts1);

    }

    /**
     * LinkedHashSet：直接父类是 HashSet
     * 特点：存取有序，存储的元素不能重复。
     */
    @Test
    public void test03(){
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("d");
        lhs.add("d");
        lhs.add("d");
        lhs.add("a");
        lhs.add("c");
        lhs.add("b");
        lhs.add("b");
        System.out.println(lhs);//[d, a, c, b]  去除了重复的元素，同时又保证了存取有序
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Person implements Comparable<Person> {	//Person里面 Eclipse自动生成了 equals()方法和hashCode()方法
        private String name;
        private int age;
        /*
         * 为什么是31?
         * 1,31是一个质数,质数是能被1和自己本身整除的数
         * 2,31这个数既不大也不小
         * 3,31这个数好算,2的五次方-1,2向左移动4位
         */
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)				//调用的对象和传入的对象是同一个对象
                return true;				//直接返回true
            if (obj == null)				//传入的对象为null
                return false;				//返回false
            if (getClass() != obj.getClass())//判断两个对象对应的字节码文件是否是同一个字节码
                return false;				//如果不是直接返回false
            Person other = (Person) obj;		//向下转型
            if (age != other.age)				//调用对象的年龄不等于传入对象的年龄
                return false;				//返回false
            if (name == null) {				//调用对象的姓名为null
                if (other.name != null)			//传入对象的姓名不为null
                    return false;			//返回false
            } else if (!name.equals(other.name))		//调用对象的姓名不等于传入对象的姓名
                return false;				//返回false
            return true;					//返回true
        }

            /*
    //1）：按照年龄排（先比较年龄后比较姓名）
    public int compareTo(Person o) {
    	//this 是集合即将存入的元素， o 是集合已经存入的元素
    	int num = this.age - o.age;	//年龄是比较的主要条件
    	return num == 0 ? this.name.compareTo(o.name) : num;	//姓名是比较的次要条件
    }
    */

    /*
    //2）：按照姓名排（先比较姓名后比较年龄）
    public int compareTo(Person o) {
    	int num = this.name.compareTo(o.name);		//姓名是主要条件
   		return num == 0 ? this.age - o.age : num;	//年龄是次要条件
    }
    */

        //3）：按照姓名长度排（先比较姓名长度 后比较姓名内容 后比较年龄）
//        public int compareTo(Person o) {
//            int length = this.name.length() - o.name.length();	//比较长度为主要条件
//            int num = length == 0 ? this.name.compareTo(o.name) : length;//比较内容为次要条件
//            return num == 0 ? this.age - o.age : num;//比较年龄为次要条件
//        }

        //3 尝试按照年龄只按照年龄进行排序  当年龄相等时不再添加年龄相等的元素
        public int compareTo(Person o){
            return this.age-o.getAge();
        }

    }

}
