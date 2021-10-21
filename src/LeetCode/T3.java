/**
 * 3. Longest Substring Without Repeating Characters

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 */


package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class T3 {
	public static void main(String[] args) {
		String s ="pwwkew";
		int A = lengthOfLongestSubstring_window1(s);
		System.out.println(A);
	}
	/**
	 * 从头到尾找最长不重复字符串(的长度)
找的方法,一个移动窗口,每次右边界往后移动一个,判断,是否是当前窗口中存在的字符串(移动过程中没出现重复),是,则将左边界更新到上一次出现这个边界的后一个位置,否则继续.
用哈希的优势是,每次确定字符位置,是查询,O(1)复杂度
	 * @param s
	 * @return
	 */
	
	public static int lengthOfLongestSubstring_window(String s){
        if(s.isEmpty()) {
        	return 0;
        }
		HashMap<Character,Integer> ht = new HashMap<>();
		int ans=0;
		char cur=s.charAt(0);
		for(int left=0,right=0;right<s.length();right++) {
			cur=s.charAt(right);
			if(ht.containsKey(cur)) {
				left = max2(left,ht.get(cur)+1);
				ht.replace(cur,right);
				ans = max2(ans,right-left+1);
			}else {
				ht.put(cur,right);
				ans = max2(ans,right-left+1);
			}
			
		}
		return ans;
	}
    private static int max2(int a, Integer b) {
		// TODO Auto-generated method stub
		return a>b?a:b;
	}
	/**
	 * 下面这个用数组做哈希,因为char和int自动转换,应该能快一些
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring_window1(String s){
        if(s.isEmpty()) {
        	return 0;
        }
		int[] ht = new int[128];
		Arrays.fill(ht, -1);
		int ans=0;
		char cur=s.charAt(0);
		for(int left=0,right=0;right<s.length();right++) {
			cur=s.charAt(right);
			if(ht[cur]!=-1) {
				left = max2(left,ht[cur]+1);
				ht[cur]=right;
				ans = max2(ans,right-left+1);
			}else {
				ht[cur]=right;
				ans = max2(ans,right-left+1);
			}			
		}
		return ans;
	}
    
	public static int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) {
        	return 0;
        }
        if(s.length()==1) {
        	return 1;
        }
        return lengthOfLongestSubstring(s,0,s.length()-1);
    }
	private static int lengthOfLongestSubstring(String s, int left, int right) {
		if(left==right) {
			return 1;
		}
		int mid = (left+right)/2;
		int leftMax = lengthOfLongestSubstring( s,  left, mid);
		int rightMax = lengthOfLongestSubstring( s,  mid+1, right);
		String temp=""+s.charAt(mid);
		int midMax=0;
		/*
		 * bvbf ->vbf
		 * while this ->bv, since vbf contains b
		for(int i =mid;i>=left;i--) {
			if(temp.contains(s.substring(i,i+1))) {
				break;
			}else {
				temp = s.charAt(i)+temp;
				midMax++;
			}
		}
		for(int i=mid+1;i<=right;i++) {
			if(temp.contains(s.substring(i,i+1))) {
				break;
			}else {
				temp += s.charAt(i);
				midMax++;
			}
		}*/
		//start from mid midMax
		int maxtemp=0;
		for(int i=mid;i>=left;i--) {
			for(int j =i;j<=right;j++) {
				if(j==mid) {
					maxtemp++;
					continue;
				}
				if(temp.contains(s.substring(j,j+1))) {
					break;
				}else {
					temp += s.charAt(j);
					maxtemp++;
				}
			}
			midMax = midMax>maxtemp?midMax:maxtemp;
			maxtemp=0;
			temp=""+s.charAt(mid);
		}	
		return max(leftMax,rightMax,midMax);
	}
	private static int max(int a, int b, int c) {
		return a>b?(a>c?a:c):(b>c?b:c);
	}
}








