package cn.ahpu.gitee.lombok.cauchy6317.common.SneakyThrows;

import lombok.SneakyThrows;

/**
 * @author Cheng Jun
 * @version 1.0
 * @Description: 练习使用 @SneakyThrows
 * @date 2019/10/23 8:47
 */
public class SneakyThrowsExample {
    public static void main(String[] args) {
        throwException();
    }

    @SneakyThrows(value = NullPointerException.class)
    public static void throwException(){
        String str  = null;
        String[] split = str.split(",");
        System.out.println(split);
    }

}
