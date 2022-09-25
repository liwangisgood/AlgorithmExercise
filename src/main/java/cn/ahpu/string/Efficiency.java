package cn.ahpu.string;

public class Efficiency {

    //字符串连接  +  concat()   StringBuilder()
    public static void main(String[] args) {
        String str1 = "i";
        String str3="a";
        StringBuilder str2 = new StringBuilder("i");
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str1 += "i";
        }//传统String方法

        long time2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            str2.append("i");
        }//StringBuilder的append方法
        long time3 = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++) {
            str3.concat("i");
        }//concat() 连接函数
        long time4 = System.currentTimeMillis();

        System.out.println(time2 - time1);//String方法时间，输出3262
        System.out.println(time3 - time2);//StringBuilder方法时间，输出1
                                            /*我的机器运行显示
                                            4526
                                            0
                                            */
        System.out.println(time4-time3);//  48727ms
    }
}

