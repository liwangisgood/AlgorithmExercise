package cn.ahpu.leetcode.simple.链表;

/**
 * @author:liwang
 * @date: 2022/2/26 22:23
 * @Description:TODO
 * @Algorithm 利用数组进行反转，链表节点元素装入数组，在遍历数组链接重组链表（避免数据结构）
 */
public class 反转链表迭代2 {

	//静态方法不能访问非静态属性
	public static void main(String[] args) {

		Node n5 = new Node(5, null);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		Node it = n1;//静态不能引用非静态，不能直接引用非static的变量n1

		while (it != null) {
			System.out.print(it.getI() + " ");
			it = it.getNext();
		}
		it = n1;
		System.out.println();

		Node[] nodes = new Node[5];
		for (int i = nodes.length-1; i >=0; i--) {
			nodes[i] = it;
			it = it.getNext();
		}

		it=nodes[0];
		for (int i=1;i< nodes.length;i++){
			it.setNext(nodes[i]);
			it=nodes[i];
		}

		System.out.println("数组链接的链表如下：");
		for (int i=0;i< nodes.length;i++){
			System.out.print(nodes[i].getI()+" ");
		}

	}

}
