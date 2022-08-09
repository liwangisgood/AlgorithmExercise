package cn.ahpu.leetcode.simple.链表;

import java.util.HashSet;

/**
 * @author:liwang
 * @date: 2022/4/2 10:46
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
 */
public class 环形链表 {
	public static void main(String[] args) {
		ListNode ln0 = new ListNode(3);
		ListNode ln1 = new ListNode(2);
		ListNode ln2 = new ListNode(1);
		ListNode ln3 = new ListNode(0);
		ln0.next = ln1;
		ln1.next = ln2;
		ln2.next = ln3;

		ln3.next = ln1;//第四个指向第二个 成环
		if (hasCycle01(ln0)) {
			System.out.println("成环");
		} else {
			System.out.println("不成环");
		}

		if (hasCycle02(ln0)) {
			System.out.println("成环");
		} else {
			System.out.println("不成环");
		}

	}

	//1.利用Set结合添加元素 成功返回true
	private static boolean hasCycle01(ListNode head) {
		HashSet<ListNode> hs = new HashSet<>();
		while (head != null) {
			if (!hs.add(head)) {//Set集合添加元素 成功与否 分别返回boolean类型值
				return true;
			}
			head = head.next;
		}
		return false;
	}

//	2.利用龟兔算法
	private  static boolean hasCycle02(ListNode head){
		if (head==null||head.next==null){
			return false;
		}
		ListNode slow=head;
		ListNode fast=head.next;
		while (slow!=fast){
			if (fast==null||fast.next==null){
				return false;
			}
			slow=slow.next;
			fast=fast.next.next;
		}
		return true;
	}


}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
