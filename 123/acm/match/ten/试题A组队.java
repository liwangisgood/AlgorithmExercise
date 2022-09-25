package cn.ahpu.acm.match.ten;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * @author:liwang
 * @date: 2022/3/19 13:47
 * @Description:TODO
 * @Algorithm 以下代码写错，题目误解
 * 1~20编号球员 分别在1~5号位置评分
 * 从中在各个位置选出 分数高的球员 且不重复
 */
public class 试题A组队 {

	public static void main(String[] args) {
		BufferedReader br = null;
		ArrayList<String[]> arrayList = new ArrayList<>();
		try {
			br = new BufferedReader(new FileReader("src/main/java/acm/match/ten/team.txt"));
			String s = null;
			while ((s = br.readLine()) != null) {
				String[] s1 = s.split(" ");
				arrayList.add(s1);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
