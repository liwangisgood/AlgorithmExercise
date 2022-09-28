package cn.ahpu.gitee.lombok.cauchy6317.common.ToString;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: @ToString使用
 * @date 2019/10/12 11:11
 */
public class ToStringExample {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("cauchy6317");
        student.setAge(18);
        System.out.println(student);
    }
}
