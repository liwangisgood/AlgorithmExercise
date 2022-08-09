package cn.ahpu.leetcode.hotproblems100.listnode;


//https://leetcode-cn.com/problems/intersection-of-two-linked-lists/solution/shi-pin-tu-jie-160-xiang-jiao-lian-biao-k3gw8/
public class 相交链表 {
    public static void main(String[] args) {
        ListNode ln0 = new ListNode(0, null);
        ListNode ln1 = new ListNode(1, null);
        ListNode ln2 = new ListNode(2, null);
        ListNode ln3 = new ListNode(3, null);

        ln0.next=ln1;
        ln1.next=ln2;

        ln3.next=ln2;
        System.out.println(getIntersectionNode(ln0, ln3).val);


    }


    private static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        ListNode pA=headA,pB=headB;
        while (pA!=pB){
            pA=pA==null?headB:pA.next;
            pB=pB==null?headA:pB.next;
        }
        return pA;
    }
}
