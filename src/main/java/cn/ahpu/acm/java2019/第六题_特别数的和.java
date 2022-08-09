package cn.ahpu.acm.java2019;

public class 第六题_特别数的和 {

    public static void main(String[] args) {
        System.out.println(geSum(40));
    }

    private static int geSum(int n) {
        int sum = 0;
        for (int j = 1; j <= n; j++) {
            boolean flag = false;
            int i = j;
            while (i != 0) {
                int temp = i % 10;
                if (temp == 2 || temp == 0 || temp == 1 || temp == 9) {
                    flag=true;
                    break;
                }
                i /= 10;
            }
            if (flag) {
                System.out.println(" "+j);
                sum += j;
            }
        }
        return sum;
    }

}
