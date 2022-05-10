/*
 * 409. Longest Palindrome
Easy

Given a string s which consists of lowercase or uppercase letters, 
return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Example 3:

Input: s = "bb"
Output: 2
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
package LeetCode;

import java.util.HashMap;

public class T409 {
    public int longestPalindrome(String s) {
        //用hashmap统计字符出现次数, 找偶数的,奇数的可以保留一个
    	HashMap<Character, Integer> hm = new HashMap<>();
    	int result=0;
    	for(int i=0;i<s.length();i++){
    		char c = s.charAt(i);
    		int fre = hm.getOrDefault(c,0);
    		if(fre%2==1) {
    			//奇数
    			result+=(fre+1);//找到这个说明就是偶数了,加上,然后重新置零
    			hm.put(c,0);
    		}else {
    			hm.put(c,1);
    		}    		
    	}
    	int ifOdd=0;
    	for(char c :hm.keySet()) {
    		if(hm.get(c)==1) {
    			ifOdd=1;
    			break;
    		}
    	}
    	return result+ifOdd;
    	
    }
    
    
    
    public static void main(String[] args) {
    	
    }
}
