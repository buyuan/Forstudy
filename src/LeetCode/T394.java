/*
 * 394. Decode String
Medium
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

 

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 

Constraints:

1 <= s.length <= 30
s consists of lowercase English letters, digits, and square brackets '[]'.
s is guaranteed to be a valid input.
All the integers in s are in the range [1, 300].
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class T394 {
    public static String decodeString(String s) {
    	Stack<Character> stk = new Stack<>();    	
    	for(int i=0;i<s.length();i++) {
    		char cur = s.charAt(i);
    		if(cur==']') {
    			List<Character> temp = new ArrayList<>();
    			char c = stk.pop();
    			while(c!='[') {
    				temp.add(c);
    				c=stk.pop();
    			}
    			int time=0;
    			int curser=1;
    			while(!stk.isEmpty()&&Character.isDigit(stk.peek())) {
    				//may be more than 1 digit, curser is for which position the number is 
    				time = time+(stk.pop()-'0')*curser;
    				curser*=10;
    			}
    			while(time>0) {
    				for(int j=temp.size()-1;j>=0;j--) {
    					stk.add(temp.get(j));
    				}
    				time--;
    			}
    		}else {
    			stk.add(cur);
    		}
    	}   	
    	char[] res = new char[stk.size()];
    	for(int i=res.length-1;i>=0;i--) {
    		res[i]=stk.pop();
    	}
    	return new String(res);
    }
    
    public static void main(String[] args) {
    	String S1 = "3[a]2[bc]";
    	String S2 = "3[a2[c]]";
    	String S3 = "100[leetcode]";
    	
    	String S = S3;
    	System.out.println(decodeString(S));
    	
    }
}
