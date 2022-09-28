package cn.ahpu.gitee.lombok.cauchy6317.common.ToString;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 学生类
 * @date 2019/10/11 10:17
 */
@Getter
@Setter
@ToString
public class Student {

    @ToString.Include(name = "姓名", rank = -1)
    private String name;

    @ToString.Include(name = "年龄")
    private Integer age;
}
