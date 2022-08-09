package cn.ahpu.acm.a;

import org.junit.Test;

/**
 * @author:liwang
 * @date: 2022/3/22 10:26
 * @Description:TODO
 * @Algorithm Design：TODO
 */
//向下只能3步 向右只能4步 问有多少种走法，排列组合 七步中选择三条走下 其他就固定 35中
public class 振兴中华 {

    public static void main(String[] args) {
        //重复 变化 边界
//		int ans = f(0, 0);//不用不用new 类对象，直接调用其他静态方法
//		System.out.println(ans);
//		System.out.println(zuhe(3, 4));//35

        振兴中华 振兴中华 = new 振兴中华();
        System.out.println(振兴中华.f(0, 0));//35 创建实列对象 静态方法才能调用非静态方法
    }

    private int f(int i, int j) {
        if (i == 1 || j == 1) {
            return 1;
        }
        return f(i + 1, j) + f(i, j + 1);//35
    }

    private static int zuhe(int i, int j) {
        int a = jieceng(i);
        int b = jieceng(j);
        int c = jieceng(i + j);
        return c / (a * b);
    }

    private static int jieceng(int i) {
        int ji = 1;
        for (int j = 1; j <= i; j++) {
            ji *= j;
        }
        return ji;
    }

    @Test
    public void myTest01() {

        System.out.println(f(0, 0));

    }


}
