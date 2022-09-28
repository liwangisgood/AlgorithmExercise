package cn.ahpu.gitee.lombok.cauchy6317.common.Builder;

import java.util.ArrayList;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/21 15:13
 */
public class BuilderExample {

    public static void main(String[] args) {
        Student cauchy6317 = Student.builder().name("cauchy6317").build();
        //创建对象后，无法使用链式赋值，只能使用setter方法
        cauchy6317.setAge(18);
        //newCauchy6317只是复用cauchy6317的成员变量值，它们是两个不同的对象
        Student newCauchy6317 = cauchy6317.toBuilder()
                .projectName(new ArrayList<>(3))
                .build();
        System.out.println(cauchy6317.getAge());
        System.out.println(cauchy6317.getName());
        System.out.println(newCauchy6317.getAge());
        System.out.println(newCauchy6317.getName());
        System.out.println(newCauchy6317);
        System.out.println(cauchy6317);
    }
}
