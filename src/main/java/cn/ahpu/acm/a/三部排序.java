package cn.ahpu.acm.a;

import java.util.Arrays;

/**
 * @author:liwang
 * @date: 2022/3/26 14:41
 * @Description:TODO
 * @Algorithm Design：TODO
 * https://blog.csdn.net/qq_42403069/article/details/88070131
 */
public class 三部排序 {

	public static void main(String[] args) {
//如:[0, 1, 4, 56, 2, 9, 3]
		System.out.println(Arrays.toString(sort(new int[]{-2,1,1,0})));

	}

	private static int[] sort(int[] x) {
		int p=0,left=0,right=x.length-1;
		while (p<=right){
			if(x[p]<0){
				int t=x[left];
				x[left]=x[p];
				x[p]=t;
				left++;
				p++;
			}else if(x[p]>0){
				int t=x[right];
				x[right]=x[p];
				x[p]=t;
				right--;
			}else {
				p++;  //填空位置
			}
		}
		return x;
	}
}
