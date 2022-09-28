package cn.ahpu.gitee.lombok.cauchy6317.common.Builder;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description:
 * @date 2019/10/21 15:13
 */
@Builder(toBuilder = true)
@Data
public class Student {

    private String name;

    private Integer age;

    private List<String> projectName;
}
