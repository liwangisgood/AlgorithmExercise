package cn.ahpu.leetcode.hotproblems100.binarytree;


//https://leetcode.cn/problems/merge-two-binary-trees/solution/he-bing-er-cha-shu-by-leetcode-solution/
public class 合并二叉树 {
    public static void main(String[] args) {

        //两个相同的二叉树 调用方法不同
        TreeNode root1 = Util.generateBinaryTree();
        TreeNode root2 = Util.generateBinaryTreeTwo();
        TreeNode root=mergeBinaryTree(root1,root2);

        Util.recursivePreOrder(root);// 6 18 30 14 40 12 10
    }

    private static TreeNode mergeBinaryTree(TreeNode root1, TreeNode root2) {

        //调用函数返回 存在参数为null时
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }

        //函数参数两节点都不为null时候执行下列
        TreeNode root = new TreeNode(root1.val,root2.val);
        root.left=mergeBinaryTree(root1.left,root2.left);
        root.right=mergeBinaryTree(root1.right,root2.right);
        return root;
    }
}

