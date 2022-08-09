package cn.ahpu.leetcode.hotproblems100.tree;


/*
* 递归的时间复杂度：与遍历的结点数有关
* 递归的空间复杂度：与递归的深度有关
* https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/er-cha-shu-de-zui-da-shen-du-by-leetcode-solution/
* */
public class 二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode tn0 = new TreeNode(3, null, null);
        TreeNode tn1 = new TreeNode(9, null, null);
        TreeNode tn2 = new TreeNode(20, null, null);
        TreeNode tn3 = new TreeNode(15, null, null);
        TreeNode tn4 = new TreeNode(7, null, null);

        tn0.left=tn1;
        tn0.right=tn2;
        tn2.left=tn3;
        tn2.right=tn4;

        System.out.println(maxDepth01(tn0));

    }


    public static int maxDepth01(TreeNode root) {
        if (root==null){
            return 0;
        }

//        int leftCount=maxDepth01(root.left)+1;//能递归则说明当前结点root 非null  所以+1
//        int rightCount=maxDepth01(root.right)+1;//能递归则说明当前结点root 非null  所以+1

        return Math.max(maxDepth01(root.left),maxDepth01(root.right))+1;

    }
}
