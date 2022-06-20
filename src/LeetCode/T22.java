/*
 * 22. Generate Parentheses
Medium
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */
package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class T22 {
	/*
	 * 每次尝试添加左括号，或者添加右括号，同时见检查是否合法，判断方法，左括号不大于n，右括号不大于左括号。
	 * 因为是一个一个括号添加的，添加一次，判断一次，所以不会存在类似于 ”）））（“这种情况。
	 */
	static List<String> res = new LinkedList<>();
	
    public static List<String> generateParenthesis(int n) {
        //start to add ( or )
    	//用String， 正好起了回溯的作用，因为回到上一层，String还是进入下一层之前的那个String
    	//开始我用的String Builder，反而限制了回溯的作用
    	help(n,n,"");
    	return res;
    }

	private static void help(int leftRemain, int rightRemain, String cur) {
		if(leftRemain>rightRemain) {
			//添加的右括号已经比左括号多，这种不合规，所以return
			return;
		}
		if(leftRemain==0 && rightRemain==0) {
			res.add(cur.toString());
			return;
		}
		//左括号还没有添加到n个
		if(leftRemain>0) {
			help(leftRemain-1,rightRemain,cur+"(");
		}
		//右括号添加的数量比左括号少
		if(rightRemain>0) {
			help(leftRemain,rightRemain-1,cur+")");
		}	
	}
    
    public static void main(String[] args) {
    	int n1 = 3;
    	
    	int n=n1;
    	generateParenthesis(n);
    	for(String s:res) {
    		System.out.println(s+"/");
    	}
    }
}
