package cn.ahpu.leetcode.simple.链表;

/**
 * @author:liwang
 * @date: 2022/4/4 17:12
 * @Description:TODO
 * @Algorithm https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 */
public class 合并两个有序链表 {
	public static void main(String[] args) {
		//就静态方法中调用的类 引用的外部变量 方法也是要静态的（这是在main方法对应的类同级的类 变量 方法）
		ListNode ln1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
		ListNode ln2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

		ListNode ln3 = mergeTwoList02(ln1, ln2);
		ListNode temp=ln3;
		while (temp!=null){// -1 1 1 2 3 4 4
			System.out.printf(" "+temp.val);// 1 1 2 3 4 4
			temp=temp.next;
		}


	}

	private static ListNode mergeTwoList01(ListNode ln1, ListNode ln2) {
		ListNode preHead = new ListNode(-1);
		ListNode prev = preHead;
		while (ln1 != null && ln2 != null) {
			if (ln1.val <= ln2.val) {
				prev.next = ln1;
				ln1 = ln1.next;
			} else {
				prev.next = ln2;
				ln2 = ln2.next;
			}
			prev = prev.next;
		}
		prev.next = ln1 == null ? ln2 : ln1;
		return preHead;
	}

	private static ListNode mergeTwoList02(ListNode ln1, ListNode ln2) {
		if (ln1 == null) {
			return ln2;
		} else if (ln2 == null) {
			return ln1;
		} else if (ln1.val < ln2.val) {
			ln1.next = mergeTwoList02(ln1.next, ln2);
			return ln1;
		}else {
			ln2.next=mergeTwoList02(ln1,ln2.next);
			return ln2;
		}

	}


	//静态内部类在main方法中创建也需要设置为静态的
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {

		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

}


