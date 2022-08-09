package cn.ahpu.acm.java2019;

public class 第四题_数的分解 {

    public static void main(String[] args) {
        int a = 2019;
        //三个数都不相等
        int count = 0;
        for (int i = 1; i <= 2017; i++) {
            if (!includeNum(i)) {
                for (int j = i+1; j <= 2017; j++) {
                    if (!includeNum(j)) {
                        int k=2019-i-j;
                        if (!includeNum(k)&&k>j){
                            count++;
                        }
                    }
                }
            }
        }

        //两个数相等
/*        for (int i = 1; i <= 1009; i++) {
                if (!includeNum(2019 - i * 2) && !includeNum(i)) {
                    count++;
                }
        }*/
        System.out.println(""+count);
    }

    public static boolean includeNum(int a) {
        while (a != 0) {
            if (a % 10 == 2 || a % 10 == 4) {
                return true;
            }
            a /= 10;
        }
        return false;
    }

}
