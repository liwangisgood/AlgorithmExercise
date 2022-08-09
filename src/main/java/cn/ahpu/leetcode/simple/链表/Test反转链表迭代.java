package cn.ahpu.leetcode.simple.链表;

/**
 * @author:liwang
 * @date: 2022/2/27 12:28
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class Test反转链表迭代 {
	public static void main(String[] args) {
		Node n5 = new Node(5, null);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		Node it = n1;//静态不能引用非静态，不能直接引用非static的变量n1

		Node curr = n1, next=null, pre = null;
		while (curr != null) {
			next = curr.getNext();
			curr.setNext(pre);
			pre = curr;
			curr=next;
		}
		it = pre;
		while (it != null) {
			System.out.print(it.getI() + " ");
			it = it.getNext();
		}
	}
}
