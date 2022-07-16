/*
 * 856. Score of Parentheses
Medium
Given a balanced parentheses string s, return the score of the string.

The score of a balanced parentheses string is based on the following rule:

"()" has score 1.
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: s = "()"
Output: 1
Example 2:

Input: s = "(())"
Output: 2
Example 3:

Input: s = "()()"
Output: 2
 

Constraints:

2 <= s.length <= 50
s consists of only '(' and ')'.
s is a balanced parentheses string.
 */

package LeetCode;

public class T856 {
    public static int scoreOfParentheses(String s) {
    	return find(s,0,s.length());
    }

	private static int find(String s, int l, int r) {
        int res=0;
        int balance=0;
        int size=s.length();
        for(int k=l;k<r;k++) {
        	balance+=(s.charAt(k)=='(')? 1:(-1);
        	if(balance==0) {
        		if(k==l+1) {
        			//仅有一对括号
        			res++;
        		}else {
        			//里面是多组括号，用find计算,实际是计算外面这对括号中有几对括号，所以左右各减去1.
        			res+=2*find(s,l+1,k);
        			
        		}
        		//下一次的循环从k的后面那个index开始
        		l=k+1;
        	}
        }
        
        return res;
	}

	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "(())";
		String s3 = "()()";
				
		String s=s3;
		
		System.out.println(scoreOfParentheses(s));
	}
}
