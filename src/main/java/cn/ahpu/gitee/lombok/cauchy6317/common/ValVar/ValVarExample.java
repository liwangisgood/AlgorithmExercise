package cn.ahpu.gitee.lombok.cauchy6317.common.ValVar;

import lombok.var;
import lombok.val;

/**
 * Description:
 *
 * @author Cheng Jun
 * @version 1.0
 * @date 2019/11/1 9:08
 */
public class ValVarExample {
    public static void main(String[] args) {

        val name = "cauchy6317";
        // name = "newName";
        var age = Integer.valueOf(12);
        System.out.println(name.getClass());
        System.out.println(age.getClass());

        // final String address = "我的地址";
        // address = "我的新地址";
    }
}
