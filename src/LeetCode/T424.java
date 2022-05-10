/*
 * 424. Longest Repeating Character Replacement
Medium
You are given a string s and an integer k. You can choose any character of the string and change it to any other 
uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 */
package LeetCode;

public class T424 {
    public static int characterReplacement(String s, int k) {
    	int size = s.length();
        //滑动窗口, 不一样的字符超过k个,说明不符号条件,窗口就往后走
    	int start =0;int maxC=0;
    	int result=0;
    	int[] Char = new int[26];
    	for(int i=0;i<size;i++) { 		
    		char c = s.charAt(i);
    		int index = c-'A';
    		maxC = max(maxC, ++Char[index]);//一直更新就行,反正只找最大的.maxC一直都是start到i之间最大的一个相同字母
    		while(i-start+1-maxC>k) {
    			//从开始到结束的字符数量,减去目前最大的相同字母的字符数量如果比K大,,说明包不住了
    			char cur = s.charAt(start);
    			
    			Char[cur-'A']--;//start 要移动了,从窗口中去掉
    			start++;
    		}
    		//出来的时候找到一个符合条件的范围
    		result = max(result, i-start+1);
    	}
    	return result;
    }
    
    private static int max(int a, int b) {
		// TODO Auto-generated method stub
    	return a>b?a:b;
	}

	public static void main(String[] args) {
    	String s1 = "ABAB" ;int k1=2;
    	String s2 = "AABABBA"; int k2=1;
    	
    	String s =s2;int k=k2;
    	System.out.println(characterReplacement(s,k));
    }
}
