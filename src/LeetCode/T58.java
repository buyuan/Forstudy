/**
 * 58. Length of Last Word
Easy

199

26

Add to List

Share
Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.

 

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.
 */
package LeetCode;

public class T58 {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(lengthOfLastWord(s));
	}
	
	public static int lengthOfLastWord(String s) {
	        int start =s.length()-1;
	        int end = s.length()-1;
	        for(int i=s.length()-1;i>=0;i--){
	        	if(s.charAt(i)==' ') {
	        		end--;
	        		start--;
	        	}else {
	        		start--;
	        	}
	        	if(start<end&&start>=0&&s.charAt(start)==' ') {
	        		return end-start;
	        	}
	        }
	        return end - start;
	    }
}
