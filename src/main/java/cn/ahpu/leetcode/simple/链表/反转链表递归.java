package cn.ahpu.leetcode.simple.链表;

/**
 * @author:liwang
 * @date: 2022/2/27 12:50
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 反转链表递归 {


	public static void main(String[] args) {
		Node n5 = new Node(5, null);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		Node it = n1;//静态不能引用非静态，不能直接引用非static的变量n1

		it = reverseLinkedlistRecursion(it);
		while (it != null) {
			System.out.print(it.getI() + " ");
			it = it.getNext();
		}


	}

	private static Node reverseLinkedlistRecursion(Node head) {

		if(head==null||head.getNext()==null){
			return head;
		}

		Node newHead=reverseLinkedlistRecursion(head.getNext());
		head.getNext().setNext(head);
		head.setNext(null);
		return newHead;

	}
}
