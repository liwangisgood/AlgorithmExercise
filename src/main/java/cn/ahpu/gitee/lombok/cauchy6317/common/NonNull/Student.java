package cn.ahpu.gitee.lombok.cauchy6317.common.NonNull;

import lombok.NonNull;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 学生类
 * @date 2019/10/11 10:17
 */

public class Student {

    private String name;

    private Integer age;

    public Student(@NonNull String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
