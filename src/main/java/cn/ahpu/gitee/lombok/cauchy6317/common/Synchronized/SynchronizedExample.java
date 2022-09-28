package cn.ahpu.gitee.lombok.cauchy6317.common.Synchronized;

import lombok.Synchronized;

/**
 * Description:
 *
 * @author Cheng Jun
 * @version 1.0
 * @date 2019/10/30 8:51
 */
public class SynchronizedExample {

    @Synchronized
    public void print() {
        System.out.println("This is a non-static method.");
    }

    @Synchronized
    public static void hello() {
        System.out.println("This is a static method.");
    }

    public static void main(String[] args) {
        hello();
    }
}
