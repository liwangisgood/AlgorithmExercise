package cn.ahpu.bilibili;

import org.springframework.stereotype.Component;

/**
 * @author:liwang
 * @date: 2022/4/13 14:14
 * @Description:TODO
 * @Algorithm Design：TODO
 */
@Component
public class TestString {
	public static void main(String[] args) {
		String s = new String("");
		if (s==null){
			System.out.println(null+"");
		}else if (s.equals("")){
			System.out.println("为空字符串");
		}
	}
}
