package cn.ahpu.java8;

import org.junit.jupiter.api.Test;

import java.text.Collator;
import java.util.*;

class TestA {

    public static void main(String[] args) {

        //lambda 与Arrays.sort(arr,new Comparator<T>{})
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        List<String> nets = Arrays.asList("谷歌", "腾讯", "百度", "淘宝");
/*        Arrays.sort(players, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
                return o1.substring(o1.indexOf(" ")).compareTo(o2.substring(o2.indexOf(" ")));
            }
        });
        System.out.println(Arrays.toString(players));*/
        Collator collator = Collator.getInstance(Locale.CHINA);
        Arrays.sort(players, (s1, s2) -> collator.compare(s1, s2));
        System.out.println(Arrays.toString(players));
/*        Arrays.sort(players, String::compareTo);//Arrays.sort(players, (o1, o2) -> o1.compareTo(o2));
        System.out.println(Arrays.toString(players));*/

        // lambda 与Runnable
/*
        new Thread(new Runnable(){
            @Override
            public void run() {
                   for (int i=1;i<=100;i++){
                       try {
                           System.out.println(Thread.currentThread().getName()+" "+i);
                           Thread.sleep(50);
                       } catch (Exception e) {
                           e.printStackTrace();
                       }
                   }
            }
        }).start();

        new Thread(()->{
            for (int i=1;i<=100;i++){
                try {
                    System.out.println(Thread.currentThread().getName()+" "+i);
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (int i=1;i<=100;i++){
            try {
                System.out.println(Thread.currentThread().getName()+" "+i);
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
    }

 @Test
    public void test04() {

        ArrayList<Student> list=Util.MyListStudents();
//        list.sort((s1, s2) -> s1.getName().equals(s2.getName()) ? s1.getAge() - s2.getAge() : s1.getName().compareTo(s2.getName()));
        list.sort((s1,s2)->{
            if (s1.getName().equals(s2.getName())){
                return s1.getAge()-s2.getAge();
            }else {
                return s1.getName().compareTo(s2.getName());
            }
        });

        list.forEach(System.out::println);

    }

    @Test
    public void test05(){
        String str="123,liWANG.李旺";
        String[] strs = str.split("");
        Arrays.stream(strs).forEach(x-> System.out.print(x+" "));
    }


}
