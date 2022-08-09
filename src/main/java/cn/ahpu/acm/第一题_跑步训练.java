package cn.ahpu.acm;

public class 第一题_跑步训练 {
    public static void main(String[] args) {
        int n = 10000;
        int run = 600 / 60;
        int time = 0;
        while (n >= 0) {
            if (n - 600 < 0) {
                time = time * 60 + n / run;
                break;
            }
            n -= 600;
            n += 300;
            time += 2;
        }
        System.out.println(time);
    }
}
