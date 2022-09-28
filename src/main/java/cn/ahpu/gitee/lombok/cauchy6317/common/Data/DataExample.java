package cn.ahpu.gitee.lombok.cauchy6317.common.Data;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/17 8:57
 */
public class DataExample {
    public static void main(String[] args) {
        //下面语句错误信息：Student(java.lang.@lombok.NonNull String)' has private access in 'com.cauchy6317.common.Data.Student
        //因为使用了staticName后，构造函数会变成私有的
        // Student cauchy6317 = new Student("cauchy6317");

        Student cauchy6317 = Student.of("cauchy6317");
        //输出：cauchy6317
        System.out.println(cauchy6317.getName());
        //输出：null
        System.out.println(cauchy6317.getAge());
    }
}
