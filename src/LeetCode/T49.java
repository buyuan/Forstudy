/**
 * 49. Group Anagrams
Medium
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]
 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class T49 {
	//思路是把每个string排序,找到相同的顺序字符串,然后以此为key,把相同的key的字符串放到一起
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> AnaGroup = new HashMap<>();
        for(String str:strs) {
        	String key = order(str);
        	ArrayList<String> value = AnaGroup.getOrDefault(key, new ArrayList<String>());
        	value.add(str);
        	AnaGroup.put(key,value);
        }
        ArrayList<List<String>> result = new ArrayList<>();
        for(String key:AnaGroup.keySet()) {
        	result.add(AnaGroup.get(key));
        }
        return result;
    }	
    public static String order(String s) {
    	char[] ch = s.toCharArray();
    	Arrays.sort(ch);
    	return new String(ch);
    }
    public static void main(String[] args) {
    	String[] case1 = {"eat","tea","tan","ate","nat","bat"};
    	String[] case2 = {""};
    	String[] case3 = {"a"};
    	
    	String[] testcase =case3;
    	List<List<String>> result = groupAnagrams(testcase);
    	for(List<String> ls:result) {
    		for(String s:ls) {
    			System.out.print(s+",");
    		}
    		System.out.println();
    	}
    }
}
