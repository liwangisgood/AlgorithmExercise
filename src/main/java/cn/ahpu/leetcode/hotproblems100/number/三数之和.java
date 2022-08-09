package cn.ahpu.leetcode.hotproblems100.number;

import org.junit.Test;

import java.util.*;

//https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
//solution:https://blog.csdn.net/starflyyy/article/details/106955473
public class 三数之和 {

    static int[] nums = {-1, 0, 1, 2, -1, -4};

    public static void main(String[] args) {
//        System.out.println(threeSum01(nums));
        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length <= 2) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i>0&&nums[i]==nums[i-1]) continue;
            int target=-nums[i];
            int left=i+1,right=nums.length-1;
            while (left<right){
                if (nums[left]+nums[right]==target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));
                    left++;right--;
                    while (left<right&&nums[left]==nums[left-1]) left++;
                    while (left<right&&nums[right]==nums[right+1]) right--;
                }else if (nums[left]+nums[right]<target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return ans;
    }

    //注意要使用引用类型stream 重复元素可以分别构成不同的三元组 无需set去重
    //超时
    public static List<List<Integer>> threeSum01(int[] nums) {
        //nums为空 或非空长度小于3
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }

        Arrays.sort(nums);
        //数组全为正数或负数返回

        if (nums[nums.length - 1] < 0) {
            return list;
        }
        if (nums[0] > 0) {
            return list;
        }
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                pos = i;
                break;
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[k] >= 0) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> asList = new ArrayList<>();
                            asList.add(nums[i]);
                            asList.add(nums[j]);
                            asList.add(nums[k]);
                            if (!list.contains(asList)) {
                                list.add(asList);
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    @Test
    public void test01() {
        String[] num = new String[]{"One", "Two", "Three", "One", "Six"};
        Set<String> set = new HashSet<>(Arrays.asList(num));//不推荐，大小固定不能增删
        System.out.println(set);
        set.add("Seven");
        set.remove("One");
        System.out.println(set);
    }

    @Test
    public void test02() {
        ArrayList<Object> list1 = new ArrayList<>();//[]
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        System.out.println(list);//[]
    }

    @Test
    public void test03() {
        List<Integer> list = null;
        System.out.println(list);
    }

}
