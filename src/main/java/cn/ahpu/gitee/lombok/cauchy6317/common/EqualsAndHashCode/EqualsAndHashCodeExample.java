package cn.ahpu.gitee.lombok.cauchy6317.common.EqualsAndHashCode;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/15 9:28
 */
public class EqualsAndHashCodeExample {
    public static void main(String[] args) {
        Student student = new Student();
        Student student1 = new Student();
        student.setAge(18);
        student1.setAge(18);
        student.setName("cauchy6317");
        student1.setName("cauchy6317");
        System.out.println(student.equals(student1));
        System.out.println(student == student1);
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
    }
}
