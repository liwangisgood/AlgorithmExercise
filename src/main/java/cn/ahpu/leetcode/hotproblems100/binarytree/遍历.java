package cn.ahpu.leetcode.hotproblems100.binarytree;

import org.junit.Test;

import java.util.*;

public class 遍历 {

    TreeNode root = Util.generateBinaryTree();

    public static void main(String[] args) {

    }

    @Test//无返回值的先序遍历
    public void test01() {
        Util.recursivePreOrder(root);// 3 9 15 7 20 6 5
    }

    @Test//有返回值的先序遍历
    public void test02() {
        Queue<Integer> queue = new LinkedList<>();
        queue = Util.returnRecursivePreOrder(root, queue);
        for (Integer integer : queue) {
            System.out.print(" " + integer);// 3 9 15 7 20 6 5
        }
        System.out.println();
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            //3 9 15 7 20 6 5
            System.out.print(" " + queue.poll());//删除队列头部元素并返回该元素
        }
        System.out.println();
        if (queue.isEmpty()) {
            System.out.println("队列为空");//队列为空
        }
    }

    @Test//二叉树中序遍历,返回值为null
    public void test03() {
        Util.recursiveInorder(root);// 15 9 7 3 6 20 5
    }

    @Test//二叉树中序遍历，返回双端队列，并进行遍历
    //还可以起到删除遍历 queue.poll() 返回被删除的元素
    public void test04() {
        Deque<Integer> deque = new LinkedList<>();
        deque = Util.returnRecursiveInorder(root, deque);
        for (Integer integer : deque) {
            System.out.print(" " + integer);// 15 9 7 3 6 20 5
        }
        System.out.println();
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());// 15 9 7 3 6 20 5
        }
    }

    @Test//二叉树后序遍历 返回void
    public void test05() {
        Util.recursivePostOrder(root);// 15 7 9 6 5 20 3
    }

    @Test//二叉树后序遍历 返回Set<Integer>
    public void test06() {
        Set<Integer> set = new HashSet<>();
        set = Util.returnRecursivePostOrder(root, set);
        for (Integer integer : set) {
            System.out.print(" " + integer);// 3 20 5 6 7 9 15 一直是这个排序 不解
        }
        System.out.println();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(" " + iterator.next());// 3 20 5 6 7 9 15
        }
        System.out.println();

        //        forEach
        set.forEach((Integer it)->{
            System.out.print(" "+it);// 3 20 5 6 7 9 15
        });
    }

}
