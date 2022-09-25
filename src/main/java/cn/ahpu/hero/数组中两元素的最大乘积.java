package cn.ahpu.hero;

import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author:liwang
 * @date: 2022/3/2 21:44
 * @Description:TODO
 * @Algorithm Design：TODO
 *https://leetcode-cn.com/problems/maximum-product-of-two-elements-in-an-array/solution/yi-bian-bian-li-shuang-bai-tong-guan-by-9pf9o/
 * maxMul02(nums)也可以找到数组中最大的两元素
 *
 * maxMul01(nums)数组中元素两两相乘的元素 构成一个新数组 然后排序 最大值就是目标值
 */
@Component
public class 数组中两元素的最大乘积 {
	public static void main(String[] args) {


		int[] nums={3,4};
		//maxMul01(nums);

		maxMul02(nums);



	}

	private static void maxMul02(int[] nums) {

		int max1=0,max2=0;

		for (int x : nums) {
			if(x>max1){
				max2=max1;
				max1=x;
			}else if(x>max2){
				max2=x;
			}
		}
		System.out.println((max1-1)*(max2-1));


	}

	private static void maxMul01(int[] nums) {

		int len=nums.length;
		if(len<=1){
			System.out.println("<=1");
			return ;
		}
		int[] array=new int[len*(len-1)/2];
		int len1=array.length;

		int index=0;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				array[index++]=(nums[i]-1)*(nums[j]-1);
			}

		}

		Arrays.sort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.println(" "+array[i]);
		}

	}
}
