package cn.ahpu.leetcode;

/**
 * @author:liwang
 * @date: 2022/3/1 15:34
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class Z字形变换 {

	public static void main(String[] args) {

		System.out.println(convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int numRows) {

		int len = s.length(), numColumns = 0, numStep = 0, stepTemp;

		if (numRows <= 1 || s == null || len == 0) {
			return s;
		}

		//初始化字符串数组 对应数组逻辑 每行元素存储数
		int[] sArr = new int[numRows];
		int arrLen=sArr.length;
		//每次逻辑循环应该便利
		int a = numRows + numRows - 1;
		int cycle = len / a;
		for (int i = 0; i < cycle; i++) {
			for (int j=0;j<arrLen;j++){
				if (j==0||j==arrLen-1){
					sArr[j]++;
				}else {
					sArr[i]+=2;
				}
			}
		}

		for (int i = 0; i < len - a * cycle; i++) {
			sArr[i%arrLen]++;
		}

		//初始化索引步长
		numStep = numRows + (numRows - 2);
		stepTemp = numStep;

		//初始化字符串 对应数组逻辑列数
		if (len % numRows > 0) {
			numColumns = len / numRows + 1;
		} else if (len % numRows == 0) {
			numColumns = len / numRows;
		}

		StringBuilder sb = new StringBuilder();
		int start = 0;
		for (int i = 0; i < numRows - 1; i++) {
			for (int j = start; numStep >= 2 && j < start + sArr[i]; j += numStep) {
				sb.append(s.charAt(j));
			}
			numStep -= 2;
			start += sArr[i];
		}

		for (int i = start; i < start + sArr[arrLen-1]; i += stepTemp) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
