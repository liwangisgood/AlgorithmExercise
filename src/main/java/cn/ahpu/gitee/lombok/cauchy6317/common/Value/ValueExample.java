package cn.ahpu.gitee.lombok.cauchy6317.common.Value;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/21 10:36
 */
public class ValueExample {

    public static void main(String[] args) {
        Student cauchy6317 = new Student("cauchy6317", 18);
        String name = cauchy6317.getName();
        System.out.println(name);
        //如果你觉得cauchy6317对象被改变了，你就需要重新学习一下引用类型。
        //这里，我简单解释一下，cauchy6317只是Student("cauchy6317", 18)的引用，程序重新赋值的过程是改变了cauchy6317的引用为Student("cauchy", 19)的引用
        //并没有改变Student("cauchy6317", 18)这个对象，就像String类一样，String name = "cauchy6317", name = "cauchy",之前的"cauchy6317"并没有改变。
        cauchy6317 = new Student("cauchy", 19);
        System.out.println(cauchy6317.getName());
    }
}
