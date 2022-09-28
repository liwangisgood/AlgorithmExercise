package cn.ahpu.gitee.lombok.cauchy6317.common.XXXArgsConstructor;

import lombok.*;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 学生类
 * @date 2019/10/11 10:17
 */
@NoArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED, staticName = "of")
@ToString
public class Student<T, K> {

    @NonNull
    private T name;

    private K age;
}
