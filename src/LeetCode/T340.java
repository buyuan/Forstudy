/*
340. Longest Substring with At Most K Distinct Characters
Medium

Given a string s and an integer k, 
return the length of the longest substring of s that contains at most k distinct characters.

 

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: The substring is "ece" with length 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: The substring is "aa" with length 2.
 

Constraints:

1 <= s.length <= 5 * 104
0 <= k <= 50
Accepted
262,136
Submissions
555,679
 */
package LeetCode;

import java.util.HashMap;

public class T340 {
	 public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		 //一样的思路,先找到符合条件的,当不符合条件时候,左边往前走,走到符合条件,然后右边再继续,过程中记录最大值
		 int res=0;
		 int l=0;
		 HashMap<Character,Integer> hm = new HashMap<>();	 
		 for(int i=0;i<s.length();i++) {
			 char cur = s.charAt(i);
			 int fre = hm.getOrDefault(cur,0)+1;
			 hm.put(cur, fre);
			 while(hm.size()>k) {
				 char temp = s.charAt(l);
				 int tempFre = hm.get(temp)-1;
				 hm.put(temp, tempFre);
				 l++;
				 if(tempFre==0) {
					 hm.remove(temp);
				 }
			 }
			 int len =i-l+1;
			 res = res>len?res:len;		 
		 }
		 return res;
	 }
	 
	 public static void main(String[] args) {
		 String s1 =  "eceba"; int k1 = 2;
		 String s2 = "aa"; int k2 = 1;
		 String s3 = "ccaabbb"; int k3 =2;
		 String s = s3; int k = k3;
		 
		 System.out.println(lengthOfLongestSubstringKDistinct(s,k));
		 
	 }
}
