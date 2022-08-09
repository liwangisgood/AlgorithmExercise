package cn.ahpu.leetcode.hotproblems100;

//https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
//先排序，再遍历
//异或的性质及其应用：https://www.cnblogs.com/dysjtu1995/p/12271967.html

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class 只出现一次的数字 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 1, 2, 5, 5, 8, 8, 9}));
    }

    private static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i,count);
        }

        for (Integer i:map.keySet()){
            Integer count=map.get(i);
            if(count==1){
                return i;
            }
        }
        return -1;
    }


    @Test
    public void test01() {
        HashMap<Integer, Integer> map = new HashMap<>();
        Integer integer = map.get(12);
        System.out.println(integer);//null

    }
}
