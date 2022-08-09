package cn.ahpu.leetcode.simple.树;

import java.util.ArrayList;

/**
 * @author:liwang
 * @date: 2022/4/13 14:36
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class 二叉树的中序遍历 {
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
		TreeNode head=treeNode;
		ArrayList<TreeNode> treeNodes = new ArrayList<>();
		inorderTraversal(head,treeNodes);
		for (TreeNode node : treeNodes) {
			System.out.println(node.val);
		}
		System.out.println(treeNodes);
	}

	private static void inorderTraversal(TreeNode head,ArrayList<TreeNode> treeNodes) {
		if (head==null){
			return;
		}
		inorderTraversal(head.left,treeNodes);
		treeNodes.add(head);
		inorderTraversal(head.right,treeNodes);
	}
}


