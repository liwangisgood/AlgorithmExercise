package cn.ahpu.leetcode.hotproblems100.listnode;

//https://leetcode-cn.com/problems/merge-two-sorted-lists/

public class 合并两个有序链表 {
    public static void main(String[] args) {

        ListNode list1 = null, list2 = null;
        list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode list3 = mergeTwoLists(list1, list2);
        ListNode temp = list3;
        while (temp != null) {
            System.out.println(" " + temp.val);
            temp = temp.next;
        }

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(), pre = head;//设置头节点 不含与任何有效数据
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                pre.next = list2;
                list2 = list2.next;
            } else {
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        pre.next = list1 != null ? list1 : list2;
        return head;
    }
}


