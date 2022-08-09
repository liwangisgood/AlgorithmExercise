package cn.ahpu.leetcode.simple.链表;

/**
 * @author:liwang
 * @date: 2022/2/26 22:01
 * @Description:TODO
 * @Algorithm 纯链表进行反转，使用数据结构
 */
public class 反转链表迭代 {

	public static void main(String[] args) {
		Node n5 = new Node(5, null);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		Node it = n1;
		while (it != null) {
			System.out.print(it.getI() + " ");
			it = it.getNext();
		}
		System.out.println();

		//反转链表方法,此处方法参数不能用it，it指向已为空，
		it = reverseLinkedList(n1);

		while (it != null) {
			System.out.print(it.getI() + " ");
			it = it.getNext();
		}
		System.out.println();
	}

	private static Node reverseLinkedList(Node it) {

		Node curr = it, next, pre = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(pre);
			pre = curr;
			curr = next;
		}
		return pre;
	}
}

class Node {
	private int i;
	private Node next;

	public Node(int i, Node next) {
		this.i = i;
		this.next = next;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}