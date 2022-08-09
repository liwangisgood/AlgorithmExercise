package cn.ahpu.leetcode.simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author:liwang
 * @date: 2022/4/11 17:30
 * @Description:TODO
 * @Algorithm Design：TODO
 */
public class 最小栈 {
	public static void main(String[] args) {

	}
}

class MinStack{
	Deque<Integer> xStack;
	Deque<Integer> minStack;

	public MinStack(){
		xStack=new LinkedList<Integer>();
		minStack=new LinkedList<Integer>();
		minStack.push(Integer.MAX_VALUE);
	}

	public void push(int x){
		xStack.push(x);
		minStack.push(Math.min(minStack.peek(),x));
	}

	public void pop(){
		xStack.pop();
		minStack.pop();
	}

	public int top(){
		return xStack.peek();
	}

	public int getMin(){
		return minStack.peek();
	}



}
