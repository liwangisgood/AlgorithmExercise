package cn.ahpu.gitee.lombok.cauchy6317.common.EqualsAndHashCode;

import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Student {

    private String name;

    private Integer age;
}
