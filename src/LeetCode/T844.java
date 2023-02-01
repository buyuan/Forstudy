package LeetCode;

import java.util.LinkedList;
import java.util.Stack;

public class T844 {
    public boolean backspaceCompare(String s, String t) {
        //用stack，处理完之后对比两个字符串
    	char[] arrS = s.toCharArray();
    	char[] arrT = t.toCharArray();
    	Stack<Character> stkS = new Stack<>();
    	Stack<Character> stkT = new Stack<>();
    	for(char x:arrS) {
    		if(x=='#') {
    			if(stkS.size()>0){stkS.pop();}
    		}else {
    			stkS.add(x);
    		}
    	}
    	for(char x:arrT) {
    		if(x=='#') {
    			if(stkT.size()>0){stkS.pop();}
    		}else {
    			stkT.add(x);
    		}
    	}   	
    	/*
    	while(stkT.size()>0&&stkS.size()>0) {
    		char cS = stkS.pop();
    		char cT = stkT.pop();
    		if(cS!=cT) {
    			return false;
    		}
    	}
    	if(stkT.size()>0||stkS.size()>0) {
    		return false;
    	}
    	*/
    	return String.valueOf(stkS).equals(String.valueOf(stkT));
    }

}

/**
844. Backspace String Compare
Easy

Share
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

 

Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 

Constraints:

1 <= s.length, t.length <= 200
s and t only contain lowercase letters and '#' characters.
*/