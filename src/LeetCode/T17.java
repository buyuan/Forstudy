/**
 * 17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */
package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class T17 {
	public static void main(String[] args) {
		String digits = "34576745";
//		List<String> ans = letterCombinations_DFS(digits);
//		for(String i:ans) {
//			System.out.println(i);
//		}
		List<String> ans = letterCombinations_BFS(digits);
		for(String i:ans) {
			System.out.println(i);
		}

	}
	/////DFS 
	 public static List<String> letterCombinations_DFS(String digits) {
		 	HashMap<Character,String[]> phoneKeyboard = initialMap();
	        List<String> ans = new ArrayList<String>();
		 	if (digits.isEmpty()) {
		 		return new ArrayList<String>() {};
		 	}
	        char carr[] = digits.toCharArray();
	        int index = 0;
	        String cur="";
	        DFS(phoneKeyboard,digits,ans,index,cur);
	        return ans;
	    }



	private static void DFS(HashMap<Character, String[]> phoneKeyboard, String digits, List<String> ans, int index,
			String cur) {
		// TODO Auto-generated method stub
		if(index==digits.length()) {//dummy节点,即,当访问到最后的时候,这条线就结束了
			ans.add(cur);
			return ;
		}
		for(String c: phoneKeyboard.get(digits.charAt(index))) {
			cur+=c;
			DFS(phoneKeyboard,digits,ans,index+1,cur);//每找到一条路,就往深度走
			cur = cur.substring(0,cur.length()-1);
		}
	}

	private static HashMap<Character, String[]> initialMap() {
		// TODO Auto-generated method stub
		HashMap<Character,String[]> mp = new HashMap<>();
		mp.put('2',new String[] {"a","b","c"});
		mp.put('3',new String[] {"d","e","f"});
		mp.put('4',new String[] {"g","h","i"});
		mp.put('5',new String[] {"j","k","l"});
		mp.put('6',new String[] {"m","n","o"});
		mp.put('7',new String[] {"p","q","r","s"});
		mp.put('8',new String[] {"t","u","v"});
		mp.put('9',new String[] {"w","x","y","z"});
		mp.put('0',new String[] {" "});
		return mp;
	}
	
	
	////BSF
	 public static List<String> letterCombinations_BFS(String digits) {
		 	HashMap<Character,String[]> phoneKeyboard = initialMap();
	        List<String> ans = new ArrayList<String>();
		 	if (digits.isEmpty()) {
		 		return new ArrayList<String>() {};
		 	}
	        List<String> temp = new ArrayList<String>();
	        for(String i :phoneKeyboard.get(digits.charAt(0))){
	        	ans.add(i);
	        } 
	        char[] chr = digits.substring(1).toCharArray();
	        for(char x : chr) {//一个按键一个按键的笛卡尔积
		        for(String i :phoneKeyboard.get(x)){
		        	for(String j:ans) {
		        		temp.add(j+i);
		        	}
		        }
		        ans = temp;
		        temp = new ArrayList<String>();
	        }
	        return ans;
	    }

}
