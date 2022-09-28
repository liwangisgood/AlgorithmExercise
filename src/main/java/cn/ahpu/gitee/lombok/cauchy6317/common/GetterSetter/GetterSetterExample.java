package cn.ahpu.gitee.lombok.cauchy6317.common.GetterSetter;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: @Getter/@Setter使用
 * @date 2019/10/11 10:46
 */
public class GetterSetterExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(18);
        student.setName("cauchy6317");
        System.out.println(student.getAge());
        System.out.println(student.getName());
    }
}
