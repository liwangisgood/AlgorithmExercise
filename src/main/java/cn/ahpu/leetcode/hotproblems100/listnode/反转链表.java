package cn.ahpu.leetcode.hotproblems100.listnode;

//https://leetcode.cn/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode-solution-d1k2/
public class 反转链表 {

    public static void main(String[] args) {

        ListNode ln0 = new ListNode(1, null);
        ListNode ln1 = new ListNode(2, null);
        ListNode ln2 = new ListNode(3, null);
        ListNode ln3 = new ListNode(4, null);

        ln0.next = ln1;
        ln1.next = ln2;
        ln2.next = ln3;

        ListNode temp = reverseList(ln0);
        while (temp != null) {
            System.out.print(" " + temp.val);// 4 3 2 1
            temp = temp.next;
        }
    }


    //反转链表方法
    public static ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;//先有
        ListNode cur = head;//cur会导出next
        ListNode next = null;//在cur之后出现

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
