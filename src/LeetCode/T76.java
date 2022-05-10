/*
 * 76. Minimum Window Substring
Hard
Given two strings s and t of lengths m and n respectively, return the minimum window substring of 
s such that every character in t (including duplicates) is included in the window. If there is no such substring, 
return the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

 

Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
Example 2:

Input: s = "a", t = "a"
Output: "a"
Explanation: The entire string s is the minimum window.
Example 3:

Input: s = "a", t = "aa"
Output: ""
Explanation: Both 'a's from t must be included in the window.
Since the largest window of s only has one 'a', return empty string.
 

Constraints:

m == s.length
n == t.length
1 <= m, n <= 105
s and t consist of uppercase and lowercase English letters.
 

Follow up: Could you find an algorithm that runs in O(m + n) time?
 */
package LeetCode;

import java.util.HashMap;

public class T76 {
    public static String minWindow(String s, String t) {
        //先找到满足的字符串,然后缩小滑框,直到刚好不满足,这个就是一个答案,然后右边界往前走,找下一个答案,最终最小那个输出就好
    	int l=0;int sizeS=s.length(); int sizeT=t.length();
    	HashMap<Character,Integer> tRecord = new HashMap<>();
    	for(int i=0;i<sizeT;i++) {
    		char cur = t.charAt(i);
    		int fre = tRecord.getOrDefault(cur, 0)+1;
    		tRecord.put(cur, fre);
    	}
    	int minLen=Integer.MAX_VALUE; //for the ans
    	int count=0;//for find the current result
    	String result="";
    	for(int j=0;j<sizeS;j++) {
    		char cur = s.charAt(j);
    		int fre = tRecord.getOrDefault(cur, 0)-1;
    		tRecord.put(cur,fre);//used, reduce 1, if no such chat in T ,that will be record
    		if(fre>=0) {//the current char is in t
    			count++;			
    		}
			while(count==sizeT) {//just fit the criteria, 
	   				int len = j-l+1;
	   				if(minLen>len) {//try put 'left' go forward, when count<sizeT, means current substirng(l j+1) is just not fir
	   					minLen=len;
	   					result = s.substring(l,j+1);
	   				}
					char lcur=s.charAt(l++);
					int lfre =tRecord.get(lcur)+1;
					tRecord.put(lcur,lfre);//去掉了,加回来
					if(lfre>0) {//直到当0以上的才是原来t有的,count才需要--,因为负数有可能是存在比t中更多次数的这个字符
						count--;
					}
			}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
    	String s1 = "ADOBECODEBANC" ; String t1 = "ABC";
    	String s2 = "a";String t2 = "a";
    	String s3 = "a";String t3 = "aa";
    	String s4 = "bba"; String t4 = "ab";
    	String s5 = "bbba"; String t5 = "ab";
    	String s = s5;String t=t5;
    	System.out.println(minWindow(s,t));
    }
}
