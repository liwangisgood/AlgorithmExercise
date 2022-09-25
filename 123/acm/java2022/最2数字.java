package cn.ahpu.acm.java2022;

public class 最2数字 {
    public static void main(String[] args) {
        int count=0;
        for (int i=1;i<=2021;i++){
            int temp=i;
            while (temp!=0){
                if(temp%10==2){
                    count++;
                    break;
                }
                temp/=10;
            }
        }
        System.out.println(count);
    }
}
