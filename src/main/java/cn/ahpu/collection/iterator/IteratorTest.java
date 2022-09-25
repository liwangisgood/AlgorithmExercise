package cn.ahpu.collection.iterator;


import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import java.util.*;
@Component
public class IteratorTest {

    public static void main(String[] args) {

    }

    /**
     * 01 - 在List序列的首个元素前添加元素
     * 元素添加在当前索引方向的前面 添加后 当前元素索引值+1但指向的元素不变
     *
     * 02 - 在List序列的末尾元素后添加元素
     * add()插入到索引指针指向的前面 不改变指针指向 会让指针后退表示索引+1
     */
    @Test
    public void test01(){
        String listArr[] = new String[]{"A", "B", "C"};
        List<String> list01 = new LinkedList<>(Arrays.asList(listArr));
        System.out.println("原序列中的元素：" + list01);
        // listIterator();从列表中的指定位置开始，返回列表中元素(按正确顺序)的列表迭代器
        ListIterator<String> listIterator01 = list01.listIterator();
        System.out.println("元素添加之前的索引:"+listIterator01.nextIndex());
        listIterator01.add("Test");
        System.out.println("元素添加之后的索引:"+listIterator01.nextIndex());
        System.out.println("在List序列的首个元素前添加元素：" + list01.toString()+" ");

        System.out.println("------------------------------------------------------------");

        List<String> list02 = new LinkedList<String>(Arrays.asList(new String[]{"A", "B", "C"}));
        ListIterator<String> listIterator02 = list02.listIterator();
        System.out.println("原序列中的元素：" + list02.toString());
        while (listIterator02.hasNext()) {
            listIterator02.next();
        }
        System.out.println("元素添加之前的索引:"+listIterator02.nextIndex());
        listIterator02.add("Test");
        System.out.println("元素添加之后的索引:"+listIterator02.nextIndex());
        System.out.println("在List序列的末尾元素后添加元素：" + list02.toString());

    }


    /**
     * 集合Collection迭代器Iterator
     */
    @Test
    public void test03() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");

/*        System.out.println("Before iterate : " + a);
        a.removeIf("bbb"::equals);
        System.out.println("After iterate : " + a);*/

        System.out.println("Before iterate : " + a);
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String t = it.next();
            if ("bbb".equals(t)) {
                it.remove();
            }
        }
        System.out.println("After iterate : " + a);

        System.out.println("---------------------");
        System.out.println(a);
        ListIterator<String> listIterator = a.listIterator();
        while (listIterator.hasNext()) {
            System.out.print(listIterator.nextIndex()+" ");
            String next = listIterator.next();
            System.out.println(next+" "+listIterator.nextIndex());
        }
    }

    /**
     * ListIterator extends Iterator
     * hasNext()判断当前游标是否有可遍历的元素 next()表示返回当前游标的元素游标并指向下一个
     * 在next()后调用nextIndex() previousIndex()
     */
    @Test
    public void test04() {
        ArrayList<String> a = new ArrayList<String>();
        a.add("aaa");
        a.add("bbb");
        a.add("ccc");
        System.out.println("Before iterate : " + a);
        ListIterator<String> it = a.listIterator();
        while (it.hasNext()) {
//            System.out.println(it.next() + ", " + it.previousIndex() + ", " + it.nextIndex());

            //起初it.nextIndex()返回起始为0的索引 it.nextIndex()后的索引为下一个即将要访问的(需检查)
            System.out.println(it.nextIndex() + " " + it.nextIndex() + " " + it.next() + " " + it.nextIndex());

        }
        System.out.println("----------------------------------");

        /**
         * it.previous()起始索引为最后一个元素的索引(长度-1)
         *
         */
        while (it.hasPrevious()) {
            System.out.println(it.previousIndex() + " " + it.previous() + " " + it.previousIndex());
        }

        System.out.println("----------------------------------");
        it = a.listIterator(1);//调用listIterator(n)方法创建一个一开始就指向列表索引为n的元素处的ListIterator。
        while (it.hasNext()) {
            String t = it.next();
            System.out.println(t);
            if ("ccc".equals(t)) {
                it.set("nnn");
            } else {
//                it.remove();//每次remove()可以add()
                it.add("kkk");
//                it.remove();//每次add()后不能remove()
            }
        }
        System.out.println("After iterate : " + a);
    }


}
