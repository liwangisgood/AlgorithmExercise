package cn.ahpu.leetcode.hotproblems100.tree;


import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
public class 二叉树的中序遍历 {
    public static void main(String[] args) {
        TreeNode root = null;
        //root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3,null,null), null));
        root=new TreeNode(1,null,null);
        List<Integer> list = inOrderTraversal(root);
        System.out.println(list);


    }

    public static List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> res=new ArrayList<>();
        inOrder(root,res);
        return res;
    }

    private static void inOrder(TreeNode root, List<Integer> res) {
        if (root==null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

}

