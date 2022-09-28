package cn.ahpu.gitee.lombok.cauchy6317.common.XXXArgsConstructor;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/15 14:19
 */
public class XXXArgsConstructor {
    public static void main(String[] args) {
        // Student<String, Integer> cauchy6317 = new Student<>("cauchy6317", 18);
        Student<String, Integer> cauchy6317 = Student.of("cauchy6317", 18);
        System.out.println(cauchy6317);
    }
}
