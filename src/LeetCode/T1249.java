/**
 * 1249. Minimum Remove to Make Valid Parentheses
Medium

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either'(' , ')', or lowercase English letter.
 */
package LeetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class T1249 {
    public static String minRemoveToMakeValid(String s) {
        //左括号记录位置,因为需要扫描完才能判断,右括号当时就判断
    	Stack<Integer> positionP = new Stack<>();
    	Set<Integer> index = new HashSet<>();//用来存非法括号下标,用hash set 取值速度也快
    	//char[] sc = s.toCharArray();会超时
    	int size = s.length();
    	for(int i=0;i<size;i++){
    		char c = s.charAt(i);
    		if(c=='(') {
    			positionP.push(i);
    		}else if(c==')') {
    			if(positionP.isEmpty()) {
    				index.add(i);
    			}else {
    				positionP.pop();
    			}
    		}else {
    			continue;
    		}
    	}
    	while(!positionP.isEmpty()) {
    		index.add(positionP.pop());
    	}
    	StringBuffer result = new StringBuffer();
    	for(int i=0;i<size;i++) {
    		if(!index.contains(i)) {
    			result.append(s.charAt(i));
    		}
    	}
    	return result.toString();
    }
    
    public static void main(String[] args) {
    	String case1 = "lee(t(c)o)de)";
    	String case2 = "a)b(c)d";
    	String case3 = "))((";
    	
    	String testcase = case3;
    	String result = minRemoveToMakeValid(testcase);
    	System.out.println(result);
    }
}
