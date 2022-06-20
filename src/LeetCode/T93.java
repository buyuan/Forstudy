/*
 * 93. Restore IP Addresses
Medium
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

 

Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

Constraints:

1 <= s.length <= 20
s consists of digits only.
 */

package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T93 {
	//这里的回溯，不是因为某一段条件不符合所以回溯，而是因为需要遍历完，找到所有符合标准的，
	//回溯是因为，我放了某个点，从这个情况开始往后，所有的都走完检查下
	static List<String> res = new ArrayList<>();
    public static List<String> restoreIpAddresses(String s) {
    	StringBuilder cur = new StringBuilder();
        helper(s,cur, 3, 0);
        return res;
    }
	private static void helper(String s,StringBuilder cur, int dot, int index) {
		//base case
		if(dot==0) {
			String last = s.substring(index);
			if(valid(last)) {
				cur.append("."+last);
				res.add(cur.toString());
			}
			return;
		}
		
		for(int r = index;r< s.length();r++) {
			String tp = s.substring(index,r+1);
			int len = cur.length();
			if(valid(tp)) {
				if(dot==3) {
					//the first part
					cur.append(tp);
					helper(s,cur,dot-1,r+1);
					//固定第一个符合的点的遍历已经完成，下一次就要开始尝试修改固定这个点然后往后走
					cur.setLength(len);
				}else {
					cur.append("."+tp);
					helper(s,cur,dot-1,r+1);
					cur.setLength(len);
				}
			}
		}
	}
	private static boolean valid(String str) {
		int len = str.length();
		if(len>3||len<1) {
			return false;
		}
		
		return (str.charAt(0)=='0')? (len==1):(Integer.valueOf(str)<=255);
	}
	
	
//===============================Here if for another method=======
	static LinkedList<String> aSet = new LinkedList<>();
	public static List<String> restoreIpAddresses_2(String s) {
		   help(s,3,0);
		   return res;
	    }
	
	private static void help(String s, int dot, int index) {
		if(dot==0) {
			String end = s.substring(index);
			if(valid(end)) {
				aSet.add(end);
				res.add(conbine(aSet));
				aSet.removeLast();
			}
			return;
		}
		
		for(int r=index;r<s.length();r++) {
			String sub = s.substring(index,r+1);
			if(valid(sub)) {
				aSet.add(sub);
				help(s,dot-1,r+1);
				aSet.removeLast();
			}
		}
		
	}
	private static String conbine(	LinkedList<String> str) {
		String tp=str.get(0)+"."+str.get(1)+"."+str.get(2)+"."+str.get(3);
		return tp;
	}
	public static void main(String[] args) {
		String S1="25525511135";
		String S2="101023";
				
		String test= S1;
		List<String> res = restoreIpAddresses_2(test);
		for(String s:res) {
			System.out.print(s+"/");
		}
	}
}
