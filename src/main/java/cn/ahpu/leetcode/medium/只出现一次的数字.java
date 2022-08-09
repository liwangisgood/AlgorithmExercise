package cn.ahpu.leetcode.medium;

import java.util.HashSet;

/**
 * @author:liwang
 * @date: 2022/4/11 9:21
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/single-number/
 */
public class 只出现一次的数字 {
	public static void main(String[] args) {
		ListNode ln3 = new ListNode(-4, null);
		ListNode ln2 = new ListNode(0, ln3);
		ListNode ln1 = new ListNode(2, ln2);
		ListNode ln0 = new ListNode(3, ln1);
		//ln3.next=ln1;
		ListNode head=ln0;
		System.out.println(hasCycle(head));

	}

	private static boolean hasCycle(ListNode head) {
		HashSet<ListNode> set = new HashSet<>();
		while (head!=null){
			if (!set.add(head)){
				return true;
			}
			head=head.next;
		}
		return false;
	}
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int x,ListNode next){
		val=x;
		this.next=next;
	}
}
