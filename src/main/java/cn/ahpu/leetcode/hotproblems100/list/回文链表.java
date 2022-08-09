package cn.ahpu.leetcode.hotproblems100.list;

import org.junit.Test;

//https://leetcode.cn/problems/palindrome-linked-list/solution/hui-wen-lian-biao-by-leetcode-solution/
import java.util.*;

public class 回文链表 {

    private static ListNode head = Util.generateListNode();

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head!=null){
            arrayList.add(head.val);
            head=head.next;
        }

        int size= arrayList.size();;
        for (int i = 0; i <size/2; i++) {
            int m=arrayList.get(i);
            int n=arrayList.get(size-1-i);
            if (m!=n){
                System.out.println("该链表不是回文链表");
                return;
            }
        }
        System.out.println("该链表为回文链表");
    }

    //判断链表是否为回文链表
    private static boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }


        return false;
    }

    @Test//遍历Map集合的四种方式
    public void test01() {
        Map<Integer, Integer> map = Util.returnTraverseTreeNode(head);

        //1.获取Set<Integer>键集 来遍历 返回：此映射中包含的键的集合视图
        Set<Integer> iSet = map.keySet();
        for (Integer it : iSet) {
            System.out.println(it + "=" + map.get(it));
        }
       /* 0 = 1
        1 = 2
        2 = 3
        3 = 4*/
        System.out.println("=====================");

        //2.返回：此映射中包含的映射的集合视图
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : entrySet) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();
            System.out.println(key + "=" + value);
        }
        /*0=1
        1=2
        2=3
        3=4*/
        System.out.println("=====================");

        //3.
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey() + "=" + next.getValue());
        }
        /*0=1
        1=2
        2=3
        3=4*/

        System.out.println("=====================");

        //4.
        for (Integer value : map.values()) {
            System.out.print(" " + value);// 1 2 3 4
        }
    }


}
