package cn.ahpu.leetcode.hotproblems100.binarytree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

//二叉树工具类
public class Util {

    //理想情况下 采用列表传参数  如链表元素 null表示无后继节点
    //返回一个二叉树
    //层序遍历 实现
    public static TreeNode generateBinaryIdea(ArrayList<Integer> arraylist) {
        if (arraylist==null){
            return null;
        }
        TreeNode root = new TreeNode();
        for (Integer integer : arraylist) {

        }

        return null;
    }

    //返回一个二叉树root 供其他类调用
    public static TreeNode generateBinaryTree() {
        TreeNode tn0 = new TreeNode(3, null, null);
        TreeNode tn1 = new TreeNode(9, null, null);
        TreeNode tn2 = new TreeNode(20, null, null);
        TreeNode tn3 = new TreeNode(15, null, null);
        TreeNode tn4 = new TreeNode(7, null, null);
        TreeNode tn5 = new TreeNode(6, null, null);
        TreeNode tn6 = new TreeNode(5, null, null);

        tn0.left = tn1;
        tn0.right = tn2;
        tn1.left = tn3;
        tn1.right = tn4;
        tn2.left = tn5;
        tn2.right = tn6;

        return tn0;
    }

    //返回一个二叉树root 供其他类调用
    public static TreeNode generateBinaryTreeTwo() {
        TreeNode tn0 = new TreeNode(3, null, null);
        TreeNode tn1 = new TreeNode(9, null, null);
        TreeNode tn2 = new TreeNode(20, null, null);
        TreeNode tn3 = new TreeNode(15, null, null);
        TreeNode tn4 = new TreeNode(7, null, null);
        TreeNode tn5 = new TreeNode(6, null, null);
        TreeNode tn6 = new TreeNode(5, null, null);

        tn0.left = tn1;
        tn0.right = tn2;
        tn1.left = tn3;
        tn1.right = tn4;
        tn2.left = tn5;
        tn2.right = tn6;

        return tn0;
    }



    //https://blog.csdn.net/qq_43413774/article/details/115488017
    //二叉树进行层序遍历返回List<Integer>类型，每层是该返回对象的一个元素, 数据结构：队列 二叉树 链表
    public static List<List<Integer>> sequenceOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        //根节点放入队列中
        queue.offer(root);//boolean offer(E e);
        if (root == null) return result;
        //当队列为空时，什么全部节点遍历完毕,对待每一层二叉树都是如此循环遍历
        while (!queue.isEmpty()) {

            //这个长度就代表每一层有多少个节点
            //如何把每一层添加到ArrayList集合中，通过队头出队并且依次加入到队列中其该对头元素的左右结点

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            //注意，这里一定要使用静态size，不能使用queue.size()，因为当你弹出一个节点的时候，queue.size()将发生变化
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.peek();//E peek(); 返回队列头部，队列头部为空 返回null
                queue.poll();//E poll();  删除队列头部 并返回，队列为空 返回null
                list.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            result.add(list);
        }
        return result;
    }

    //二叉树先序遍历,返回void
    public static void recursivePreOrder(TreeNode root) {
        if (root == null) {
        } else {
            System.out.print(" " + root.val);//如果递归函数需要返回值，这步骤只需将树中数据加入到  List<Integer> Set<Integer> Queue<Integer>
            recursivePreOrder(root.left);
            recursivePreOrder(root.right);
        }
    }

    //二叉树先序遍历,返回队列
    public static Queue<Integer> returnRecursivePreOrder(TreeNode root, Queue<Integer> queue) {
        if (root == null) {
            return null;
        } else {
            queue.offer(root.val);//已经插入过元素的队列会传递给递归调用的函数，队列在递归中一个一个添加元素
            returnRecursivePreOrder(root.left, queue);
            returnRecursivePreOrder(root.right, queue);
        }
        return queue;
    }

    //二叉树中序遍历，返回void
    public static void recursiveInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursiveInorder(root.left);
        System.out.print(" " + root.val);
        recursiveInorder(root.right);
    }

    //二叉树中序遍历 返回双端队列
    public static Deque<Integer> returnRecursiveInorder(TreeNode root, Deque<Integer> deque) {
        if (root == null) {
            return null;
        }
        returnRecursiveInorder(root.left, deque);
        deque.offer(root.val);//元素插入到队列尾部 ，即通常所说的入队
        returnRecursiveInorder(root.right, deque);
        return deque;
    }

    //二叉树后序遍历 返回void
    public static void recursivePostOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        recursivePostOrder(root.left);
        recursivePostOrder(root.right);
        System.out.print(" " + root.val);
    }

    //二叉树后续遍历，返回Set<Integer>
    public static Set<Integer> returnRecursivePostOrder(TreeNode root, Set<Integer> set) {
        if (root == null) {
            return null;
        }
        returnRecursivePostOrder(root.left, set);
        returnRecursivePostOrder(root.right, set);
        set.add(root.val);
        return set;
    }

}
