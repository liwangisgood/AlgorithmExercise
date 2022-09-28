package cn.ahpu.gitee.lombok.cauchy6317.common.Data;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 学生类
 * @date 2019/10/16 17:22
 */
@Data(staticConstructor = "of")
public class Student {

    @Setter(AccessLevel.PROTECTED)
    @NonNull
    private String name;

    private Integer age;
}
