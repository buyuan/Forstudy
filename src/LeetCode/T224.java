/**
 * 224. Basic Calculator
Hard

Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the
evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23
 

Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */
package LeetCode;

import java.util.Stack;

public class T224 {
    public static int calculate(String s) {
    	Stack<Integer> resBefore = new Stack<>();//to store the result before the parentheses
    	int result =0;
    	int tempNum=0;
    	int sign =1;
    	for(int i=0;i<s.length();i++) {
    		char c = s.charAt(i);
    		//+,-,(,), number
    		if(c =='(') {
    			//start to process the content in the parentheses
    			resBefore.push(result);
    			resBefore.push(sign);
    			result =0;
    			sign=1;
    		}else if( c ==')') {
    			//finish the calculation of the last operand first
    			result +=tempNum*sign;//the number in the '()'
    			tempNum =0;
    			//content before '('
    			sign = resBefore.pop();
    			result = result*sign+resBefore.pop();//the last number before 'C'  			
    		}else if(c == '-') {
    			//sign comes from the last operator
    			result+=tempNum*sign;
    			sign = -1;//use for next 
    			tempNum =0;
    		}else if(c =='+') {			
    			result+=tempNum*sign;
    			sign = 1; 	
    			tempNum =0;
    		}else if(c>='0'&&c<='9'){
    			//number, 连续的一个数字,所以每次进位
    			tempNum = tempNum*10+(int)(c-'0');
    		}else {
    			continue;
    		}
    	}
        return result+ tempNum*sign;// 因为先加减符号才有数字,所以最后一个数字没法在for里面计算
    }
    
    public static void main(String[] args) {
    	String cal1 ="499+1+500";
    	String cal2 ="1000-100-50";
    	String cal3 =" 2-1+2";
    	String cal4 =" 2-1 + 2 ";
    	String cal5 ="(1+(4+5+2)-3)+(6+8)";
    	String cal6 ="(1-(4+5+2)-3)+(6+8)";
    	
    	
    	String testcase = cal6;
    	int result = calculate(testcase);
    	System.out.println(result);
    	
    }
}
