package cn.ahpu.gitee.lombok.cauchy6317.experimental.Accessors;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/22 11:16
 */

@Getter
@Setter
@Accessors(fluent = true)
public class Student {

    private String name;

    private Integer age;

}
