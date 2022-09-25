package cn.ahpu.collection.list;


import org.junit.Test;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class ListTest {


    @Test
    public void test04() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {

//            System.out.println(iterator.next());
//            i++;
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(iterator.next());
            i++;
        }
    }

    //ArrayList中ensureCapacity的使用与优化
    @Test
    public void test03() {
        final int N = 1000000;
        Object obj = new Object();
        ArrayList list1 = new ArrayList();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list1.add(obj);
        }
        System.out.println(System.currentTimeMillis() - start);

        ArrayList list2 = new ArrayList();
        long start2 = System.currentTimeMillis();
        list2.ensureCapacity(N);//显示的对低层数组进行扩容
        for (int i = 0; i < N; i++) {
            list2.add(obj);
        }
        System.out.println(System.currentTimeMillis() - start2);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        int size = 10000 * 1000;
        int index = 5000 * 1000;

        System.out.println("arrayList add " + size);
        addData(arrayList, size);
        System.out.println("linkedList add " + +size);
        addData(linkedList, size);
        System.out.println();

        System.out.println("arrayList get " + index + " th");
        getIndex(arrayList, index);
        System.out.println("linkedList get " + index + " th");
        getIndex(linkedList, index);
        System.out.println();

        System.out.println("arrayList set " + index + " th");
        setIndex(arrayList, index);
        System.out.println("linkedList set " + index + " th");
        setIndex(linkedList, index);
        System.out.println();

        System.out.println("arrayList add " + index + " th");
        addIndex(arrayList, index);
        System.out.println("linkedList add " + index + " th");
        addIndex(linkedList, index);
        System.out.println();

        System.out.println("arrayList remove " + index + " th");
        removeIndex(arrayList, index);
        System.out.println("linkedList remove " + index + " th");
        removeIndex(linkedList, index);
        System.out.println();

        System.out.println("arrayList remove Object " + index);
        removeObject(arrayList, (Object) index);
        System.out.println("linkedList remove Object " + index);
        removeObject(linkedList, (Object) index);
        System.out.println();

        System.out.println("arrayList add");
        add(arrayList);
        System.out.println("linkedList add");
        add(linkedList);
        System.out.println();

        System.out.println("arrayList foreach");
        foreach(arrayList);
        System.out.println("linkedList foreach");
        foreach(linkedList);
        System.out.println();

        System.out.println("arrayList forSize");
        forSize(arrayList);
        System.out.println("linkedList forSize");
//        forSize(linkedList);
        System.out.println("cost time: ...");
        System.out.println();

        System.out.println("arrayList iterator");
        ite(arrayList);
        System.out.println("linkedList iterator");
        ite(linkedList);
    }

    private static void addData(List<Integer> list, int size) {
        long s1 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void getIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.get(index);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void setIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.set(index, 1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void addIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.add(index, 1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void removeIndex(List<Integer> list, int index) {
        long s1 = System.currentTimeMillis();
        list.remove(index);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void removeObject(List<Integer> list, Object obj) {
        long s1 = System.currentTimeMillis();
        list.remove(obj);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void add(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        list.add(1024);
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void foreach(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        for (Integer i : list) {
            //do nothing
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void forSize(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            list.get(i);
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }

    private static void ite(List<Integer> list) {
        long s1 = System.currentTimeMillis();
        Iterator<Integer> ite = list.iterator();
        while (ite.hasNext()) {
            ite.next();
        }
        long s2 = System.currentTimeMillis();
        System.out.println("cost time: " + (s2 - s1));
    }


    /**
     * ArrayList集合的增删改查
     * 遍历：增强for即foreach 迭代器iterator for与size()配合索引获取
     */
    @Test
    public void test01() {
        // 创建ArrayList集合
        List<String> list = new ArrayList<>();
        // 使用add()方法增加元素
        list.add("list");     // 在最新位置添加指定元素
        list.add(1, "hello");     // 在指定位置添加元素
        list.add(2, "java");     // 在指定位置添加元素
        System.out.println(list.toString());
        // 使用get()方法获取指定索引处元素,索引值从0开始
        String s = list.get(0);
        System.out.println(s);
        // 使用set()方法修改指定索引位置的元素值
        list.set(1, "hi");
        System.out.println(list);
        // 使用remove()方法删除指定元素
        list.remove(0);     // 删除指定索引的元素
        list.remove("hi");     // 删除指定元素
        System.out.print(list);
        System.out.println("---------------------------");

    }

    /**
     * LinkedList的增删查改类似于队列，同时拥有双端队列的的操作
     * 队列尾增 add() offer()
     * 队列头删 remove() poll()
     * 队列头查 element() peek()
     * <p>
     * 索引
     * 改   set()
     * 查   get()
     * java
     * 遍历：迭代器listIterator() foreach for循环配合size()
     */
    @Test
    public void test02() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList); //[1,2,3]

        //演示一个删除结点
        linkedList.remove();
        System.out.println(linkedList);//[2,3]
        //修改某个结点对象
        linkedList.set(1, 999);//[2,999] 下标 从0开始
        System.out.println(linkedList);
        //得到某个结点对象
        //get(1)是得到双向链表中的第二个对象
        Object o = linkedList.get(1);
        System.out.println(o);//999

        //因为LinkedList是实现了 List接口，遍历方式可以迭代器 for
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Object o1 = iterator.next();
            System.out.println(o1);
        }
        for (Object o1 : linkedList) {
            System.out.println(o1);
        }
        //普通for循环要看具体的实现类有没有size()方法，有就可以使用
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }
        //源码解读

        /* 1.LinkedList linkedList = new LinkedList();
            public LinkedList(){
            }
            2.这时LinkeList的属性 first = null last = null
            3.执行
         public boolean add(E e) {
              linkLast(e);
              return true;
             }
             4.将新的结点，加入到双向链表的最后
             void linkLast(E e) {
            final Node<E> l = last;
            final Node<E> newNode = new Node<>(l, e, null);
            last = newNode;
            if (l == null)
                first = newNode;
            else
                l.next = newNode;
            size++;
            modCount++;
    }
         */

        /*
          linkedList.remove(); 删除源码
          1.执行
          public E remove() {
              return removeFirst();
          }
          2.执行
            public E removeFirst() {
                final Node<E> f = first;
                if (f == null)
            throw new NoSuchElementException();
            return unlinkFirst(f);
            3.执行unLinkFirst，将f指向的双向链表的第一个结点拿掉
               private E unlinkFirst(Node<E> f) {
                // assert f == first && f != null;
                final E element = f.item;
                final Node<E> next = f.next;
                f.item = null;
                f.next = null; // help GC
                first = next;
                if (next == null)
                    last = null;
                else
                    next.prev = null;
                size--;
                modCount++;
                return element;
            }
          }
         */
    }

}
