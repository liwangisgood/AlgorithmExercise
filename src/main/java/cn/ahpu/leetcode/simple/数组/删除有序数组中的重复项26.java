package cn.ahpu.leetcode.simple.数组;

/**
 * @author:liwang
 * @date: 2022/3/11 1:18
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 删除有序数组中的重复项26{
	public static void main(String[] args) {

		int[] ints = {2,2,3};
		//删除数组中重复项
		System.out.println(delete(ints));

	}

	private static int delete(int[] ints) {
		int len=ints.length;
		int i=0,j=1;

		if (ints==null){
			return -1;
		}else if (len==1||len==0){
			return len;
		}else if (len>=2){
			for (;j<len;j++){
				if (ints[i]!=ints[j]){
					if (j-i>1){
						ints[i+1]=ints[j];
					}
					i++;
				}else {

				}
			}
		}
		return i+1;
	}
}
