/*
 * 5. Longest Palindromic Substring
Medium
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
 */
package LeetCode;

public class T5 {
    public static String longestPalindrome(String s) {
        int startIndex=0;
        int maxLength=0;
        int size = s.length();
        int[] receiver = new int[2];
        for(int i=0;i<size;i++) {
        	if(size-i<maxLength/2) {break;}
        	receiver=findPalindrome(s,i,i,startIndex,maxLength);//odd palindromw
        	if(receiver[1]>maxLength) {
        		maxLength = receiver[1];
        		startIndex = receiver[0];
        	}
        	receiver=findPalindrome(s,i,i+1,startIndex,maxLength);//even palindrome
        	if(receiver[1]>maxLength) {
        		maxLength = receiver[1];
        		startIndex = receiver[0];
        	}
        }
        return s.substring(startIndex,startIndex+maxLength);
    }

    private static int[] findPalindrome(String s, int left, int right, int startIndex, int maxLength) {
		// TODO Auto-generated method stub
    	while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)) {
    		left--;
    		right++;
    	}
    	int[] para = {startIndex,maxLength};
    	if(maxLength<(right-1)-(left+1)+1) {//left and right 在出来之前多移动了一步,所以要退回去
    		para[0] = left+1;
    		para[1]=right-left-1;
    	}
		return para;
	}

	public static void main(String[] args) {
    	String s1 = "babad";
    	String s2 = "cbbd";
    	
    	String s = s2;
    	System.out.println(longestPalindrome(s));
    }
}
