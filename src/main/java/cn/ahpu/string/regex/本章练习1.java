package cn.ahpu.string.regex;

public class 本章练习1 {
    public static void main(String[] args) {

        //邮箱匹配：^[\\w-]+@([a-zA-Z]+\\.)+[a-zA-Z]+$
        //匹配整数或者小数(正负数)：^[+-]?(([1-9]\\d*)|0)([.]\\d+)?$,匹配0.9800、23.98               不行：-002.7800(不规范)
                              //^[+-]?([1-9]\\d*|0)([.]\\d+)?$,效果一样

        //解析url：^(a-zA-Z]+)://
    }
}
