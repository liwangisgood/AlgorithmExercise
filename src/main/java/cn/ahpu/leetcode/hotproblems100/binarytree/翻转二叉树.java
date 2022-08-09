package cn.ahpu.leetcode.hotproblems100.binarytree;


import org.junit.Test;

import java.util.List;

import static cn.ahpu.leetcode.hotproblems100.binarytree.Util.sequenceOrder;

//https://leetcode.cn/problems/invert-binary-tree/
public class 翻转二叉树 {

    public static void main(String[] args) {

        TreeNode tn0 = Util.generateBinaryTree();
        List<List<Integer>> lists = sequenceOrder(tn0);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }
            /*3
            9 20
            15 7 6 5*/
    }

/*    @Test failure
    public void test04(){
        TreeNode root = Util.generateBinaryTree();

        if (root!=null){
            root=invertBinaryTree()
        }

        root=invertBinaryTree(root);
        Util.recursivePreOrder(root);


    }

    private TreeNode invertBinaryTree(TreeNode root) {
        if (root==null){
            return null;
        }

        invertBinaryTree(root.left);
        invertBinaryTree(root.right);

    }*/

    @Test
    public void test02(){
        TreeNode root = Util.generateBinaryTree();
        Util.recursivePreOrder(root);// 3 9 15 7 20 6 5

    }
    private static TreeNode invertTree(TreeNode root){
        //函数终止条件
        if (root==null){
            return null;
        }

        //当前节点左右子树交换
        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=tmp;

        //分别当前节点左右节点递归交换
        invertTree(root.left);//这里采用的是先序用法形式
        invertTree(root.right);

        //当前节点交换成果返回给调用的递归函数
        return root;
    }


}


