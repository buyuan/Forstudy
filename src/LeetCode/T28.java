/**
 * 28. Implement strStr()
Easy

3001

2830

Add to List

Share
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Example 3:

Input: haystack = "", needle = ""
Output: 0
 */

package LeetCode;

public class T28 {
	public static void main(String[] args) {
		String haystack ="a";
		String needle ="a";
		System.out.println(strStr(haystack, needle));
		
	}
    public static int strStr(String haystack, String needle) {
    	int nlength = needle.length();
    	if(nlength==0) {
    		return 0;
    	}
    	int haylen = haystack.length();
    	if(nlength>haylen) {
    		return -1;
    	}
    	boolean found = false;
    	char pointer = needle.charAt(0);
        for(int i =0;i<haystack.length();i++) {
        	if(haystack.charAt(i)==pointer&&(i+nlength<=haylen)) {  
        		found = true;
        		for(int j=1;j<nlength;j++) {
        			if(haystack.charAt(i+j)!=needle.charAt(j)) {
        				found =false;
        				break;
        			}
        		} 
        		if(found) {
        			return i;
        		}
        	}
        }
        	return -1;     
    }
}

