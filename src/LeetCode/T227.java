/**
 * 227. Basic Calculator II
Medium

Given a string s which represents an expression, evaluate this expression and 
return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results 
will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as 
mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7
Example 2:

Input: s = " 3/2 "
Output: 1
Example 3:

Input: s = " 3+5 / 2 "
Output: 5
 

Constraints:

1 <= s.length <= 3 * 105
s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
s represents a valid expression.
All the integers in the expression are non-negative integers in the range [0, 231 - 1].
The answer is guaranteed to fit in a 32-bit integer.
 */
package LeetCode;

import java.util.Stack;

public class T227 {
    public static int calculate(String s) {
    	//思路是把加减号之间的数字计算出来,入栈,然后再遍历栈,依次加起来
        Stack<Integer> Res = new Stack<>();
        int tempNum=0;
        int result=0;
        char operator ='+'; //operator before the number
        int size = s.length();
        for(int i =0;i<size;i++) {
        	char c = s.charAt(i);
        	if(c>='0'&&c<='9') {
        		//numbers
        		tempNum = tempNum*10+(c-'0');
        	}
        	//下面不能是else 因为最后一个数字计算之后也要进一步处理
        	if(i==size-1||c=='+'||c=='-'||c=='*'||c=='/') {
        		//non-number
        		//先把之前的数据入栈
    			if(operator=='+') {
    				Res.push(tempNum);
    			}
    			if(operator=='-') {
    				Res.push(tempNum*(-1));
    			}
    			if(operator=='*') {
    				int pre = Res.pop();
    				Res.push(pre*tempNum);
    			}
    			if(operator=='/') {
    				int pre = Res.pop();
    				Res.push(pre/tempNum);
    			}
            	operator = c;
    			tempNum =0;
        	}else {
        		continue;
        	}

        }
        for(int x:Res) {
        	result+=x;
        }
        return result;
    }
    public static void main(String[] args) {
    	String case1 = "3+2*2";
    	String case2 = "3/2";
    	String case3 = "3+5/2";
    	String case4 = "1+2*2*2+1";

    	
    	String testcase = case4;
    	int result = calculate(testcase);
    	System.out.println(result);
    }
}
