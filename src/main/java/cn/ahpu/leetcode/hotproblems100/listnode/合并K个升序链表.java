package cn.ahpu.leetcode.hotproblems100.listnode;

import cn.ahpu.leetcode.hotproblems100.listnode.ListNode;
import cn.ahpu.leetcode.hotproblems100.listnode.Util;

import java.util.ArrayList;
import java.util.Comparator;

//https://leetcode.cn/problems/merge-k-sorted-lists/solution/he-bing-kge-pai-xu-lian-biao-by-leetcode-solutio-2/
public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode[] array = new ListNode[3];
        array[0] = Util.generateListNode();
        array[1] = Util.generateListNode();
        array[2] = Util.generateListNode();
        ListNode lists = mergeKLists(array);
        Util.traverseTreeNode(lists);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode p = null;
        ListNode pre = new ListNode();
        ListNode head = pre;
        if (lists.length == 0) {
            return null;
        }
        for (int i = 0; i < lists.length; i++) {
            p = lists[i];
            while (p != null) {
                arrayList.add(p.val);
                p = p.next;
            }
        }
        arrayList.sort(Comparator.comparingInt(x -> x));
        if (arrayList.size()==0){
            return null;
        }
        pre.val = arrayList.get(0);
        for (int i = 1; i < arrayList.size(); i++) {
            pre.next = new ListNode(arrayList.get(i));
            pre = pre.next;
        }
        return head;
    }

}

