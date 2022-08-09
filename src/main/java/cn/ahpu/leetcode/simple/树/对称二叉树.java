package cn.ahpu.leetcode.simple.树;

/**
 * @author:liwang
 * @date: 2022/4/13 14:59
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/symmetric-tree/solution/dui-cheng-er-cha-shu-by-leetcode-solution/
 * 创建了对称二叉树   遍历证实是对称二叉树
 */
public class 对称二叉树 {
	public static void main(String[] args) {

		TreeNode node01 = new TreeNode(0, null, null);
		TreeNode head01 = node01;
		createSymmetricBinaryTree(node01);
		//可直接便利head01是否已经为对称二叉树


		TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(2, null, null));
		TreeNode head = treeNode;
		System.out.println(isSymmetric(head01));
	}

	private static boolean isSymmetric(TreeNode root) {
		return check(root, root);
	}

	private static boolean check(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else {
			return (p.val == q.val) && (check(p.left, q.right)) && (check(p.right, q.left));
		}
	}


	private static void createSymmetricBinaryTree(TreeNode head) {
		int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int i = 1;
		createTree(head, head, array, i);
		return;
	}

	private static void createTree(TreeNode p, TreeNode q, int[] array, int i) {

		if (i == array.length) {
			return;
		} else {
			p.right = new TreeNode(array[i], null, null);
			p.left = new TreeNode(array[i], null, null);
			q.left = new TreeNode(array[i], null, null);
			q.right = new TreeNode(array[i], null, null);
		}
		createTree(p.left,q.right,array,i+1);
		createTree(q.left,p.right,array,i+1);




	}

}
