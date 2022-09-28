package cn.ahpu.gitee.lombok.cauchy6317.common.NonNull;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/15 14:31
 */
public class NonNullExample {
    public static void main(String[] args) {
        Student student = new Student(null, 18);
        System.out.println(student.getName().length());
    }
}
