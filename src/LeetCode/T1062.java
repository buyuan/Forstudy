/*
 * [Leetcode 1062] Longest Repeating Substring

Example 1:

Input: “abcd”
Output: 0
Explanation: There is no repeating substring.
Example 2:

Input: “abbaba”
Output: 2
Explanation: The longest repeating substrings are “ab” and “ba”, 
each of which occurs twice.
Example 3:

Input: “aabcaabdaab”
Output: 3
Explanation: The longest repeating substring is “aab”, which occurs 3 times.
Example 4:

Input: “aaaaa”
Output: 4
Explanation: The longest repeating substring is “aaaa”, which occurs twice.
 

Constraints:

The string S consists of only lowercase English letters from ‘a’ - ‘z’.
1 <= S.length <= 1500
 */
package LeetCode;

import java.util.HashSet;

public class T1062 {
	 public static int longestRepeatingSubstring(String S) {
		 //思路就是,二分搜索, 先找一个mid, 如果存在一个子字符串, 重复数量是mid,试一试比mid大的有没有(l=mid+1),如果不存在mid
		 //重复字串,试一试比mid小的(r=mid)
		 int l= 0;int r= S.length()-1;
		 while(l<r) {
			 int m = l+(r-l+1)/2;//用了 l=m 这边要加一,以免死循环
			 if(foundRepeating(m,S)) {
				 //try if there is longer 
				 l=m;
			 }else {
				 r=m-1;
			 }
			 
		 }
		 return l;
	 }
	 
	 private static boolean foundRepeating(int m, String s) {
		// TODO Auto-generated method stub
		//check if s contains a substring with repeating m characters;
		HashSet<String> set = new HashSet<>();
		for(int i=0;i<s.length()-m+1;i++) {
			String sub = s.substring(i, i+m);
			if(set.contains(sub)) {
				return true;
			}
			set.add(sub);
		}
		return false;
	}

	public static void main(String[] args) {
		 String s1= "abcd";
		 String s2= "abbaba";
		 String s3= "aabcaabdaab";
		 String s4= "aaaaa";
		 
		 String s = s1;
		 System.out.println(longestRepeatingSubstring(s));
	 }
}
