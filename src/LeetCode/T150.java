/**
 * 150. Evaluate Reverse Polish Notation
Medium
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, and /. Each operand may be an integer or another expression.
Note that division between two integers should truncate toward zero.
It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, 
and there will not be any division by zero operation.

 

Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 

Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
package LeetCode;

import java.util.Stack;

public class T150 {
    public static int evalRPN(String[] tokens) {
    	Stack<Integer> operand = new Stack<>();
        for(String x :tokens) {
        	if(isOperator(x)) {//operater
        		if(operand.size()>=2) {
        			int num1 = operand.pop();
        			int num2 = operand.pop();
        			int curResult = calcu(num1,x,num2);
        			operand.push(curResult);
        		}else {
            		//operater.push(x);
        			return -1;
        		}
        		
        	}else {
        		operand.push(Integer.parseInt(x));
        	}
    	
        }
        return operand.pop();
    }
    
    private static int calcu(int num1, String oper, int num2) {
		switch(oper) {
			case "+":
				return num1+num2;
			case "-":
				return num2-num1;
			case "*":
				return num1*num2;
			case "/":
				return num2/num1;
			default:
				return 0;
		}
	}

	private static boolean isOperator(String x) {
    	String[] operater = {"+","-","*","/"};
    	for(String s : operater) {
    		if(s.equals(x)) {
    			return true;
    		}
    	}
    	
		return false;
	}

	public static void main(String[] args) {
    	String[] case1 = {"2","1","+","3","*"};
    	String[] case2 = {"4","13","5","/","+"};
    	String[] case3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
    	String[] testcase = case3;
    	System.out.println(evalRPN(testcase));
    }
}
