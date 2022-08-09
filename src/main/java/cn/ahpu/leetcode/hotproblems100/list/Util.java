package cn.ahpu.leetcode.hotproblems100.list;

import cn.ahpu.leetcode.hotproblems100.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Util {

    //返回链表
    public static ListNode generateListNode() {
        ListNode ln0 = new ListNode(1, null);
        ListNode ln1 = new ListNode(2, null);
        ListNode ln2 = new ListNode(2, null);
        ListNode ln3 = new ListNode(1, null);

        ln0.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;

        return ln0;
    }

    //遍历链表 返回值为null
    public static void traverseTreeNode(ListNode head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head=head.next;
        }
    }

    //遍历链表链表 返回值为Map<Integer>
    public static Map<Integer, Integer> returnTraverseTreeNode(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        while (head != null) {
            map.put(count++,head.val);
            head=head.next;
        }
        return map;
    }


}
