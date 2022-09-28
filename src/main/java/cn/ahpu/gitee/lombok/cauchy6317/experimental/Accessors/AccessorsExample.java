package cn.ahpu.gitee.lombok.cauchy6317.experimental.Accessors;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 测试
 * @date 2019/10/22 11:33
 */
public class AccessorsExample {

    public static void main(String[] args) {
        Student cauchy6317 = new Student().name("cauchy6317");
        //这是getter方法
        Integer age = cauchy6317.age();
        //这是setter方法，并且可以继续使用链式赋值，而且不会返回新的对象
        Student sameCauchy6317 = cauchy6317.age(18);

        System.out.println(cauchy6317.age());
        System.out.println(cauchy6317.name());
        System.out.println(sameCauchy6317.age());
        System.out.println(sameCauchy6317.name());
        System.out.println(cauchy6317);
        System.out.println(sameCauchy6317);
    }
}
