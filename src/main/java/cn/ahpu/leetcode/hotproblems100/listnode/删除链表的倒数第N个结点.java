package cn.ahpu.leetcode.hotproblems100.listnode;

import cn.ahpu.leetcode.hotproblems100.listnode.ListNode;
import cn.ahpu.leetcode.hotproblems100.listnode.Util;

//https://leetcode.cn/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di-nge-jie-dian-b-61/
public class 删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode listNode = Util.generateListNode();//1,2,3,4,5
        Util.traverseTreeNode(listNode);
        System.out.println("------------------------");
        ListNode node = removeNthFromEnd(listNode, 2);
        Util.traverseTreeNode(node);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        p=head;
        //删除倒数第n个 即第一个
        if (n==length){
            head=head.next;
        }else {
            int len=length-(n+1);
            while ((len--)>0){
                p=p.next;
            }
            p.next=p.next.next;
        }
        return head;
    }
}


