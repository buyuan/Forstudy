/**
 * 1047. Remove All Adjacent Duplicates In String
Easy

You are given a string s consisting of lowercase English letters. A duplicate removal consists of 
choosing two adjacent and equal letters and removing them.

We repeatedly make duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It can be proven that the answer is unique.

 

Example 1:

Input: s = "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca".
Example 2:

Input: s = "azxxzy"
Output: "ay"
 

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
 */
package LeetCode;

import java.util.Stack;

public class T1047 {
    public static String removeDuplicates(String s) {
    	int size = s.length();
    	Stack<Character> result = new Stack<>();
    	Character temp =null;//use for record the last char 
    	int count=0;
        for(int i=0;i<size;i++) {
        	char c = s.charAt(i);
        	//initialize temp or in case the first letters are removed
        	if(temp==null) {
        		temp = c;
        		result.push(temp);
        		continue;
        	}
    		result.push(c);
        	if(temp!=c) {
        		temp =c;
        	}else{      		
        		count++;
        	}
        	if(count==1) {
        		result.pop();
        		result.pop();
        		count=0;
        		if(!result.isEmpty()) {
        			temp=result.peek();
        		}else {
        			temp =null;
        		}
        	}
        }
        String res = "" ;
        for(char c:result) {
        	res+=c;
        }
        return res;      
    }
    public static void main(String[] args) {
    	String s0 = "";
    	String s1 = "abbaca"; 
    	String s2 ="azxxzy";
    	String s3 = "pbbcggttciiippooaais";
    			
    	String testS = s2; 
    	String result = removeDuplicates(testS);
    	System.out.println(result);
    }
}
