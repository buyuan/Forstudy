/*
 * 1087. Brace Expansion
Medium
You are given a string s representing a list of words. Each letter in the word has one or more options.

If there is one option, the letter is represented as is.
If there is more than one option, then curly braces delimit the options. For example, "{a,b,c}" represents options ["a", "b", "c"].
For example, if s = "a{b,c}", the first character is always 'a', but the second character can be 'b' or 'c'. The original list is ["ab", "ac"].

Return all words that can be formed in this manner, sorted in lexicographical order.

 

Example 1:

Input: s = "{a,b}c{d,e}f"
Output: ["acdf","acef","bcdf","bcef"]
Example 2:

Input: s = "abcd"
Output: ["abcd"]
 

Constraints:

1 <= s.length <= 50
s consists of curly brackets '{}', commas ',', and lowercase English letters.
s is guaranteed to be a valid input.
There are no nested curly brackets.
All characters inside a pair of consecutive opening and ending curly brackets are different.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class T1087 {
	/*
	 * 回溯，
	 * 1.先预处理字符串，相当于需要做笛卡尔积的每个部分拆开
	 * 2.开始回溯
	 */
    public static String[] expand(String s) {
    	//预处理字符串，把每个部分分开,括号内的算一个，不在括号内的，每个单独算一个
    	List<String> ori = new ArrayList<>();
    	int size = s.length();
    	for(int i=0;i<size;i++) {
    		StringBuilder sb = new StringBuilder();
    		int j =i+1;
    		if(s.charAt(i)=='{') {
    			//发现一组大括号			
    			while(s.charAt(j)!='}'&&j<size) {
    				if(s.charAt(j)==',') {
    					j++;
    					continue;
    				}
    				sb.append(s.charAt(j));
    				j++;
    			}
    			ori.add(sb.toString());
    			i=j;
    		}else {
    			ori.add(s.charAt(i)+"");
    		}
    	}
    	
    	//用ori里面的元素，回溯做笛卡尔乘积
    	
    	List<String> res_List = new ArrayList<>();
    	//单词的长度，因为每个元素中选一个，所以有几个元素，就有多长
    	
    	backTrace(res_List,0,ori, new StringBuilder() );
    	int wordSize = res_List.size();
    	String[] res = new String[wordSize];
    	for(int i =0;i<wordSize;i++) {
    		res[i]=res_List.get(i);
    	}
    	Arrays.sort(res);
    	return res;
    	
    }

	private static void backTrace(List<String> res_List, int index , List<String> ori, StringBuilder temp) {
		//回溯，list中每个元素取一个
		if(temp.length() == ori.size()) {
			res_List.add(temp.toString());
			return;
		}
		
		String cur = ori.get(index);
		for(int i=0;i<cur.length();i++) {
			//第一组里面的第一个字符
			temp.append(cur.charAt(i));
			//然后往后面去找
			backTrace(res_List,index+1,ori,temp);
			//那之前trace里面更新的内容去掉，
			temp.setLength(temp.length()-1);
		}
		
		
	}
	
	public static void main(String[] args) {
		String s1 = "{a,b}c{d,e}f";
		String s2 = "abcd";
		String s = s1;
		String[] res = expand(s);
		for(String e :res ) {
			System.out.println(e);
		}

	}
}
