/*
 * 131. Palindrome Partitioning
Medium
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters
 */
package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class T131 {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        helper(res,new ArrayList<>(),s,0);
        return res;
    }

	private static void helper(List<List<String>> res, ArrayList<String> cur, String s, int l) {
		//return case, to the last place of the s
		if(l==s.length()) {
			//先存一下现在cur的值，不然之后会被修改
			res.add(new ArrayList(cur));
			return;
		}
		int len = s.length();
		for(int r=l;r<len;r++) {
			//如果是回文，继续往后找
			if(isP(s,l,r)) {
				cur.add(s.substring(l,r+1));
				helper(res,cur,s,r+1);
				//backtrace
				//出来以后，无论是否找到，都把最后一个结果删掉，返回前面状态，
				cur.remove(cur.size()-1);
			}
		}
	}

	private static boolean isP(String s, int l, int r) {
		while(l<=r) {
			if(s.charAt(l)!=s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		return true;
	}
	public static void main(String[] args) {
		String s1 = "aab";
		String s2 = "a";
		
		String S = s1;
		List<List<String>> res = partition(S);
		for(List<String> e:res) {
			for(String ss:e) {
				System.out.print(ss+"//");
			}
			System.out.println();
		}
	}
}
