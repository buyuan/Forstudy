/**
 * [LeetCode] 772. Basic Calculator III 基本计算器之三
 

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ),
 the plus + or minus sign -, non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / 
operators , open ( and closing parentheses ) and empty spaces . The integer 
division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate 
results will be in the range of [-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 

Note: Do not use the eval built-in library function.
 */
package LeetCode;

import java.util.Stack;

public class T772 {

	public static  int calculate(String s) {
		Stack<Integer> preRes = new Stack<>();
		int result =0;
		char operator = '+';
		int temp =0;
		int size = s.length();
		for(int  i=0;i<size;i++) {
			char c = s.charAt(i);
			if(c>='0'&&c<='9') {
				temp = temp*10+(c-'0');
			}else if(c=='(') {
				//find the related ')', then recall the function to calculate it
				int count =1;
				int j=i+1;
				for(i=j;i<size;i++) {
					char cc = s.charAt(i);
					if(cc=='(') {
						count++;
					}
					if(cc==')') {
						count--;
					}
					if(count==0) {
						break;
					}
				}
				String parentheses = s.substring(j, i);
				temp = calculate(parentheses);
			}
			if(i==size-1||c=='+'||c=='-'||c=='*'||c=='/') {
				if(operator == '+') {
					preRes.push(temp);
//					temp =0;
				}else if(operator == '-') {
					preRes.push(temp*(-1));
//					temp =0;					
				}else if(operator == '*') {
					int pre = preRes.pop();
					preRes.push(pre*temp);
//					temp =0;	
				}else if(operator == '/') {
					int pre = preRes.pop();
					preRes.push(pre/temp);
//					temp =0;					
				}
				temp=0;
				operator = c;
			}else {
				continue;
			}
			
		}
		for(int x:preRes) {
			result+=x;
		}
		
		return result;
	}
	public static void main(String[] args) {
    	String case1 = "3+2*2";
    	String case2 = "3/2";
    	String case3 = "3+5/2";
    	String case4 = "1+2*2*2+1";
    	String case5 = "1 + 1";// = 2
    	String case6 = " 6-4 / 2 " ;//= 4
    	String case7 = "2*(5+5*2)/3+(6/2+8)";// = 21
    	String case8 = "(2+6* 3+5- (3*14/7+2)*5)+3";//=-12
    	
    	String testcase = case8;
    	int result = calculate(testcase);
    	System.out.println(result);
	}
}
